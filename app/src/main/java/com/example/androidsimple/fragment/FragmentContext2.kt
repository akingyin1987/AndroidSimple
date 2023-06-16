package com.example.androidsimple.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidsimple.base.BaseFragment
import com.example.androidsimple.databinding.FragmentContentBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/6/16 8:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/6/16 8:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class FragmentContext2:BaseFragment<FragmentContentBinding>() {
    private val args: FragmentContext2Args by navArgs()
    override fun initBindView(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentContentBinding {
        return FragmentContentBinding.inflate(layoutInflater,null,false)
    }

    override fun initBindDataAndUid() {
        binding.tvMsg1.text ="第二个界面"
        binding.btn1.text="返回"
        binding.btn1.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btn2.text =args.key
        binding.btn2.setOnClickListener {

            requireActivity().finish()
        }
    }
}