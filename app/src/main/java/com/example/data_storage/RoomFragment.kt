package com.example.data_storage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.data_storage.databinding.LayoutRoomBinding
import com.example.data_storage.databinding.LayoutSpBinding
import kotlinx.coroutines.launch

class RoomFragment: Fragment(R.layout.layout_room) {

    private lateinit var adapter: SimpleAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = LayoutRoomBinding.bind(view)
        adapter = SimpleAdapter()

        binding.contentRv.adapter = adapter

        binding.saveBtn.setOnClickListener {
            saveQuery(binding.nameEt.text.toString())
        }
        binding.refreshBtn.setOnClickListener {
            refresh()
        }
    }

    private fun renderItems(items: List<String>) {
        adapter.render(items)
    }

    private fun saveQuery(query: String){
        lifecycleScope.launch{
            getDB().quertDAO().insert(
                QueryItemEntity(query = query)
            )
        }
    }

    private fun refresh(){
        lifecycleScope.launch {
            val queries = getDB().quertDAO().getAll()
                .map { it.query }

            renderItems(queries)
        }
    }
    private fun getDB() = (requireActivity().application as App).db
}
