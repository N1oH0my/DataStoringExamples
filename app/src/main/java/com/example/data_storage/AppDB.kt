package com.example.data_storage

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "Query")
data class QueryItemEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,
    @ColumnInfo("query")
    val query: String,
)

@Dao
interface QueryDAO{
    @Query("SELECT * FROM 'Query'")
    suspend fun getAll(): List<QueryItemEntity>

    @Insert
    suspend fun insert(item: QueryItemEntity)
}

@Database(
    version = 1,
    entities = [QueryItemEntity::class]
)
abstract class AppDB: RoomDatabase(){
    abstract fun quertDAO(): QueryDAO
}