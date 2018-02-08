package mvpmaps.manoj.com.mvpwebsocketmaps.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-07.
 */
class FamilyModel :BaseModel(){

    @SerializedName("membersCount")
    var membersCount:Int? = null

    @SerializedName("members")
    var members:ArrayList<MemberModel>? = null

}