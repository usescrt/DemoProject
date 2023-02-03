package com.ms.myapplication.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.MessagingActivity
import com.ms.myapplication.R
import com.ms.myapplication.models.Message

class MessageRecyclerView(private val messageList: ArrayList<Message>): RecyclerView.Adapter<MessageRecyclerView.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = messageList[position]
        holder.username.text = currentItem.username
        holder.subtitle.text = currentItem.subtitle
        holder.userImage.setImageResource(currentItem.userImage)
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.context, MessagingActivity::class.java)
            intent.putExtra("messageData", messageList[position])
            holder.context.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val context: Context = itemView.context
        val username: TextView = itemView.findViewById(R.id.messageUsername)
        val subtitle: TextView = itemView.findViewById(R.id.messageSubtitle)
        val userImage: ImageView = itemView.findViewById(R.id.messageUserImage)
    }
}