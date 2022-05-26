package com.example.marvelapp.mvvm.model

import com.example.marvelapp.R

class CharacterListModel {
    private var characterList = mutableListOf<Character>()

    fun sendCharacterList(): MutableList<Character> {
        var character = Character("American Captain", R.drawable.american_captain)
        characterList.add(character)
        character = Character("Ant Man", R.drawable.ant_man)
        characterList.add(character)
        character = Character("Black Panther", R.drawable.black_panther)
        characterList.add(character)
        character = Character("Dr. Strange", R.drawable.dr_strange)
        characterList.add(character)
        character = Character("Hawkeye", R.drawable.hawkeye)
        characterList.add(character)
        character = Character("Hulk", R.drawable.hulk)
        characterList.add(character)
        character = Character("Iron Man", R.drawable.iron_man)
        characterList.add(character)
        character = Character("Scarlet Witch", R.drawable.scarlet_witch)
        characterList.add(character)
        character = Character("Spider Man", R.drawable.spider_man)
        characterList.add(character)
        character = Character("Thor", R.drawable.thor)
        characterList.add(character)
        return characterList
    }

    data class Character(var name: String, var image: Int)
}
