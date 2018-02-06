package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*
import mvpmaps.manoj.com.mvpwebsocketmaps.R
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.newMapActivytIntent
import mvpmaps.manoj.com.mvpwebsocketmaps.viewmodel.UserViewModel
import javax.inject.Inject


/**
 * Created by priyamanoj on 2018-02-05.
 */
class HomeFragment : Fragment(),View.OnClickListener, HomeFragmentContract.View {

    companion object {
        var TAG = "HomeFragment"
    }

    @Inject
    lateinit var presenter: HomeFragmentContract.HomePresenter;

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        var view:View = inflater!!.inflate(R.layout.home_fragment,
                container, false)

        view.login_button.setOnClickListener(this)

        return view;
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            login_button.id -> {
                presenter.login()
            }
        }
    }

    override fun showWait() {
        this.view?.progress?.bringToFront()
        this.view?.progress?.visibility = View.VISIBLE
    }

    override fun removeWait() {
        this.view?.progress?.visibility = View.GONE
    }

    override fun onFailure(appErrorMessage: String) {
        Toast.makeText(context, appErrorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun success(response: UserViewModel) {
        startActivity(Intent(activity.applicationContext, MapViewActivity::class.java))
    }

}