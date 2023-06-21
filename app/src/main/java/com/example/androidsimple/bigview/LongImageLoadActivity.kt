package com.example.androidsimple.bigview

import android.graphics.drawable.Drawable
import android.view.View
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.FragmentLongImageBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/21 12:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/21 12:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class LongImageLoadActivity:BaseActivity<FragmentLongImageBinding>() {
    override fun getViewBinding(): FragmentLongImageBinding {
      return FragmentLongImageBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
        val isNormalLoad = intent.getBooleanExtra("normalLoad",false)
        if(isNormalLoad){
            binding.ivImage.visibility = View.GONE
            assets.open("big.png").use {
                binding.ivNormalImage.setImageDrawable(Drawable.createFromStream(it,null))
            }
        }else{
            assets.open("big.png").use {
                binding.ivImage.setLongImage(it)
            }
            binding.ivNormalImage.visibility = View.GONE
        }

    }
}