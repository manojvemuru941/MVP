package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import com.google.android.gms.maps.OnMapReadyCallback
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel

/**
 * Created by priyamanoj on 2018-02-06.
 */
interface MapViewContract {

    interface View {

    }

    interface Presenter : OnMapReadyCallback{
        fun setMemberLocation(memberModel: MemberModel)
    }
}