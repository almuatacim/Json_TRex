package ly.raqam.json_trex.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ly.raqam.json_trex.vmdata.core.basemodel.BaseModel
import ly.raqam.json_trex.vmdata.entity.UserEntity

@Entity(tableName = "usertb")
data class UserDatabase(
    @PrimaryKey(autoGenerate = true)  @ColumnInfo(name = "uid") val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    val city: String?="",
    val country: String?=""
):BaseModel<UserDatabase,UserEntity>(){
    override fun convertoEntity(): UserEntity {
        return UserEntity(uid= this.uid,firstName= this.firstName,lastName= this.lastName,city = this.city,country = this.country)
    }

}
