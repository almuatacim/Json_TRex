package ly.raqam.json_trex.data.domain

import ly.raqam.json_trex.data.model.ListPost
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServer {
    @GET(value = "posts")
    suspend fun getPost(): Response<ListPost>
//    @POST
//    fun addPost()
}