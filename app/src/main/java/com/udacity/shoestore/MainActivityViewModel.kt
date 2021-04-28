package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {
    private var _listOfShoes = MutableLiveData<MutableList<Shoe>>()
    val listOfShoes:LiveData<MutableList<Shoe>> get() = _listOfShoes

    init {
        _listOfShoes.value=Constants.shoeList
    }


    public fun addShoeToList(shoe: Shoe){
        _listOfShoes.value?.add(shoe)
    }


}