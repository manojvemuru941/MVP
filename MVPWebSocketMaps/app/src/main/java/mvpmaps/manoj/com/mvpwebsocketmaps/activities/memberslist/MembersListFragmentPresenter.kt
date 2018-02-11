package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.app.Application
import android.content.Context
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import javax.inject.Inject
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.memberlist_fragment.view.*
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.WebSocket
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.app.FamilyLocatorMVP
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import mvpmaps.manoj.com.mvpwebsocketmaps.newMapActivytIntent
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by priyamanoj on 2018-02-07.
 */
class MembersListFragmentPresenter @Inject constructor(context: Application) : MembersListContract.Presenter {

    private var context:Context? = null
    private var adapter:MemberListAdapter? = null
    private var familyModel:FamilyModel? = null
    private var membersListSubcription: Subscription? = null

    @Inject
    lateinit var webSocket:WebSocket

    init {
        this.context = context
        this.familyModel = FamilyLocatorMVP.instance.familyModel
    }
    private fun getMembersList() {
        webSocket.connectWS()
    }


    private fun setUpObserver()  {
        membersListSubcription =  familyModel?.observeUpdateFamilyModel()!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    (this.adapter as MemberListAdapter).
                            updateMembers(it.members)
                    this.adapter!!.notifyDataSetChanged()
                }
    }

    override fun getListAdapter(): MemberListAdapter {
        adapter = MemberListAdapter(this!!.familyModel!!)
        return adapter as MemberListAdapter
    }

    override fun onItemClickListner(model: MemberModel) {
        model.bitmap = null
        var bundle = Bundle()
        bundle.putString(MapViewActivity.TAG, model.id)
        newMapActivytIntent(context?.applicationContext!!, MapViewActivity::class.java, bundle)
    }

    override fun onStart() {

    }

    override fun onCreate(view: View, bundle: Bundle?) {
        val mLayoutManager = LinearLayoutManager(context)
        view.member_list_recycler.layoutManager = mLayoutManager
        view.member_list_recycler.itemAnimator = DefaultItemAnimator()
        getMembersList()
        view.member_list_recycler.adapter = getListAdapter()
        (view.member_list_recycler.adapter as MemberListAdapter).getPositionClicks().subscribe {
            onItemClickListner(it)
        }
        setUpObserver()
    }

    override fun onResume() {

    }

    override fun onPause() {
        membersListSubcription?.unsubscribe()
    }

    override fun onStop() {

    }

    override fun onDestroy() {
        membersListSubcription?.unsubscribe()
    }
}