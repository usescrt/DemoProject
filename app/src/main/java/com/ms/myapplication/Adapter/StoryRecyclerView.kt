package com.ms.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.R
import com.ms.myapplication.models.Story

class StoryRecyclerView(private val storyList: ArrayList<Story>): RecyclerView.Adapter<StoryRecyclerView.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = storyList[position]
        holder.image.setImageResource(currentItem.image)
    }


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.storyImage)

    }
}