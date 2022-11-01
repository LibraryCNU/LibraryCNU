package com.collathon.librarycnu.sqldelight.shared

import com.collathon.librarycnu.sqldelight.AppDB
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.db.SqlDriver
import comcollathonlibrarycnu.sqldelight.DatabaseQueries
import kotlin.Int
import kotlin.Unit
import kotlin.reflect.KClass

internal val KClass<AppDB>.schema: SqlDriver.Schema
  get() = AppDBImpl.Schema

internal fun KClass<AppDB>.newInstance(driver: SqlDriver): AppDB = AppDBImpl(driver)

private class AppDBImpl(
  driver: SqlDriver
) : TransacterImpl(driver), AppDB {
  public override val databaseQueries: DatabaseQueriesImpl = DatabaseQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE StudentTable (
          |    id TEXT NOT NULL,
          |    password TEXT NOT NULL,
          |    studentId TEXT NOT NULL,
          |    department TEXT NOT NULL,
          |    name TEXT NOT NULL,
          |    isAttending TEXT NOT NULL,
          |    session TEXT,
          |    qrInfo TEXT
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE SeatTable (
          |    id TEXT NOT NULL,
          |    place TEXT NOT NULL,
          |    canReserve INTEGER DEFAULT 0 NOT NULL,
          |    isFavorite INTEGER DEFAULT 0 NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE BookTable (
          |    author TEXT NOT NULL,
          |    name TEXT NOT NULL,
          |    publish TEXT NOT NULL,
          |    isbn TEXT NOT NULL,
          |    language TEXT,
          |    picture TEXT,
          |    isFavorite INTEGER DEFAULT 0 NOT NULL
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class DatabaseQueriesImpl(
  private val database: AppDBImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), DatabaseQueries
