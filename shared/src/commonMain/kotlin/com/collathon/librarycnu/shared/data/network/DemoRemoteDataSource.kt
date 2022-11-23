package com.collathon.librarycnu.shared.data.network

import com.collathon.librarycnu.shared.data.DemoDataSource

class DemoRemoteDataSource(private val demoApi: DemoApi) : DemoDataSource {
    override suspend fun setReserveSeatLED() {
        demoApi.setReserveSeatLED()
    }

    override suspend fun setSearchBookLED() {
        demoApi.setSearchBookLED()
    }

}