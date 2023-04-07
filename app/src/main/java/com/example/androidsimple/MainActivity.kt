package com.example.androidsimple

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidsimple.databinding.MainBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/3 12:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/3 12:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MainActivity : AppCompatActivity() {

    private  lateinit var  bindView:MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView = MainBinding.inflate(layoutInflater)
        setContentView(bindView.root)
        bindView.btnAndroidAnimation.setOnClickListener {
           startActivity(Intent(this,AnimationActivity::class.java))
        }
    }
}