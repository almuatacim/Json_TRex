package ly.raqam.json_trex.vmdata.entity.resource

sealed class ResourceFack<T>(){
    class Init<T>: ResourceFack<T>()
    class Loading<T> : ResourceFack<T>()
    data class Success<T>(var data : T): ResourceFack<T>()
    data class Error<T>(var message : String): ResourceFack<T>()
}
