package com.example.androidsimple.bigview

import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.databinding.FragmentBitImageBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/21 14:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/21 14:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class BigImageLoadActivity:BaseActivity<FragmentBitImageBinding>() {

    override fun getViewBinding(): FragmentBitImageBinding {
        return FragmentBitImageBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
        assets.open("2.jpg").use {
            binding.ivImage.setLongImage(it)
        }
    }
}