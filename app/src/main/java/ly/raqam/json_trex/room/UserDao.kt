package ly.raqam.json_trex.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM usertb")
   suspend fun getAll(): List<UserDatabase>

    @Query("SELECT * FROM usertb WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<UserDatabase>

    @Query("DELETE FROM usertb WHERE uid = :userId")
    suspend fun deleteUser(userId: Int)

    @Query("SELECT * FROM usertb WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
   suspend fun findByName(first: String, last: String): List<UserDatabase>

    @Insert(onConflict = 1)
   suspend fun insertAll(vararg userDatabases: UserDatabase)

    @Delete
   suspend fun delete(userDatabase: UserDatabase)
}
