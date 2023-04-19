package com.example.androidsimple.lock


import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.androidsimple.TransparentActivity
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.ActivityLockMainBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/12 12:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/12 12:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class LockMainActivity:BaseActivity<ActivityLockMainBinding>(){


    override fun getViewBinding(): ActivityLockMainBinding {
       return ActivityLockMainBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
        binding.btnSynchroizedFun.setOnClickListener {
               Thread{
                   testSynchroized("线程1")
               }.start()

               Thread{
                   testSynchroized("线程2")
               }.start()
        }
        binding.btnNoSynchroizedFun.setOnClickListener {
            Thread{
                showDo("线程1")
            }.start()

            Thread{
                showDo("线程2")
            }.start()
        }

        binding.btnSynchroizedCode.setOnClickListener {
            Thread{
                showDo2("线程1")
                showDo3("线程2")
            }.start()
            Thread{
                showDo2("线程3")

            }.start()

        }
        binding.btnDialog.setOnClickListener {
           AlertDialog.Builder(this)
               .setCancelable(false)
               .setTitle("Dialog")
               .setMessage("测试Activity 状态")
               .setPositiveButton("关闭"
               ) { dialog, _ ->
                   dialog.dismiss()
               }.show()
        }

        binding.btnTranslucentActivity.setOnClickListener {
            startActivity(Intent(this,TransparentActivity::class.java))
        }

        binding.btnMyActivity.setOnClickListener {
            startActivity(Intent(this,LockMainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            })
        }
    }

    @Synchronized
    fun  testSynchroized(msg:String){
       showDo(msg)
    }

    private fun showDo(msg: String){
        for (i in 0..100000){
            if(i % 1000 == 0){
                println("$msg,${i/1000}")
            }
        }
    }

    val  obj1:Any = Any()
    val  obj2:Any = Any()

     fun showDo2(msg: String){
        synchronized(obj1){
            for (i in 0..100000){
                if(i % 1000 == 0){
                    println("$msg,${i/1000}")
                }
            }
        }

    }

    /**
     * 多个同步锁，只有竞争同一个同步锁地会需要等待
     * @param msg String
     */
    private fun showDo3(msg: String){
        synchronized(obj2){
            for (i in 0..100000){
                if(i % 1000 == 0){
                    println("$msg,${i/1000}")
                }
            }
        }

    }
}