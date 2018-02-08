package mvpmaps.manoj.com.mvpwebsocketmaps.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-07.
 */
class MemberModel :BaseModel() {
    @SerializedName("lat")
    var lat:String? = null

    @SerializedName("long")
    var long:String? = null

    @SerializedName("desc")
    var desc:String? = null

    @SerializedName("image")
    var image:String? = null

    var bitmap:Bitmap? = null;
}