package mvpmaps.manoj.com.mvpwebsocketmaps.model

import com.google.gson.annotations.SerializedName
import rx.Observable
import rx.subjects.PublishSubject
import kotlin.collections.ArrayList

/**
 * Created by priyamanoj on 2018-02-09.
 */

class FamilyModel : DataUpdateModel.FamilyDataUpdateModel {

    private val familyModelUpdateSubject = PublishSubject.create<FamilyModel>()

    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("membersCount")
    var membersCount: Int = 0

    @SerializedName("members")
    var members:ArrayList<MemberModel> = ArrayList()

    fun updateData(familyModel: FamilyModel) {
        this.id = familyModel.id
        this.name = familyModel.name
        this.membersCount = familyModel.membersCount
        this.members = familyModel.members

        /*
            this update the list of observers for the data update
         */
        familyModelUpdateSubject.onNext(familyModel)
    }

    override fun observeUpdateFamilyModel(): Observable<FamilyModel> {
        return familyModelUpdateSubject.asObservable()
    }

}