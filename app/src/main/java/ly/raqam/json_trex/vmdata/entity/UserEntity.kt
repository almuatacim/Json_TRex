package ly.raqam.json_trex.vmdata.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import ly.raqam.json_trex.room.UserDatabase

data class UserEntity(val uid: Int,
                       val firstName: String?,
                       val lastName: String?,
                       val city : String?,
                       val country : String?){
    fun converttoModeldb() : UserDatabase{
        return UserDatabase(uid = this.uid,firstName = this.firstName, lastName = this.lastName, city = this.city,country = this.country)
    }
}