package com.example.androidsimple

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidsimple.animation.MainAnimationActivity
import com.example.androidsimple.databinding.ActivityAnimationBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/3 12:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/3 12:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class AnimationActivity :AppCompatActivity(){

    lateinit var  bindView: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(bindView.root)
        bindView.btnFramAnimation.setOnClickListener {
             startActivity(Intent(this,MainAnimationActivity::class.java).apply {
                 putExtra("keyCode","animation-frame")
             })
        }
        bindView.btnTweenAnimation.setOnClickListener {
            startActivity(Intent(this,MainAnimationActivity::class.java).apply {
                putExtra("keyCode","animation-tween")
            })
        }
    }
}