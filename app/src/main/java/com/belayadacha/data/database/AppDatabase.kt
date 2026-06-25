package com.belayadacha.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.belayadacha.data.dao.DrawHistoryDao
import com.belayadacha.data.dao.ParticipantDao
import com.belayadacha.data.local.DrawResultEntity
import com.belayadacha.data.local.ParticipantEntity

@Database(
    entities = [ParticipantEntity::class, DrawResultEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun participantDao(): ParticipantDao
    abstract fun drawHistoryDao(): DrawHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "belaya_dacha.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
