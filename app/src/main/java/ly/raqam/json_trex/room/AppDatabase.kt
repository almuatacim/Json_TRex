package ly.raqam.json_trex.room

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(entities = [UserDatabase::class], version = 1,
//    autoMigrations = [
//    AutoMigration (
//        from = 3,
//        to = 5,
//    )
//]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        private var db:AppDatabase? = null
        fun initDb(context: Context?) :AppDatabase {
            if (db == null) {
                synchronized(this){
                    db = Room.databaseBuilder(
                        context!!,
                        AppDatabase::class.java, "database-name"
                    ).build()
                    return db!!
                }

            }
            return db!!
        }
    }


}
