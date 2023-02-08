package ly.raqam.json_trex.data.repostry

import kotlinx.coroutines.flow.Flow
import ly.raqam.json_trex.data.model.ListPost
import ly.raqam.json_trex.vmdata.entity.resource.ResourceFack

interface PostRepostry {
    fun getPosts() : Flow<ResourceFack<ListPost>>
}