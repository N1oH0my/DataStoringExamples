package com.example.data_storage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.data_storage.databinding.LayoutSpBinding

class SpFragment: Fragment(R.layout.layout_sp) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = LayoutSpBinding.bind(view)

        binding.saveBtn.setOnClickListener {
            save(name = binding.nameEt.text.toString())
        }
        binding.getBtn.setOnClickListener {
            Toast.makeText(
                requireContext(),
                getName(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun save(name: String){
        val prefs = getSP()
        prefs.edit {
            putString(NAME_KEY, name)
        }
    }

    fun getName() :String {
        return getSP().getString(NAME_KEY, "undefined").orEmpty()
    }

    private fun getSP(): SharedPreferences {
        return requireActivity().getSharedPreferences(
            SP_KEY,
            Context.MODE_PRIVATE
        )
    }
    private companion object{
        const val SP_KEY = "SP_KEY"
        const val NAME_KEY = "NAME_KEY"
    }
}