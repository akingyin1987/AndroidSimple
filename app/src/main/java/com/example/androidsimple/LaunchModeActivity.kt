package com.example.androidsimple

import android.content.Intent
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.ActivityLaunchModeBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/12 14:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/12 14:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class LaunchModeActivity : BaseActivity<ActivityLaunchModeBinding>() {
    override fun getViewBinding(): ActivityLaunchModeBinding {
        return ActivityLaunchModeBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
        binding.btnStandard.setOnClickListener {
            startActivity(Intent(this, LaunchModeActivity::class.java).apply {
                //根据Activity 的affinity（一个app系统默认affinity的值为包名，task自身的affinity的值取决于根activity的affinity，相同affinity的activity属于同一个task）寻找task 栈，如果一个task 的 affinity与 activity 的 affinity的相同，则直接把这个栈整体移动到前台，并保持栈中的状态不变并将Activity压入栈中。如果没有找到相同的，则新建立栈，并且把activity压入栈中

                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            })
        }

        binding.btnSingleTop.setOnClickListener {
            startActivity(Intent(this, LaunchModeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            })

        }
        binding.btnSingleTask.setOnClickListener {
            startActivity(Intent(this, LaunchModeActivity::class.java).apply {
                //单独使用 如果栈中存在，则会清除目标栈至顶部栈，并创建新的Activity() 入到顶栈
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

            })
        }
        binding.btnSingleInstance.setOnClickListener {
            startActivity(Intent(this, LaunchModeActivity::class.java).apply {
                //task里面的已经存在的activity先清空 ,然后该activity 再在该task 中启动这个新启动的activity变为了这个空task的根activity.所有老的activity都结束掉。该标志必须和FLAG_ACTIVITY_NEW_TASK一起使用
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            })
        }
    }
}