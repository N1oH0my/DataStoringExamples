package com.example.data_storage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.data_storage.databinding.LayoutRoomBinding
import com.example.data_storage.databinding.LayoutSpBinding

class RoomFragment: Fragment(R.layout.layout_room) {

    private lateinit var adapter: SimpleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = LayoutRoomBinding.bind(view)
        adapter = SimpleAdapter()

        binding.contentRv.adapter = adapter

        binding.saveBtn.setOnClickListener {
            // todo
        }
        binding.refreshBtn.setOnClickListener {
            // todo
        }
    }

    private fun renderItems(items: List<String>) {

    }
}
