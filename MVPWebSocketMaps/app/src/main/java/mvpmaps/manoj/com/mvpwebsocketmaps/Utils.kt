package mvpmaps.manoj.com.mvpwebsocketmaps

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by priyamanoj on 2018-02-05.
 */

fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment, containerViewId: Int) {
    val transaction = fragmentManager.beginTransaction()
    transaction.add(containerViewId, fragment)
    transaction.commit()
}