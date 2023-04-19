package com.example.androidsimple

import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.ActivityTreadSafeActivityBinding

/**
 * ThreadLocal直译为线程局部变量，或许将它命名为ThreadLocalVariable更为合适。
 * 其主要作用就是实现线程本地存储功能，通过线程本地资源隔离，解决多线程并发场景下线程安全问题
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/17 11:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/17 11:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class AndroidThreadSafeActivity : BaseActivity<ActivityTreadSafeActivityBinding>(){



    override fun getViewBinding(): ActivityTreadSafeActivityBinding {
       return  ActivityTreadSafeActivityBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
        binding.btnThreadLocal.setOnClickListener {

        }
    }
}