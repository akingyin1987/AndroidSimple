**# Android四大动画 #**

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