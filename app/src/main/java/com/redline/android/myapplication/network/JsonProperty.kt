
package com.redline.android.myapplication.network

import android.os.Parcelable
import androidx.lifecycle.LiveData
import com.redline.android.myapplication.overview.ApiStatus
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class JsonProperty(
        val message: List<String>,
        val status: String) : Parcelable
