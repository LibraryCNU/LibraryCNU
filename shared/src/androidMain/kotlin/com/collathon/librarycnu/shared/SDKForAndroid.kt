package com.collathon.librarycnu.shared

import android.content.Context
import com.collathon.librarycnu.shared.di.createKoinApp
import com.collathon.librarycnu.shared.domain.usecase.seat.*
import com.collathon.librarycnu.shared.domain.usecase.student.GetStudentInfoUseCase
import com.collathon.librarycnu.shared.domain.usecase.student.LoginUseCase
import com.collathon.librarycnu.shared.domain.usecase.student.LogoutUseCase
import org.koin.dsl.module

class SDKForAndroid(context: Context) {
    private val koinApp = createKoinApp().modules(module { single<Context> { context } })

    // Student UseCase
    private val getStudentInfoUseCase: GetStudentInfoUseCase = koinApp.koin.get()
    private val loginUseCase: LoginUseCase = koinApp.koin.get()
    private val logoutUseCase: LogoutUseCase = koinApp.koin.get()

    // Seat UseCase
    private val getAllSeatInfoUseCase: GetAllSeatInfoUseCase = koinApp.koin.get()
    private val getSeatInfoUseCase: GetSeatInfoUseCase = koinApp.koin.get()
    private val reservationInfoUseCase: ReservationInfoUseCase = koinApp.koin.get()
    private val reserveSeatUseCase: ReserveSeatUseCase = koinApp.koin.get()
    private val cancelSeatUseCase: CancelSeatUseCase = koinApp.koin.get()
    private val extendSeatUseCase: ExtendSeatUseCase = koinApp.koin.get()

    fun getStudentInfoUseCase(): GetStudentInfoUseCase = getStudentInfoUseCase
    fun loginUseCase(): LoginUseCase = loginUseCase
    fun logoutUseCase(): LogoutUseCase = logoutUseCase

    fun getAllSeatInfoUseCase(): GetAllSeatInfoUseCase = getAllSeatInfoUseCase
    fun getSeatInfoUseCase(): GetSeatInfoUseCase = getSeatInfoUseCase
    fun reservationInfoUseCase(): ReservationInfoUseCase = reservationInfoUseCase
    fun reserveSeatUseCase(): ReserveSeatUseCase = reserveSeatUseCase
    fun cancelSeatUseCase(): CancelSeatUseCase = cancelSeatUseCase
    fun extendSeatUseCase(): ExtendSeatUseCase = extendSeatUseCase
}
