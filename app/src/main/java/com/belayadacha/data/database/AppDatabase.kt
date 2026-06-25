package com.belayadacha.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.belayadacha.data.dao.DrawHistoryDao
import com.belayadacha.data.dao.ParticipantDao
import com.belayadacha.data.local.DrawResultEntity
import com.belayadacha.data.local.ParticipantEntity

@Database(
    entities = [ParticipantEntity::class, DrawResultEntity::class],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun participantDao(): ParticipantDao
    abstract fun drawHistoryDao(): DrawHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE participants ADD COLUMN schemaVersion INTEGER NOT NULL DEFAULT 1")
                database.execSQL("ALTER TABLE draw_history ADD COLUMN schemaVersion INTEGER NOT NULL DEFAULT 1")
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "belaya_dacha.db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
