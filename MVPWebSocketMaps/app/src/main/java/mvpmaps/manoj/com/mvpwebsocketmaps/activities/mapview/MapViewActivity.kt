package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_map.*
import mvpmaps.manoj.com.mvpwebsocketmaps.R
import mvpmaps.manoj.com.mvpwebsocketmaps.addFragmentToActivity
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-06.
 */
class MapViewActivity : AppCompatActivity(), HasSupportFragmentInjector {
    companion object {
        var TAG = MapViewActivity::class.java.name
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        var id = intent.getStringExtra(TAG) as String
        var mapViewFragment = MapViewFragment()

        var bundle = Bundle()
        bundle.putString(MapViewFragment.TAG, id)
        mapViewFragment.arguments = bundle

        addFragmentToActivity(supportFragmentManager, mapViewFragment, fragment_map.id)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}