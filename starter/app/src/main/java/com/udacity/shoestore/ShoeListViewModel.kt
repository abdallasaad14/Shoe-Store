package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel:ViewModel() {

    var shoesList=MutableLiveData<MutableList<Shoe>>()

    val name=MutableLiveData<String>()
    val size=MutableLiveData<String>()
    val company=MutableLiveData<String>()
    val description=MutableLiveData<String>()
    init {
        shoesList.value=ArrayList()
    }

    //method to save data
fun savedetailes(name:String,size:String,company:String,description:String){

    val newOne=Shoe(name,size, company, description)
    shoesList.value?.add(newOne)
    shoesList.value=shoesList.value
}

}