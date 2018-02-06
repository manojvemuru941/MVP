package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import android.content.Context
import com.google.android.gms.maps.SupportMapFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-05.
 */
class MapViewFragment : SupportMapFragment(),MapViewContract.View {
    companion object {
        var TAG = "MapViewFragment"
    }

    @Inject
    lateinit var presenter: MapViewContract.Presenter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}