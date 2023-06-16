package com.example.androidsimple.base


import android.content.Context
import android.os.Bundle
import android.util.Log
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
    val TAG: String = this.javaClass.simpleName+this.hashCode()
    lateinit var    binding:T



    abstract fun initBindView( inflater: LayoutInflater,container: ViewGroup?):T


    abstract fun  initBindDataAndUid()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"onAttach：与上下文进行绑定")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate：创建fragment")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ):View {
        Log.d(TAG,"onCreateView:创建fragment ui")

       return initBindView(inflater, container).also {
           binding = it
       }.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d(TAG,"onViewCreated 创建UI 后调用")

        super.onViewCreated(view, savedInstanceState)
        initBindDataAndUid()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView 销毁fragment UI")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach 解绑")

    }
}