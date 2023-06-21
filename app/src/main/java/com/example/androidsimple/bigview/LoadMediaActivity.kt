package com.example.androidsimple.bigview

import android.content.Intent
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.ActivityMediaLoadBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/21 12:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/21 12:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class LoadMediaActivity:BaseActivity<ActivityMediaLoadBinding>() {

    override fun getViewBinding(): ActivityMediaLoadBinding {
       return ActivityMediaLoadBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
       binding.btnLongImage.setOnClickListener {
            startActivity(Intent(this,LongImageLoadActivity::class.java))
       }
       binding.btnNormalLongImage.setOnClickListener {
           startActivity(Intent(this,LongImageLoadActivity::class.java).apply {
               putExtra("normalLoad",true)
           })

       }
       binding.btnBigImage.setOnClickListener {
           startActivity(Intent(this,BigImageLoadActivity::class.java))
       }
    }
}