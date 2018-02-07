package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.app.Application
import android.content.Context
import mvpmaps.manoj.com.mvpwebsocketmaps.MemberModel
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-07.
 */
class MembersListFragmentPresenter @Inject constructor(context: Application) :MembersListContract.Presenter {

    private var context:Context? = null
    private var adapter:MemberListAdapter? = null
    init {
        this.context = context
    }
    override fun getMembersList(): ArrayList<MemberModel> {
        var listItems:ArrayList<MemberModel> = ArrayList()
        return  listItems
    }

    override fun getListAdapter(): MemberListAdapter {
        adapter = MemberListAdapter(getMembersList())
        return adapter as MemberListAdapter
    }
}