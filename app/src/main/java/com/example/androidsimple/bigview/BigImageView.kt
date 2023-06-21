package com.example.androidsimple.bigview

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapRegionDecoder
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Rect
import android.os.Build
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller
import java.io.InputStream

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/21 14:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/21 14:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class BigImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr), GestureDetector.OnGestureListener,View.OnTouchListener  {

    /** 指定要加载的区域 */
    private var mRect: Rect = Rect()

    /** 图片压缩利用参数 */
    private var mOptions = BitmapFactory.Options()

    /** 手势识别类 */
    private var mGestureDetector = GestureDetector(context,this)

    /** 滑动帮助 */
    private var mScroller = Scroller(context)

    /** 图片的宽 */
    private var mImageWidth:Int = 0
    /** 图片高 */
    private var mImageHeight:Int = 0

    /** 区域解码器 */
    private var mDecoder: BitmapRegionDecoder?= null

    /** 当前View 的宽 */
    private var mViewWidth:Int = 0
    /** 当前View 的高 */
    private var mViewHeight:Int = 0

    private var bitmap: Bitmap?= null

    init {
        setOnTouchListener(this)
    }


    /**
     * 设置长图的流
     * @param inputStream InputStream
     */
    fun setLongImage(inputStream: InputStream){
        //先读取原图上的信息，高宽
        mOptions.inJustDecodeBounds = true
        BitmapFactory.decodeStream(inputStream,null,mOptions)
        mImageWidth = mOptions.outWidth
        mImageHeight = mOptions.outHeight
        //开启复用模式 设置bitmap 缓存 区可以被修改
        mOptions.inMutable = true
        mOptions.inPreferredConfig = Bitmap.Config.RGB_565
        mOptions.inJustDecodeBounds = false
        try {
            mDecoder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                BitmapRegionDecoder.newInstance(inputStream)
            }else{
                BitmapRegionDecoder.newInstance(inputStream,false)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        requestLayout()

    }

    /** 当前view 与 真实图的缩放比例 (以宽为基准) */
    private var mScale:Float = 1F
    /** 绽放矩阵 */
    private val matrix = Matrix()
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 在测量的时候把我们需要的内存区域获取到  存入到mRect中
        mViewWidth = measuredWidth
        mViewHeight = measuredHeight

        //确定要加载的图片区域,从左上角开始，宽度与view铺满，再计算高度
        mRect.left = 0
        mRect.top = 0
        mRect.right = mViewWidth
      //  mScale = mViewWidth/mImageWidth.toFloat()
        //通过绽放比例 计算显示的区域高度
        mRect.bottom = (mViewHeight/mScale).toInt()
        matrix.reset()
        matrix.setScale(mScale, mScale)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mDecoder?.let {
            //得用上一张bitmap 内存 不用重新分配及销毁旧Bitmap
            mOptions.inBitmap = bitmap
            //解码指定区域
            mDecoder?.decodeRegion(mRect,mOptions)?.let {
                bitmap = it
                canvas?.drawBitmap(it, matrix, null)
            }


        }
    }


    /**
     * 手按下的回调
     * @param e MotionEvent
     * @return Boolean
     */
    override fun onDown(e: MotionEvent): Boolean {
        //如果移动还没有停止，强制停止
        if(!mScroller.isFinished){
            mScroller.forceFinished(true)
        }
        //继续接收后续事件
        return true
    }

    /**
     * 使用上一个接口的计算结果
     */
    override fun computeScroll() {
        if(mScroller.isFinished){
            return
        }
        // true 表示当前滑动还没有结束
        if(mScroller.computeScrollOffset()){
            // 当前滑动后的坐标 发生滑动后需要重置
            mRect.top = mScroller.currY
            mRect.bottom = (mRect.top+(mViewHeight/mScale)).toInt()

            invalidate()
        }
    }
    override fun onShowPress(e: MotionEvent) {

    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return false
    }


    /**
     *
     * @param e1 MotionEvent 接下
     * @param e2 MotionEvent 移动
     * @param distanceX Float  左右移动时的距离
     * @param distanceY Float  上下移动时的距离
     * @return Boolean
     */
    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float,
    ): Boolean {


        mRect.offset(distanceX.toInt(), distanceY.toInt())
        //处理移动时已经移到了两个顶端的问题
        if(mRect.left <0){
            mRect.left = 0
            mRect.right = mViewWidth
        }
        if(mRect.right>mImageWidth){
            mRect.right = mImageWidth
            mRect.left = mImageWidth - mViewWidth
        }
        if (mRect.bottom > mImageHeight) {
            mRect.bottom = mImageHeight
            mRect.top = mImageHeight - (mViewHeight / mScale).toInt()
        }
        if (mRect.top < 0) {
            mRect.top = 0
            mRect.bottom = (mViewHeight / mScale).toInt()
        }
        invalidate()
        return false
    }

    override fun onLongPress(e: MotionEvent) {

    }


    /**
     * 处理惯性问题
     * @param e1 MotionEvent
     * @param e2 MotionEvent
     * @param velocityX Float  每秒移动的x点
     * @param velocityY Float
     * @return Boolean
     */
    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float,
    ): Boolean {
        mScroller.fling(mRect.left,mRect.top,
            velocityX.toInt(), (-velocityY).toInt(),
            0,mImageWidth - mViewWidth,
            0, (mImageHeight-(mViewHeight/mScale)).toInt()
        )
        return false
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        //交给手势处理
        return  event?.let { mGestureDetector.onTouchEvent(event) }?:false

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        mDecoder?.recycle()
    }
}