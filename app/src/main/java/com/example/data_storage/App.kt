package com.example.data_storage

import android.app.Application
import androidx.room.Room


// new changes from merge branch
class App: Application() {


    lateinit var db: AppDB
    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            context = this,
            AppDB::class.java,
            "DB.db"
        )
        // some migrations
            .build()
    }

}