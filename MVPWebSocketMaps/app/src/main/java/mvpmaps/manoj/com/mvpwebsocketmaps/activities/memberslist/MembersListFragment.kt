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
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.DaggerAppComponent
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


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
        presenter.onCreate(view, Bundle())
        return view;
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}