package com.jinxtris.ram.headapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.jinxtris.ram.headapp.BuildConfig
import com.jinxtris.ram.headapp.database.daos.CategoryDao
import com.jinxtris.ram.headapp.database.daos.ProductDao
import com.jinxtris.ram.headapp.database.daos.RankingDao
import com.jinxtris.ram.headapp.database.daos.VariantDao
import com.jinxtris.ram.headapp.database.entities.CategoryList
import com.jinxtris.ram.headapp.database.entities.ProductList
import com.jinxtris.ram.headapp.database.entities.RankingList
import com.jinxtris.ram.headapp.database.entities.Variants

@Database(
    entities = [CategoryList::class, ProductList::class, RankingList::class, Variants::class],
    version = BuildConfig.DATABASE_VERSION_USER
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun rankingDao(): RankingDao
    abstract fun productDao(): ProductDao
    abstract fun variantDao(): VariantDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {

                synchronized(AppDatabase::class) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "heady.db"
                    )
//                        .addMigrations(MIGRATION_1_2)
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {

                            }
                        })
                        .build()
                }
            }
            return instance
        }

        fun destroyInstance() {
            instance = null
        }
    }
}

var MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        //database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, " + "`name` TEXT, PRIMARY KEY(`id`))")
    }
}