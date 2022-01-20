package com.example.demoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.demoapp.databinding.ListDataItemBinding
import com.example.demoapp.network.Item

class ListDataAdapter(private val context: Context, val list: List<Item>) : RecyclerView.Adapter<ListDataAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListDataItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListDataItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.itemTitleTextView.text = list[position].StationName

        list[position].Logo?.let {
            Glide.with(context)
                .load(list[position].Logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.binding.thumbnailImage)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}