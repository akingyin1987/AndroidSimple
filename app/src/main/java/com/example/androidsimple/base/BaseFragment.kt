package com.example.androidsimple.base


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/3 14:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/3 14:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class BaseFragment<T:ViewBinding> : Fragment() {

    lateinit var    binding:T

    abstract fun initBindView( inflater: LayoutInflater,container: ViewGroup?):T


    abstract fun  initBindDataAndUid()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        println("onAttach：与上下文进行绑定")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate：创建fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ):View {
        println("onCreateView:创建fragment ui")
       return initBindView(inflater, container).also {
           binding = it
       }.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("onViewCreated 创建UI 后调用")
        super.onViewCreated(view, savedInstanceState)
        initBindDataAndUid()
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println("onDestroyView 销毁fragment UI")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        println("onDetach 解绑")
    }
}