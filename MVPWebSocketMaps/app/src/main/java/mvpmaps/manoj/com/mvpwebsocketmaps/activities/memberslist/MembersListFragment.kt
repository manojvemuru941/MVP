package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import mvpmaps.manoj.com.mvpwebsocketmaps.R
import javax.inject.Inject
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.memberlist_fragment.view.*
import android.support.v7.widget.DefaultItemAnimator




/**
 * Created by priyamanoj on 2018-02-07.
 */
class MembersListFragment : Fragment(), MembersListContract.View {

    companion object {
        var TAG = MembersListFragment::class.java.name
    }

    @Inject
    lateinit var presenter: MembersListContract.Presenter;

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        var view:View = inflater!!.inflate(R.layout.memberlist_fragment,
                container, false)
        val mLayoutManager = LinearLayoutManager(context)
        view.member_list_recycler.layoutManager = mLayoutManager
        view.member_list_recycler.itemAnimator = DefaultItemAnimator()
        view.member_list_recycler.adapter = presenter.getListAdapter()
        (view.member_list_recycler.adapter as MemberListAdapter).getPositionClicks().subscribe {
            presenter.onItemClickListner(it)
        }
        return view;
    }
}