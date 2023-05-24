package com.example.androidsimple.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsimple.base.BaseActivity
import com.example.androidsimple.base.BaseViewHolder
import com.example.androidsimple.databinding.ActivityViewpagerRecyclerviewBinding
import com.example.androidsimple.databinding.ItemRecyclerViewBinding
import com.example.androidsimple.model.MediaItem
import com.example.androidsimple.model.MediaList
import com.example.androidsimple.utils.RandomUtil

/**
 *
 * @Description:
 * @author: aking
 * @CreateDate: 2023/4/19 10:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2023/4/19 10:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class ViewPager2Activity :BaseActivity<ActivityViewpagerRecyclerviewBinding>(){

    override fun getViewBinding(): ActivityViewpagerRecyclerviewBinding {
        return  ActivityViewpagerRecyclerviewBinding.inflate(layoutInflater)
    }

    override fun initBindDataAndUi() {
       binding.viewpager2.adapter = ViewPagerAdapter().apply {
           dataList = MutableList(10){
               MediaList().apply {
                   itemList = MutableList(8){
                       MediaItem(RandomUtil.randomSampleImageUrl(),"123")
                   }
               }
           }
       }

    }

    class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

        var  dataList = mutableListOf<MediaList>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
            return ViewPagerHolder(ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
             holder.bind(dataList[position])
        }

        override fun getItemCount(): Int {
            return  dataList.size
        }

        class ViewPagerHolder(binding: ItemRecyclerViewBinding) :BaseViewHolder<ItemRecyclerViewBinding>(binding){
            fun  bind(mediaItem: MediaList){
                if(null == binding.itemRecycler.adapter){

                }
                binding.itemRecycler.adapter
            }
        }
    }
}