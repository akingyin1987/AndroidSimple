package com.example.androidsimple.fragment



import android.app.Activity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.NavHostFragment
import com.example.androidsimple.R
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.ActivityMainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/16 8:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/16 8:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

@AndroidEntryPoint
class MainFragmentActivity :BaseActivity<ActivityMainFragmentBinding>(){

    override fun getViewBinding(): ActivityMainFragmentBinding {
        return ActivityMainFragmentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this,object :OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
               setResult(Activity.RESULT_OK)
                finish()
            }

        })
    }
    override fun initBindDataAndUi() {
         binding.fragmentContainer.post {

             supportFragmentManager.findFragmentById(R.id.fragment_container)?.let {
                 val navHostFragment = it  as NavHostFragment
                 navHostFragment.navController.setGraph(R.navigation.nav_graph)
             }
         }
    }

}