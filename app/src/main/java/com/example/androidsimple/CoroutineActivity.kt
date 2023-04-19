package com.example.androidsimple

import android.os.Looper
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.ActivityCoroutineBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/12 16:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/12 16:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class CoroutineActivity: BaseActivity<ActivityCoroutineBinding>() {

    override fun getViewBinding(): ActivityCoroutineBinding {
       return  ActivityCoroutineBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
            binding.btnStart1.setOnClickListener {
                startCoroutineTest1()
            }
    }


    private fun  startCoroutineTest1(){
        Looper.myLooper()
    }

}