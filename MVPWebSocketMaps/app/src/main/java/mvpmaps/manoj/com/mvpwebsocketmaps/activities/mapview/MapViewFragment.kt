package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.SupportMapFragment
import dagger.android.support.AndroidSupportInjection
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-05.
 */
class MapViewFragment : SupportMapFragment(),MapViewContract.View {
    companion object {
        var TAG = MapViewFragment::class.java.name
    }

    @Inject
    lateinit var presenter: MapViewContract.Presenter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        var memberModel = this.arguments.getParcelable(TAG) as MemberModel
        presenter.setMemberLocation(memberModel)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        getMapAsync(presenter)

    }
}