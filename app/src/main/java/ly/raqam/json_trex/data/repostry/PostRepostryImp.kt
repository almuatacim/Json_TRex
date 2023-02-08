package ly.raqam.json_trex.data.repostry

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ly.raqam.json_trex.data.domain.ApiServer
import ly.raqam.json_trex.data.model.ListPost
import ly.raqam.json_trex.vmdata.entity.resource.ResourceFack
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostRepostryImp: PostRepostry {
    override fun getPosts(): Flow<ResourceFack<ListPost>> {
        var server = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiServer::class.java)
        return flow {
            emit(ResourceFack.Loading<ListPost>())
            var result =  server.getPost()
            if (result.isSuccessful){
                emit(ResourceFack.Success<ListPost>(data = result.body()!!))
            }else{
                emit(ResourceFack.Error<ListPost>(message = "Error happens"))
            }
        }
    }
}