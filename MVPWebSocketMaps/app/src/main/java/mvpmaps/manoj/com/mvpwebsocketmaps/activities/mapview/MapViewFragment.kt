package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mvpmaps.manoj.com.mvpwebsocketmaps.R

/**
 * Created by priyamanoj on 2018-02-05.
 */
class MapViewFragment : Fragment() {
    companion object {
        var TAG = "MapViewFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.mapview_fragment,
                container, false)



    }
}