package com.project.recyclerviewexamplewithviewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.myapplication.clear
import com.project.myapplication.load
import com.project.recyclerviewexamplewithviewbinding.databinding.BoardListBinding

class RecyclerAdapter(private val items: ArrayList<Model>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: BoardListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Model) {
            binding.thumbnail.clear()
            binding.titleText.text = item.title
            binding.contentText.text = item.content
            binding.thumbnail.load(item.imageurl, 16f)
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
       val binding = BoardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}