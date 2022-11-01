package com.collathon.librarycnu.sqldelight

import com.collathon.librarycnu.sqldelight.shared.newInstance
import com.collathon.librarycnu.sqldelight.shared.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import comcollathonlibrarycnu.sqldelight.DatabaseQueries

public interface AppDB : Transacter {
  public val databaseQueries: DatabaseQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = AppDB::class.schema

    public operator fun invoke(driver: SqlDriver): AppDB = AppDB::class.newInstance(driver)
  }
}
