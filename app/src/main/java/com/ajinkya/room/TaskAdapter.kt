package com.ajinkya.room

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            cb_task.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    tv_list_item.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                }else{
                    tv_list_item.paintFlags = Paint.LINEAR_TEXT_FLAG
                }
            }
        }
    }
}