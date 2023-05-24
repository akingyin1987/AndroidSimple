package com.example.androidsimple.base


import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/19 12:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/19 12:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
open class BaseViewHolder<T : ViewBinding>(var binding: T) : RecyclerView.ViewHolder(binding.root) {

}