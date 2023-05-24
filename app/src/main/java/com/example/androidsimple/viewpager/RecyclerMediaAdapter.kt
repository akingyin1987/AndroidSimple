package com.example.androidsimple.viewpager

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsimple.base.BaseViewHolder
import com.example.androidsimple.databinding.ItemImageBinding

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/19 12:59
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/19 12:59
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class RecyclerMediaAdapter : RecyclerView.Adapter<RecyclerMediaAdapter.MediaViewHolder>() {


    class MediaViewHolder(binding: ItemImageBinding) :BaseViewHolder<ItemImageBinding>(binding){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}