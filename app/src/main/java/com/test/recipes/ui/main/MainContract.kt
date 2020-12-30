package com.test.recipes.ui.main

import com.test.recipes.data.objects.Recipe

interface IMainView {
    abstract val it: String?

    fun showList(list: List<Recipe>)
    fun showLoader(flag: Boolean)
    fun showError(message: String)
}

interface IMainPresenter {
    fun init()
    fun destroy()
    fun refresh()
}
