package ly.raqam.json_trex.vmdata.core.baserepostry

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ly.raqam.json_trex.room.AppDatabase
import ly.raqam.json_trex.vmdata.core.Resource
import ly.raqam.json_trex.vmdata.entity.UserEntity

class localUserRepostryImp : LocalUserRepostry {
    val db = AppDatabase.initDb(null)
    override suspend fun getallUser(): Flow<Resource<List<UserEntity>>> = flow {
        emit(Resource.loading())


        var userdao = db.userDao()
        var users = userdao.getAll()
        emit(Resource.Success(data = users.map { it.convertoEntity() }))
    }


    override suspend fun insertUser(user: UserEntity) {
        if (db is AppDatabase) {
            db.userDao().insertAll(user.converttoModeldb())
        }
    }

    override suspend fun delete(user: UserEntity) {
        if (db is AppDatabase) {
            db.userDao().delete(user.converttoModeldb())
        }
    }

    override suspend fun deleteUser(uid: Int) {
        db.userDao().deleteUser(uid)
    }


}