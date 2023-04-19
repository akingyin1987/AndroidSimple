package com.example.androidsimple.base

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/12 12:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/12 12:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class BaseActivity<T: ViewBinding>:AppCompatActivity() {
     val TAG: String = this.javaClass.simpleName+this.hashCode()

    lateinit  var    binding:T

     abstract fun getViewBinding(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        initBindDataAndUi()
        Log.d(TAG,"onCreate")
    }



    abstract fun  initBindDataAndUi()


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG,"onNewIntent")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
}