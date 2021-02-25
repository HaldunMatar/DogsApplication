

package com.redline.android.myapplication.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.redline.android.myapplication.databinding.ListViewItemBinding

import com.redline.android.myapplication.network.JsonProperty

class obString(val sss : String )

class MainAdapter ( val onClickListener: OnClickListener ) :
        ListAdapter<String, MainAdapter.StringViewHolder>(DiffCallback) {


    class StringViewHolder(private var binding: ListViewItemBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(jsonProperty: String) {
            binding.property = jsonProperty

            binding.executePendingBindings()
        }
    }


    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): StringViewHolder {
        return StringViewHolder(ListViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val jsonProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(jsonProperty)
        }
        holder.bind(jsonProperty)
    }


    class OnClickListener(val clickListener: (jsonProperty: String) -> Unit) {
        fun onClick(jsonProperty: String) = clickListener(jsonProperty)
    }
}
