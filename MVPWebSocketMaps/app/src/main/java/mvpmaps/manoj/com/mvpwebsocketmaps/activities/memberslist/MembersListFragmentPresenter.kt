package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.app.Application
import android.content.Context
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import javax.inject.Inject
import android.os.Bundle
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.loadDummyData
import mvpmaps.manoj.com.mvpwebsocketmaps.newMapActivytIntent


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

        return  loadDummyData(context?.applicationContext!!)
    }

    override fun getListAdapter(): MemberListAdapter {
        adapter = MemberListAdapter(getMembersList())
        return adapter as MemberListAdapter
    }

    override fun onItemClickListner(model: MemberModel) {
        model.bitmap = null
        var bundle = Bundle()
        bundle.putParcelable(MapViewActivity.TAG, model)
        newMapActivytIntent(context?.applicationContext!!, MapViewActivity::class.java, bundle)
    }
}