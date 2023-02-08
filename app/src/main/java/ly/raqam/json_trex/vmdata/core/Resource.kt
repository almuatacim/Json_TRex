package ly.raqam.json_trex.vmdata.core

sealed class Resource<T> {
     class loading<T> : Resource<T>()
     class init<T> : Resource<T>()
     class Success <T> (var data : T): Resource<T>()
     class Error <T> (var message : String): Resource<T>()
}