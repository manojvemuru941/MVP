package mvpmaps.manoj.com.mvpwebsocketmaps.model

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-07.
 */
class FamilyModel() : Parcelable{

    @SerializedName("id")
    var id:String? = null

    @SerializedName("name")
    var name:String? = null

    @SerializedName("membersCount")
    var membersCount:Int? = null

    @SerializedName("members")
    var members:ArrayList<MemberModel>? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        membersCount = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeValue(membersCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FamilyModel> {
        override fun createFromParcel(parcel: Parcel): FamilyModel {
            return FamilyModel(parcel)
        }

        override fun newArray(size: Int): Array<FamilyModel?> {
            return arrayOfNulls(size)
        }
    }

}