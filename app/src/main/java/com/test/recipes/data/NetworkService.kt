package com.test.recipes.data

import android.provider.SyncStateContract
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.recipes.Constants
import com.test.recipes.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.SECONDS


object NetworkService {
    private val myClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(20, SECONDS)
        .build()

    private fun retrofit(): Retrofit = Retrofit.Builder()
        .client(myClient)
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(provideGson()))
        .build()

    fun networkService(): Api = retrofit().create(Api::class.java)
}

private fun provideGson(): Gson = GsonBuilder()
    .setLenient()
    .create()