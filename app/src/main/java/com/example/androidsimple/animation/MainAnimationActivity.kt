package com.example.androidsimple.animation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidsimple.R

import com.example.androidsimple.databinding.ActivityMainComponentBinding


/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/3 15:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/3 15:42
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MainAnimationActivity : AppCompatActivity() {

    private lateinit var  bindView : ActivityMainComponentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView = ActivityMainComponentBinding.inflate(layoutInflater)
        setContentView(bindView.root)
        val  fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.disallowAddToBackStack()
        when(intent.getStringExtra("keyCode")?:""){
            "animation-frame"->{
               // 1.replace()方法每次提交Fragment的时候都会清理FragmentManage的Fragment栈中其他所有的Fragment，只保留当前传入的Fragment，正因为如此不建议replace()与add()方法混合使用
                //
                //　　2.replace()方法每次提交Fragment(不管是不是相同的Fragment)，都会让Fragment重新创建
              // fragmentTransaction.replace(R.id.fragment_root,FrameAnimationFragment())

               fragmentTransaction.add(R.id.fragment_root,FrameAnimationFragment())
            }
            "animation-tween"->{
                // 1.replace()方法每次提交Fragment的时候都会清理FragmentManage的Fragment栈中其他所有的Fragment，只保留当前传入的Fragment，正因为如此不建议replace()与add()方法混合使用
                //
                //　　2.replace()方法每次提交Fragment(不管是不是相同的Fragment)，都会让Fragment重新创建
                // fragmentTransaction.replace(R.id.fragment_root,FrameAnimationFragment())

                fragmentTransaction.add(R.id.fragment_root,TweenAnimationFragment())
            }
        }
        fragmentTransaction.commit()
    }
}