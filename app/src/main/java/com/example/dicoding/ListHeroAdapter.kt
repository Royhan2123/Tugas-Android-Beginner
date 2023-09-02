package com.example.dicoding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding.databinding.ItemNovelBinding

class ListHeroAdapter(private val listHero: ArrayList<Novel>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: ItemNovelBinding) : RecyclerView.ViewHolder(binding.root)

    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(data: Novel)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemNovelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        val binding = holder.binding

        binding.imgPhoto.setImageResource(photo)
        binding.tvItemName.text = name
        binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listHero[position])
        }
    }
}
