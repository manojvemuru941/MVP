package mvpmaps.manoj.com.mvpwebsocketmaps.activities

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import mvpmaps.manoj.com.mvpwebsocketmaps.R


/**
 * Created by priyamanoj on 2018-02-05.
 */
class HomeFragment : Fragment() {
    companion object {
        var TAG = "HomeFragment"
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.home_fragment,
                container, false)
    }

}