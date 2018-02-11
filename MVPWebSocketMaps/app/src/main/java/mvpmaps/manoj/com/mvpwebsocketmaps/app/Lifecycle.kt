package mvpmaps.manoj.com.mvpwebsocketmaps.app

import android.os.Bundle
import android.view.View

/**
 * Created by priyamanoj on 2018-02-11.
 */
interface Lifecycle {
    fun onStart()
    fun onCreate(view: View, bundle: Bundle?)
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
}