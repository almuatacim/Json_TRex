package ly.raqam.json_trex.vmdata

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.raqam.json_trex.vmdata.core.Resource
import ly.raqam.json_trex.vmdata.core.baserepostry.localUserRepostryImp
import ly.raqam.json_trex.vmdata.entity.UserEntity

class UserViewModel : ViewModel() {
    val userrepostry = localUserRepostryImp()
    private var currentstate = Resource.init<List<UserEntity>>()
    val state = MutableLiveData<Resource<List<UserEntity>>>(currentstate)

    fun getUsers() {
        viewModelScope.launch {
        userrepostry.getallUser().onEach {
            state.value = it
            }.launchIn(this)
        }
    }
    fun insertUser(user : UserEntity) {
        viewModelScope.launch {
            userrepostry.insertUser(user)
        }
    }
    fun delete(user : UserEntity){
        viewModelScope.launch {
            userrepostry.delete(user)
        }
    }
    fun deleteUser(uid: Int){
        viewModelScope.launch {
            userrepostry.deleteUser(uid)
        }
    }

}
