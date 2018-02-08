package mvpmaps.manoj.com.mvpwebsocketmaps.model

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by priyamanoj on 2018-02-07.
 */
class MemberModel() : Parcelable {

    @SerializedName("id")
    var id:String? = null

    @SerializedName("name")
    var name:String? = null

    @SerializedName("lat")
    var lat:Double? = null

    @SerializedName("long")
    var long:Double? = null

    @SerializedName("desc")
    var desc:String? = null

    @SerializedName("image")
    var image:String? = null

    @SerializedName("bitmap")
    var bitmap:Bitmap? = null;

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        name = parcel.readString()
        lat = parcel.readValue(Double::class.java.classLoader) as? Double
        long = parcel.readValue(Double::class.java.classLoader) as? Double
        desc = parcel.readString()
        image = parcel.readString()
        bitmap = parcel.readParcelable(Bitmap::class.java.classLoader)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeValue(lat)
        parcel.writeValue(long)
        parcel.writeString(desc)
        parcel.writeString(image)
        parcel.writeParcelable(bitmap, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MemberModel> {
        override fun createFromParcel(parcel: Parcel): MemberModel {
            return MemberModel(parcel)
        }

        override fun newArray(size: Int): Array<MemberModel?> {
            return arrayOfNulls(size)
        }
    }
}