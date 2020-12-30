package com.test.recipes

import android.app.Application
import com.test.recipes.data.Api
import com.test.recipes.data.NetworkService
import com.test.recipes.data.Repository

class App : Application() {

    companion object {
        lateinit var networkService: Api
        lateinit var repository: Repository


        fun initNetworkService(network:Api) {
            networkService = network
        }

        fun initRepository(rep: Repository) {
            var repository = rep
        }
    }





    override fun onCreate() {
        super.onCreate()
        initNetworkService(NetworkService.networkService())
        initRepository(Repository())
    }

}

