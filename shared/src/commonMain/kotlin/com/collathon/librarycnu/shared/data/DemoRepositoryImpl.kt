package com.collathon.librarycnu.shared.data

import com.collathon.librarycnu.shared.data.network.DemoRemoteDataSource
import com.collathon.librarycnu.shared.domain.repository.DemoRepository

class DemoRepositoryImpl(
    private val remoteDemoDataSource: DemoDataSource
) : DemoRepository {
    override suspend fun setReserveSeatLED() : Unit {
        remoteDemoDataSource.setReserveSeatLED()
    }

    override suspend fun setSearchBookLED() : Unit {
        remoteDemoDataSource.setSearchBookLED()
    }

}
