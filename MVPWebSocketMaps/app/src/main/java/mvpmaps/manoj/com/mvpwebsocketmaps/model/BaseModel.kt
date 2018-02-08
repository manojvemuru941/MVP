package mvpmaps.manoj.com.mvpwebsocketmaps.model

import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-07.
 */
open class BaseModel {
    @SerializedName("id")
    var id:String? = null

    @SerializedName("name")
    var name:String? = null
}