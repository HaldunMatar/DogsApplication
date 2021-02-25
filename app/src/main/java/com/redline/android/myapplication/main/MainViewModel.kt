

package com.redline.android.myapplication.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.redline.android.myapplication.network.JsonProperty
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.redline.android.myapplication.network.Api
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class MainViewModel : ViewModel() {


    private val _status = MutableLiveData<ApiStatus>()


    val status: LiveData<ApiStatus>
        get() = _status


    private val _properties = MutableLiveData<List<String>>()


    val properties: LiveData<List<String>>
        get() = _properties


    private val _navigateToSelectedProperty = MutableLiveData<String>()


    val navigateToSelectedProperty: LiveData<String>
        get() = _navigateToSelectedProperty




    init {
        getJosonProperties()
    }


    private fun getJosonProperties() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            Log.i("getJosonProperties = ",_status.value.toString())
            try {


                val words = listOf("doberman", "dingo", "deerhound", "dachshund","havanese", "groenendael", "germanshepherd", "bulldog","elkhound", "cairn", "african", "bulldog")
                _properties.value = words
                _status.value = ApiStatus.DONE
                //Log.i("getJosonProperties = ", _properties.value!!.message.size.toString())
            //    Log.i("getJosonProperties = ", _properties.value!!.status.toString())
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                Log.i("getJosonProperties = ",_status.value.toString())
              //  _properties.value = ArrayList()
            }
        }
    }


    fun displayPropertyDetails(jsonProperty: String) {
        _navigateToSelectedProperty.value = jsonProperty
    }


    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
