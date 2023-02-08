package ly.raqam.json_trex.vmdata.core.baserepostry

import kotlinx.coroutines.flow.Flow
import ly.raqam.json_trex.vmdata.core.Resource
import ly.raqam.json_trex.vmdata.entity.UserEntity

interface LocalUserRepostry {
    suspend fun getallUser(): Flow<Resource<List<UserEntity>>>
    suspend fun insertUser(user : UserEntity)
    suspend fun delete(user : UserEntity)
    suspend fun deleteUser(uid : Int)
}