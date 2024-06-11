package com.example.data_storage

import android.app.Application
import androidx.room.Room

class App: Application() {
    // new comment
    lateinit var db: AppDB
    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            context = this,
            AppDB::class.java,
            "DB.db"
        )

            .build()
    }

}