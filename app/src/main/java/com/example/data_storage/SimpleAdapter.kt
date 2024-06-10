package com.example.data_storage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data_storage.databinding.ItemQueryBinding

class SimpleAdapter :
    RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    private val dataSet: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_query, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun render(items: List<String>) {
        dataSet.clear()
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemQueryBinding.bind(view)

        fun bind(item: String) {
            binding.contentTv.text = item
        }
    }

}
