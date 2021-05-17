package com.udacity.shoestore.screens.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {
    private var _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe>
        get() = _newShoe

    init {
        _newShoe.value = Shoe("", 0.0, "", "", mutableListOf())
    }
}
