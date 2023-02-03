package com.ms.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ms.myapplication.R

class ChatRecyclerView(var listMessage: ArrayList<String>): RecyclerView.Adapter<ChatRecyclerView.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.send_message_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMessage.size
    }

    override fun onBindViewHolder(holder: ChatRecyclerView.MyViewHolder, position: Int) {
        holder.sendMessage.text = listMessage[position]
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val sendMessage: TextView = itemView.findViewById(R.id.sendMessage)
    }
}