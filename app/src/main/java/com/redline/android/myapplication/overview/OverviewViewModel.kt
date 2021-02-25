

package com.redline.android.myapplication.overview

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

class OverviewViewModel : ViewModel() {

     var   subtype :String="bluetick"
    private val _status = MutableLiveData<ApiStatus>()


    val status: LiveData<ApiStatus>
        get() = _status


    private val _properties = MutableLiveData<JsonProperty>()


    val properties: LiveData<JsonProperty>
        get() = _properties


    private val _navigateToSelectedProperty = MutableLiveData<String>()


    val navigateToSelectedProperty: LiveData<String>
        get() = _navigateToSelectedProperty




    init {
        getJosonProperties(subtype)
    }


    private fun getJosonProperties(subtype:String) {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            Log.i("getJosonProperties = ",_status.value.toString())
            try {
                _properties.value = Api.retrofitService.getProperties(subtype)
                _status.value = ApiStatus.DONE
                Log.i("getJosonProperties = ", _properties.value!!.message.size.toString())
                Log.i("getJosonProperties = ", _properties.value!!.status.toString())
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
