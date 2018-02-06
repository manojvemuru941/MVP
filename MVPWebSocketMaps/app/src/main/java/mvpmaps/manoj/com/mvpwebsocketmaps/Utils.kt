package mvpmaps.manoj.com.mvpwebsocketmaps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewActivity

/**
 * Created by priyamanoj on 2018-02-05.
 */

fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment, containerViewId: Int) {
    val transaction = fragmentManager.beginTransaction()
    transaction.add(containerViewId, fragment)
    transaction.commit()
}

fun newMapActivytIntent(context: Context) :Intent {
    val intent = Intent(context, MapViewActivity::class.java)
    val bundle = Bundle()
    intent.putExtras(bundle)
    return intent
}
