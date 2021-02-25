

package com.redline.android.myapplication.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.redline.android.myapplication.databinding.GridViewItemBinding

import com.redline.android.myapplication.network.JsonProperty

class obString(val sss : String )

class DataAdapter( val onClickListener: OnClickListener ) :
        ListAdapter<String, DataAdapter.StringViewHolder>(DiffCallback) {


    class StringViewHolder(private var binding: GridViewItemBinding):
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
        return StringViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
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
