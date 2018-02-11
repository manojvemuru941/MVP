package mvpmaps.manoj.com.mvpwebsocketmaps.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import rx.Observable
import rx.subjects.PublishSubject

/**
 * Created by priyamanoj on 2018-02-07.
 */
class MemberModel : DataUpdateModel.MemberDataUpdateModel  {

    private val memberModelUpdateSubject: PublishSubject<MemberModel> = PublishSubject.create()

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

    override fun observeUpdateMemberModel(): Observable<MemberModel> {
        return memberModelUpdateSubject.asObservable()
    }

    fun updateMemberData(memberModel:MemberModel) {

        this.id = memberModel.id
        this.name = memberModel.name
        this.desc = memberModel.desc
        this.lat = memberModel.lat
        this.long = memberModel.long
        this.image = memberModel.image
        this.bitmap = memberModel.bitmap

        /*
            this update the list of observers for the data update
         */
        memberModelUpdateSubject.onNext(memberModel)
    }
}