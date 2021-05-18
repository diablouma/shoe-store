package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _newShoe = MutableLiveData<Shoe>()
    val newShoe: LiveData<Shoe>
        get() = _newShoe

    private var _shoeSaved = MutableLiveData<Boolean>()
    val shoeSaved: LiveData<Boolean>
        get() = _shoeSaved

    init {
        _shoeSaved.value = false
        _newShoe.value = Shoe("", 0.0, "", "", mutableListOf())

        _shoeList.value = mutableListOf(
            Shoe(
                name = "Red high heels",
                size = 32.0,
                company = "red heels",
                description = "Red high heels",
                images = listOf("image1.png")
            ),
            Shoe(
                name = "Vans Artisan",
                size = 35.0,
                company = "Vans",
                description = "Nice Vans shoes for sports",
                images = listOf("image1.png")
            ),
            Shoe(
                name = "Golf shoes",
                size = 42.0,
                company = "Golf Champion",
                description = "The best shoes for golf matches",
                images = listOf("image1.png")
            ),
            Shoe(
                name = "Hiking Vans",
                size = 30.0,
                company = "Vans",
                description = "The most comfortable shoes for hiking",
                images = listOf("image1.png")
            ),
            Shoe(
                name = "Soccer 100",
                size = 44.0,
                company = "TheSoccer",
                description = "Nice soccer shoes that perfectly feet your feet",
                images = listOf("image1.png")
            ),
            Shoe(
                name = "Raining boots",
                size = 39.5,
                company = "TheRain",
                description = "For the winter, these are the best boots ever",
                images = listOf("image1.png")
            )
        )
    }

    fun onSaveShoeEvent() {
        _shoeSaved.value = true
    }

    fun addShoe(newShoe: Shoe) {
        _shoeList.value!!.add(newShoe)
    }

    fun onSaveShoeEventComplete() {
        _newShoe.value = Shoe("", 0.0, "", "", mutableListOf())
        _shoeSaved.value = false
    }
}