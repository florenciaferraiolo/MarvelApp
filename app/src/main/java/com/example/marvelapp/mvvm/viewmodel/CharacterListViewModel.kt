package com.example.marvelapp.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.mvvm.model.CharacterListModel

class CharacterListViewModel(model: CharacterListModel) : ViewModel() {
    private val model = model
    private val mutableListData: MutableLiveData<CharacterData> = MutableLiveData()

    fun getValue(): LiveData<CharacterData> {
        return mutableListData
    }

    fun getCharacterList() {
        mutableListData.value = CharacterData(CheckState.GET_CHARACTER_LIST, model.sendCharacterList())
    }

    data class CharacterData(
        val state: CheckState,
        val characterList: MutableList<CharacterListModel.Character>
    )

    enum class CheckState {
        GET_CHARACTER_LIST
    }
}
