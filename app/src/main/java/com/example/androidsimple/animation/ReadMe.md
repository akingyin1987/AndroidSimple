# Android四大动画 

动画主要分为 4 种，分别是 帧动画, 矢量动画, 补间动画, 属性动画。

**1. 帧动画**
	
----------
帧动画，顾名思义就是通过一张张图片通过快速切换而到达的一种视觉效果，看起来像图片中的物体动起来一般，我们平常说的 60帧，120帧，指的就是一秒钟播放 60张图片或 120 张图片。

Frame动画是一系列图片按照一定的顺序展示的过程，它的原理是在一定的时间段内切换多张有细微差异的图片从而达到动画的效果
可以定义在xml文件中，代码实现使用到AnimationDrawable对象

----------
在xml文件中添加图片
在 res -> drawable 下面将这一系列连续的图片加入进去。然后新建一个名为 fire_animation 的 xml 文件，在文件中给每个 item 添加图片资源和显示时长，如下：

    <animation-list xmlns:android="http://schemas.android.com/apk/res/android">
    
    <item android:drawable="@drawable/campfire01" android:duration="80"/>
    <item android:drawable="@drawable/campfire02" android:duration="80"/>
    <item android:drawable="@drawable/campfire03" android:duration="80"/>
    <item android:drawable="@drawable/campfire04" android:duration="80"/>
    <item android:drawable="@drawable/campfire05" android:duration="80"/>
    <item android:drawable="@drawable/campfire06" android:duration="80"/>
    <item android:drawable="@drawable/campfire07" android:duration="80"/>
    <item android:drawable="@drawable/campfire08" android:duration="80"/>
    <item android:drawable="@drawable/campfire09" android:duration="80"/>
    <item android:drawable="@drawable/campfire10" android:duration="80"/>
    <item android:drawable="@drawable/campfire11" android:duration="80"/>
    <item android:drawable="@drawable/campfire12" android:duration="80"/>
    <item android:drawable="@drawable/campfire13" android:duration="80"/>
    <item android:drawable="@drawable/campfire14" android:duration="80"/>
    <item android:drawable="@drawable/campfire15" android:duration="80"/>
    <item android:drawable="@drawable/campfire16" android:duration="80"/>
    <item android:drawable="@drawable/campfire17" android:duration="80"/>
    </animation-list>

注意： 根节点如果是 set 的话，是不能循环动画的，只能播放一次就结束

## xml实现 ##

----------


- 使用< animation-list>作为根元素，包含一个或多个< item>元素，放在drawable目录下
- android:onshot如果是true的话，动画只会执行一次，false则一致循环
- android:drawable指定此帧动画所对应的图片资源
- android:dutation代表此帧持续的时间，单位是毫秒

----------
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:background="@drawable/frame" />


- 在代码中启动

    val drawable = imageView.background as AnimationDrawable

    drawable.start()

----------

## 代码实现 ##

        //帧动画使用的是AnimationDrawable
        val animationDrawable = AnimationDrawable()
        for (i in 1..11) {
            val id = resources.getIdentifier("g${i}", "drawable", packageName)
            val drawable = resources.getDrawable(id)
            //加入帧动画
            animationDrawable.addFrame(drawable, 300)
        }
        //循环播放
        animationDrawable.isOneShot = false
        //设置view的背景
        imageView.background = animationDrawable
        animationDrawable.start()

    推荐使用xml方式，因为将动画和代码中隔离，使动画更容易维护
    帧动画使用比较简单，但是比较容易引起OOM，所以在使用帧动画时应尽量避免使用过多尺寸较大的图片


## 属性动画

### 1.1 为什么要用属性动画

- 补间动画功能比较单调,只有四种动画(透明度,旋转,倾斜和位移)
- 补间动画针对的对象只是UI控件
- 补间动画只是改变View的显示效果,不会去改变View的属性

eg:左边的按钮移到右边,但是此时的按钮其实还停留在左边，假如你去点右面的按钮,是不会触发按钮的点击事件的~

### 1.2 属性动画是什么
- Andoid 3.0引入,可以说是补间动画的增强版,不止可以实现四种动画效果,可以定义任何属性的变化
- 执行动画的对象不只是U控件。可以对任何对象执行动画(不管是否显示在屏幕上)
- 属性动画通过对目标对象进行赋值来修改其属性，上面那个按钮问题就不存在了

### 1.3 属性动画常用API

     -: 设置内容和标题栏居右对齐。
    :- 设置内容和标题栏居左对齐。
    :-: 设置内容和标题栏居中对齐

|  Api   | 说明  |
|  :----:  | :----:  |
|  Animator | 创建属性动画的基类，一般不会直接使用，一般用他的两个子类 |
| ValueAnimator  | 属性动画是通过不断的修改值来实现的，面初始值和结束值间的过度动画就由就该类来负责计算的。内部采用一种时间循环的机制来计算值与值之间的动画过度，我们只需初始值以及结束值提供给该类，并告诉它动画所需时长，该类就会自动帮我们完成从初始值平滑过渡到结束值这样的效果，另外还负责管理动画播放次数，播放模式，以对动画设置的监听 |
|  ObjectAnimator  |  ValueAnimator的子类，允许我们对指定对象的属性执行动画，用起来更加简单，实际中用得较多，当然某些场合下，可能 还是需要用到ValueAinmator  |
|  AnimatorSet  |  Animator的子类，用于组合多个Animator,并制定多个Animator按照次序播放，告诉动画系统如何从初始值过度到结束值，提供了下述几种Evaluator  |
|  Evaluator  |  -IntEvaluator:用于计算int类型属性值的计算器   FloatEvaluator:用于计算Float类型值的计算器,ArgbEvaluator:用于计算十六进制形式表示的颜色值计算器，TypeEvaluator:计算器的接口，我们可以实现该接口来完成自定计算器|

### 1.4使用流程
1. 调用ValueAnimator 的OfInt()或ofObject()等静态方法创建ValueAnimator实例
2. 调用实例的setXxx方法设置动画持续时间，插值方式，重复次数等
3. 调用实例的addUpdateListener添加AnimatorUpdateListener监听器，在该监听器中 可以获得ValueAnimator计算出来的值，你可以值应用到指定对象上
4. 调用实例的start()方法开启动画！ 另外我们可以看到ofInt和ofFloat都有个这样的参数：float/int... values代表可以多个值！
