package com.example.androidsimple

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.bigview.LoadMediaActivity
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

    private lateinit var activityResultLaunch: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityResultLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        }

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
            activityResultLaunch.launch(Intent(this,MainFragmentActivity::class.java))

        }
        binding.btnMedia.setOnClickListener {
            startActivity(Intent(this,LoadMediaActivity::class.java))
        }
    }


}