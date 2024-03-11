package com.example.kvadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (private val mList: List<view_model>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    private var selectedItemPosition: Int = RecyclerView.NO_POSITION
    private var itemClickListener: ((position: Int, item: view_model) -> Unit)? = null

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView =itemView.findViewById(R.id.chocolates)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
            val item = mList[position]
            holder.textView.text =item.text
        holder.itemView.setOnClickListener {
            val previousSelected = selectedItemPosition
            selectedItemPosition = position
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedItemPosition)
            itemClickListener?.invoke(position, item)
        }
        }

    override fun getItemCount(): Int {
        return mList.size
    }

}