package ly.raqam.json_trex.data.model


import com.google.gson.annotations.SerializedName

data class ListPostItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)