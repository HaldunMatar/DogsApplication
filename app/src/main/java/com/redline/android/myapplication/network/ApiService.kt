
package com.redline.android.myapplication.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


//private const val BASE_URL = "https://mars.udacity.com/"
private const val BASE_URL = "https://dog.ceo/api/breed/"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()


interface ApiService {


/*    https://dog.ceo/api/breed/hound/images
    @GET("/api/users/{id}")
    public Call<UserApiResponse> getUser(@Path("id") Long id);

    Calling above API with service.getUser(1) yields ‘/api/users/1’.*/

    //@GET("images")
    @GET("{subtype}/images")
    suspend fun getProperties(@Path("subtype")subtype: String ): JsonProperty
}

object Api {
           val retrofitService : ApiService by lazy { retrofit.create(ApiService::class.java)

        }
}
