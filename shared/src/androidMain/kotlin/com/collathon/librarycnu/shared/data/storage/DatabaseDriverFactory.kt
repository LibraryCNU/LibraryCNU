package com.collathon.librarycnu.shared.data.storage

import android.content.Context
import com.collathon.librarycnu.sqldelight.AppDB
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(AppDB.Schema, context, "appdata.db")
    }
}
