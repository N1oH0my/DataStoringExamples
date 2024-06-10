package com.example.data_storage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.data_storage.databinding.LayoutSpBinding

class SpFragment: Fragment(R.layout.layout_sp) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = LayoutSpBinding.bind(view)

        binding.saveBtn.setOnClickListener {
            // todo
        }
        binding.getBtn.setOnClickListener {
            // todo
        }
    }
}