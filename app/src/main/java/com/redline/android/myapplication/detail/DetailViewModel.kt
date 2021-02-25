package com.redline.android.myapplication.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.redline.android.myapplication.R
import com.redline.android.myapplication.network.JsonProperty



class DetailViewModel(jsonProperty: String, app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<String>()


    val selectedProperty: LiveData<String>
        get() = _selectedProperty


    init {
        _selectedProperty.value = jsonProperty
    }






}
