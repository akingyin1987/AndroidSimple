package com.example.androidsimple.animation

import android.graphics.drawable.AnimationDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.androidsimple.R
import com.example.androidsimple.base.BaseFragment
import com.example.androidsimple.databinding.AnimationFragmentFrameBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/3 14:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/3 14:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class FrameAnimationFragment:BaseFragment<AnimationFragmentFrameBinding>() {

    override fun initBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): AnimationFragmentFrameBinding {
       return AnimationFragmentFrameBinding.inflate(inflater,container,false)
    }

    override fun initBindDataAndUid() {
          binding.btnAnimation1.setOnClickListener {
              //帧动画使用的是AnimationDrawable
              val animationDrawable = AnimationDrawable()
              for (i in 1..11){
                  //val id = resources.getIdentifier("g${i}", "drawable", "")
                  when(i % 3){
                      1-> ContextCompat.getDrawable(requireContext(), R.drawable.qmui_icon_notify_done)?.let {drawable->
                          println("加入帧动画111")
                          //加入帧动画
                          animationDrawable.addFrame(drawable,300)
                      }
                      2-> ContextCompat.getDrawable(requireContext(), R.drawable.qmui_icon_notify_error)?.let {drawable->
                          //加入帧动画
                          println("加入帧动画111")
                          animationDrawable.addFrame(drawable,300)
                      }
                      else->{
                          println("加入帧动画111")
                          ContextCompat.getDrawable(requireContext(), R.drawable.qmui_icon_notify_info)?.let {drawable->
                              //加入帧动画
                              animationDrawable.addFrame(drawable,300)
                          }
                      }
                  }


              }

              //循环播放
              animationDrawable.isOneShot = false
              binding.ivTest2.background = animationDrawable
              animationDrawable.start()
          }
    }
}