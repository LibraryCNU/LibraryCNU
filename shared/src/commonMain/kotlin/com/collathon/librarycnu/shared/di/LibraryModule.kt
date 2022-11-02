package com.collathon.librarycnu.shared.di

import com.collathon.librarycnu.shared.data.*
import com.collathon.librarycnu.shared.data.network.*
import com.collathon.librarycnu.shared.data.storage.BookLocalDataSource
import com.collathon.librarycnu.shared.data.storage.Database
import com.collathon.librarycnu.shared.data.storage.SeatLocalDataSource
import com.collathon.librarycnu.shared.data.storage.StudentLocalDataSource
import com.collathon.librarycnu.shared.domain.repository.BookRepository
import com.collathon.librarycnu.shared.domain.repository.SeatRepository
import com.collathon.librarycnu.shared.domain.repository.StudentRepository
import com.collathon.librarycnu.shared.domain.usecase.seat.*
import com.collathon.librarycnu.shared.domain.usecase.student.GetStudentInfoUseCase
import com.collathon.librarycnu.shared.domain.usecase.student.LoginUseCase
import com.collathon.librarycnu.shared.domain.usecase.student.LogoutUseCase
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.koinApplication
import org.koin.dsl.module

val libraryModule = module {
    single<StudentRepository> {
        StudentRepositoryImpl(
            get(qualifier = named("StudentLocal")),
            get(qualifier = named("StudentRemote"))
        )
    }
    single<SeatRepository> {
        SeatRepositoryImpl(
            get(qualifier = named("SeatLocal")),
            get(qualifier = named("SeatRemote"))
        )
    }
    single<BookRepository> {
        BookRepositoryImpl(
            get(qualifier = named("BookLocal")),
            get(qualifier = named("BookRemote"))
        )
    }
    factory<StudentDataSource>(named("StudentLocal")) { StudentLocalDataSource(get()) }
    factory<StudentDataSource>(named("StudentRemote")) { StudentRemoteDataSource(get()) }
    factory<SeatDataSource>(named("SeatLocal")) { SeatLocalDataSource(get()) }
    factory<SeatDataSource>(named("SeatRemote")) { SeatRemoteDataSource(get()) }
    factory<BookDataSource>(named("BookLocal")) { BookLocalDataSource(get()) }
    factory<BookDataSource>(named("BookRemote")) { BookRemoteDataSource(get()) }

    single<Database> { Database(get()) }
    factory<StudentApi> { StudentApi() }
    factory<SeatApi> { SeatApi() }
    factory<BookApi> { BookApi() }

    // Student UseCase
    factory<GetStudentInfoUseCase> { GetStudentInfoUseCase(get()) }
    factory<LoginUseCase> { LoginUseCase(get()) }
    factory<LogoutUseCase> { LogoutUseCase(get()) }

    // Seat UseCase
    factory<GetAllSeatInfoUseCase> { GetAllSeatInfoUseCase(get()) }
    factory<GetSeatInfoUseCase> { GetSeatInfoUseCase(get()) }
    factory<ReservationInfoUseCase> { ReservationInfoUseCase(get()) }
    factory<ReserveSeatUseCase> { ReserveSeatUseCase(get()) }
    factory<CancelSeatUseCase> { CancelSeatUseCase(get()) }
    factory<ExtendSeatUseCase> { ExtendSeatUseCase(get()) }



}

expect val platformModule: Module

fun createKoinApp() = koinApplication {
    modules(libraryModule, platformModule)
}
