package mvpmaps.manoj.com.mvpwebsocketmaps.model

import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-05.
 */
class UserModel {

    @SerializedName("result")
    var result:String? = null;

    @SerializedName("message")
    var message:String? = null;

    @SerializedName("family")
    var familyModel:FamilyModel? = null
}