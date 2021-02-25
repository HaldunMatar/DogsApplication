package com.redline.android.myapplication.detail
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.redline.android.myapplication.network.JsonProperty


class DetailViewModelFactory(
    private val property: String,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(property, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
