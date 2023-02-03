package com.ms.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.R
import com.ms.myapplication.models.Post

class PostRecyclerView(private val postList: ArrayList<Post>): RecyclerView.Adapter<PostRecyclerView.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = postList[position]
        holder.username.text = currentItem.username
        holder.postTime.text = currentItem.postTime
        holder.postBackground.setImageResource(currentItem.postBackground)
        holder.userImage.setImageResource(currentItem.userImage)

    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val username : TextView = itemView.findViewById(R.id.userName)
        val postTime: TextView = itemView.findViewById(R.id.postTime)
        val postBackground: ImageView = itemView.findViewById(R.id.postImageBackground)
        val userImage: ImageView = itemView.findViewById(R.id.userImage)

    }

}