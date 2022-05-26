package com.example.marvelapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.adapter.RecyclerViewAdapter
import com.example.marvelapp.databinding.ActivityCharacterListBinding
import com.example.marvelapp.mvvm.model.CharacterListModel
import com.example.marvelapp.mvvm.viewmodel.CharacterListViewModel
import com.example.marvelapp.mvvm.viewmodel.CharacterListViewModel.CharacterData
import com.example.marvelapp.mvvm.viewmodel.CharacterListViewModel.CheckState

class CharacterListActivity : AppCompatActivity() {
    private val model = CharacterListModel()
    private val viewModel = CharacterListViewModel(model)
    private lateinit var binding: ActivityCharacterListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getValue().observe({ lifecycle }, ::updateUI)

        viewModel.getCharacterList()
    }

    private fun updateUI(data: CharacterData) {
        when (data.state) {
            CheckState.GET_CHARACTER_LIST -> {
                val characterList = data.characterList
                val recyclerView: RecyclerView = binding.recyclerView
                recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                val recyclerViewAdapter = RecyclerViewAdapter(characterList)
                recyclerView.adapter = recyclerViewAdapter
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CharacterListActivity::class.java)
        }
    }
}
