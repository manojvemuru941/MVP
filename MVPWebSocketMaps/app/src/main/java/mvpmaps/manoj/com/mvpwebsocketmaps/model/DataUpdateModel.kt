package mvpmaps.manoj.com.mvpwebsocketmaps.model

import com.google.gson.annotations.SerializedName

/**
 * Created by priyamanoj on 2018-02-09.
 */
interface DataUpdateModel {
    companion object {
        val FAMILY_UPDATE:Int = 0
        val MEMBER_UPDATE:Int = 1;
    }

    interface FamilyDataUpdateModel {
        fun observeUpdateFamilyModel(): rx.Observable<FamilyModel>
    }

    interface MemberDataUpdateModel {
        fun observeUpdateMemberModel(): rx.Observable<MemberModel>
    }

    public class Update {
        @SerializedName("updateType")
        var updateType:Int? = null

        @SerializedName("family")
        var familyModel:FamilyModel? = null

        @SerializedName("member")
        var memberModel:MemberModel? = null
    }
}