package ly.raqam.json_trex.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ly.raqam.json_trex.data.model.ListPost
import ly.raqam.json_trex.data.repostry.PostRepostryImp
import ly.raqam.json_trex.vmdata.entity.resource.ResourceFack

class PostViewModel : ViewModel() {
    val postRepo = PostRepostryImp()
//    var state = Resource.Init<ListPost>()
    var postListstate = MutableLiveData<ResourceFack<ListPost>>()
    fun getDatafromApi(){
        viewModelScope.launch {
        postRepo.getPosts().onEach {
            postListstate.value = it
        }.launchIn(viewModelScope)
        }
    }
}