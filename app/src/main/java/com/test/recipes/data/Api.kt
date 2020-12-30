package com.test.recipes.data

import com.test.recipes.data.objects.Recipe
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("recipes")
    fun fetchRecipes(): Call<List<Recipe>>

    @GET("recipes/{uuid}")
    fun fetchRecipe(@Path("uuid") id: String): Call<Recipe>

}
