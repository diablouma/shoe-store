package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = listOf(
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
}