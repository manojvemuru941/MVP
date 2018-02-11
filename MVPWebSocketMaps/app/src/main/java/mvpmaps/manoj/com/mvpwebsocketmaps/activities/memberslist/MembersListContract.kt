package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import mvpmaps.manoj.com.mvpwebsocketmaps.app.Lifecycle
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import rx.Observable

/**
 * Created by priyamanoj on 2018-02-07.
 */
interface MembersListContract {

    interface View {

    }

    interface Presenter : Lifecycle {
        fun getListAdapter():MemberListAdapter
        fun onItemClickListner(model: MemberModel)
    }
}