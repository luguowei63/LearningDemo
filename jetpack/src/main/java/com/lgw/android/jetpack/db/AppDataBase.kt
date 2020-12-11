package com.lgw.android.jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.lgw.android.jetpack.db.dao.FavouriteShoeDao
import com.lgw.android.jetpack.db.dao.ShoeDao
import com.lgw.android.jetpack.db.dao.UserDao
import com.lgw.android.jetpack.db.data.Shoe

/**
 *Created by lgw on 2020/12/10
 */

@Database(entities = [Shoe::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun shoeDao(): ShoeDao

    abstract fun userDao(): UserDao

    abstract fun favouriteShoeDao():FavouriteShoeDao


    companion object {
        @Volatile
        private var instance: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context)
                    .also {
                        instance = it
                    }
            }
        }


        private fun buildDataBase(context: Context): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, "jetPackDemo-database")
                //是否允许在祝线程进行查询
                .allowMainThreadQueries()
                //数据库创建和打开后的回掉
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                    }

                    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                        super.onDestructiveMigration(db)
                    }
                })
                //设置查询的线程池
                //.setQueryExecutor()
                //.openHelperFactory()
                //.fallbackToDestructiveMigration()

                .addMigrations(MIGRATION_2_3)
                .build()
        }

        //        class Migration(startVersion: Int, endVersion: Int) :
//            androidx.room.migration.Migration(startVersion, endVersion) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//            }
//
//        }
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE Book ADD COLUMN pub_year INTEGER")
            }
        }

    }

}