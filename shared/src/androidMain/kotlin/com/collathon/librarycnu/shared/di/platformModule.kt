package com.collathon.librarycnu.shared.di

import com.collathon.librarycnu.shared.data.storage.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        factory<DatabaseDriverFactory> { DatabaseDriverFactory(get()) }
    }
