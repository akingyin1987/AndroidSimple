package com.example.androidsimple.animation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.view.animation.Animation.AnimationListener
import android.widget.AdapterView
import android.widget.ArrayAdapter

import com.example.androidsimple.base.BaseFragment
import com.example.androidsimple.databinding.FragmentTweenAnimationBinding

/**
 * 补间动画，View动画效果可以实现简单的透明度（alpha）、位置移动(translate)、绽放（scale）、旋转(rotate)
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/7 14:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/7 14:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class TweenAnimationFragment : BaseFragment<FragmentTweenAnimationBinding>(){

    override fun initBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentTweenAnimationBinding {
       return  FragmentTweenAnimationBinding.inflate(inflater,container,false)
    }

    override fun initBindDataAndUid() {
        //插入器
        binding.spInterpolator.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            listOf("请选择","AccelerateInterpolator 加速，开始时慢中间加速",
                "DecelerateInterpolator 减速开妈快然后减速",
                "AccelerateDecelerateInterpolator 先加速后减速 开始结束时慢,中间快",
                "AnticipateInterpolator 反向，先向相反方向改变一段再加速",
                "AnticipateOvershootInterpolator",
                "BounceInterpolator",
                "CycleInterpolator",
                "LinearInterpolator",
                "OvershootInterpolator"
            )
        )
        binding.spInterpolator.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                binding.btnAnimation.text = getButtonText()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        binding.rgTween.setOnCheckedChangeListener { _, _ ->
            binding.btnAnimation.text = getButtonText()
        }
        binding.btnAnimation.setOnClickListener {
           doTweenAnimation()
        }
    }

    private  fun  getButtonText():String{
        val str:String  = when{
            binding.rbAlpha.isChecked->{
                "Alpha "
            }
            binding.rbRotate.isChecked->{
                "Rotate"
            }
            binding.rbScale.isChecked->{
                "Scale"
            }
            binding.rbTranslate.isChecked->{
                "Translate"
            }
            else->{
                ""
            }
        }+if(binding.spInterpolator.selectedItemPosition>0) binding.spInterpolator.selectedItem.toString() else ""



        return  str
    }


    private fun doTweenAnimation(){
         val animation: Animation= when{
             binding.rbAlpha.isChecked->{
                 AlphaAnimation(0.1F,1F)
             }
             binding.rbRotate.isChecked->{
                 // fromDegrees 表示动画起始时的角度 .
                  // toDegrees 青蛙结束时物件旋转的角度，可以大于 360
                 // (toDegrees - fromDegrees) 为负数是表示 逆时针旋转 。为正数 表示 为顺时针旋转
                 //
                 RotateAnimation(-9F,160F).apply {
                   //重复次数
                   repeatCount = 2

                 }
             }
             binding.rbScale.isChecked->{
                 //缩放
                 ScaleAnimation(1F,0.1F,1F,0.1F)
             }

             else -> {
                 //移动
                 TranslateAnimation(-50F,50F,0f,0F)
             }
         }

         //设置动画持续时间
         animation.duration = 2000
         //决定 动画结束后view最终的显示位置是不是动画结束的位置
         animation.fillAfter = false
         animation.fillBefore = true
          //而fileEnable参与决定在动画开始之前 view的位置 是不是动画起始位置（因为动画的开始位置可能离view的布局位置有一定偏差）。
        // 可以使用setAnimation来提前设置 在动画开始之前的animation显示
        //
        //如果fillEnable为true，动画可能不会立即开始(考虑到animation可能设置delay)，不过如果
        //同时设置了fillBefore为true,那么此刻view的显示位置就变为动画的开始位置。(动画会立即开始(start的监听回调被调用)
        //如果fillBefore为false,一切照旧等待动画开始时动画运行（start的监听回调在动画开始时调用）。
        //
        //如果fillEnable为false，不管动画有没有延迟，动画都会立刻开始.
        //此时fillBefore变量无用，view可能会在动画开始位置停留一段时间，然后动画正式运行。
        //
        //总而言之，如果你没有为animation设置delay。fillEnable和fillBefore你无需关心，如果你设置了delay为1000ms,那么
        //如果你想在这1000ms期间view保持在原始位置(非动画开始位置)，就设置fillEnable=true && fillBefore=false【必须设置】,否则
        //view的动画会在立刻开始
         animation.isFillEnabled = false
        when(binding.spInterpolator.selectedItemPosition){
            1->{
                animation.interpolator = AccelerateInterpolator()
            }
            2-> {
                animation.interpolator = DecelerateInterpolator()
            }
            3->{
                animation.interpolator = AccelerateDecelerateInterpolator()
            }
            4->{
                animation.interpolator = AnticipateInterpolator()
            }
            5-> animation.interpolator = AnticipateOvershootInterpolator()
                //跳跃，快到上拍值 时会跳跃，如目的值为100 ，后面的值可能 依次为 85，77，70，80，90，100
            6-> animation.interpolator = BounceInterpolator()
               // 循环，动画循环一定次数，值的改变为一正弦函数
            7-> animation.interpolator = CycleInterpolator(20F)
                //线性，纯属均匀改变
            8-> animation.interpolator = LinearInterpolator()
            // 超越，最后超出目的值然后缓慢改变到目的值
            9-> animation.interpolator = OvershootInterpolator()
        }

         binding.ivImage.animation?.cancel()
        // binding.ivImage.animation = animation
         animation.setAnimationListener(object :AnimationListener{
             override fun onAnimationStart(animation: Animation?) {
                 println("onAnimationStart")
                 binding.tvInfo.text ="动画状态：onAnimationStart"
                // binding.btnAnimation.isEnabled = false
             }

             override fun onAnimationEnd(animation: Animation?) {
                 println("onAnimationEnd")
                 binding.tvInfo.text ="动画状态：onAnimationEnd"
                // binding.btnAnimation.isEnabled = true
             }

             override fun onAnimationRepeat(animation: Animation?) {
                println("onAnimationRepeat")
                 binding.tvInfo.text ="动画状态：onAnimationRepeat"
             }
         })
         binding.ivImage.startAnimation(animation)
    }
}