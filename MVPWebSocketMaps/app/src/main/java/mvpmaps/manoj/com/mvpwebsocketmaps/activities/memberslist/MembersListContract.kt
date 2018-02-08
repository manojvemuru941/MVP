package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel

/**
 * Created by priyamanoj on 2018-02-07.
 */
interface MembersListContract {

    interface View {}
    interface Presenter {
        fun getMembersList():ArrayList<MemberModel>
        fun getListAdapter():MemberListAdapter
        fun onItemClickListner(model: MemberModel)
    }
}