package com.test.recipes.ui.main

import com.test.recipes.App

class MainPresenter(private var view: IMainView?) : IMainPresenter {

    override fun init() {
        fetchData()
    }

    private fun fetchData() {
        App.repository.fetchRecipeList(
            onError = { view?.showError(it) },
            onResult = {
                view?.showList(it)
                view?.showLoader(false)
            }
        )
    }

    override fun destroy() {
        view = null
    }

    override fun refresh() {
        view?.showLoader(true)
        fetchData()
    }

}
