package com.example.marvelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvelapp.R
import com.example.marvelapp.adapter.RecyclerViewAdapter.CharacterViewHolder
import com.example.marvelapp.mvvm.model.CharacterListModel

class RecyclerViewAdapter(private val characterList: List<CharacterListModel.Character>) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.characterTextView.text = character.name
        holder.characterImageView.setBackgroundResource(character.image)
    }

    inner class CharacterViewHolder(itemView: View) : ViewHolder(itemView) {
        val characterTextView: TextView = itemView.findViewById(R.id.name)
        val characterImageView: ImageView = itemView.findViewById(R.id.image)
    }
}
