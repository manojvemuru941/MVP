package mvpmaps.manoj.com.mvpwebsocketmaps.viewmodel

import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-05.
 */
class UserViewModel {

    @SerializedName("result")
    var result:String? = null;

    @SerializedName("message")
    var message:String? = null;

}