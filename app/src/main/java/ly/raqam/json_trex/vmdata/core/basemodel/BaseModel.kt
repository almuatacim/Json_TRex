package ly.raqam.json_trex.vmdata.core.basemodel

abstract class BaseModel<M,E> {
    abstract fun convertoEntity():E
}