package com.example.androidsimple.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidsimple.base.BaseFragment
import com.example.androidsimple.databinding.FragmentContentBinding
import java.util.UUID

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/16 8:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/16 8:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class FragmentContext : BaseFragment<FragmentContentBinding>() {

    override fun initBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentContentBinding {
       return  FragmentContentBinding.inflate(layoutInflater,null,false)
    }

    override fun initBindDataAndUid() {
       binding.tvMsg1.text ="第一个界面"
       binding.btn1.text="跳转到下一个"
        binding.btn2.visibility = View.GONE
        binding.btn1.setOnClickListener {

           findNavController().navigate(FragmentContextDirections.actionToContext2("参数:${UUID.randomUUID().toString().replace("-","")}"))
        }

    }
}