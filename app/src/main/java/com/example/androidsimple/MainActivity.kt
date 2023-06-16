package com.example.androidsimple

import android.content.Intent
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.MainBinding
import com.example.androidsimple.fragment.MainFragmentActivity
import com.example.androidsimple.lock.LockMainActivity

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
class MainActivity : BaseActivity<MainBinding>() {

    override fun getViewBinding(): MainBinding {
       return MainBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
        binding.btnAndroidAnimation.setOnClickListener {
            startActivity(Intent(this,AnimationActivity::class.java))
        }
        binding.btnAndroidLock.setOnClickListener {
            startActivity(Intent(this,LockMainActivity::class.java))
        }
        binding.btnIntentFlag.setOnClickListener {
            startActivity(Intent(this,LaunchModeActivity::class.java))
        }
        binding.btnCoroutine.setOnClickListener {
            startActivity(Intent(this,CoroutineActivity::class.java))
        }
        binding.btnFragment.setOnClickListener {
            startActivity(Intent(this,MainFragmentActivity::class.java))
        }
    }


}