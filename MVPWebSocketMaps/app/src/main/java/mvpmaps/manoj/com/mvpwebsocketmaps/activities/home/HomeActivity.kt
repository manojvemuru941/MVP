package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_home.*
import mvpmaps.manoj.com.mvpwebsocketmaps.R
import mvpmaps.manoj.com.mvpwebsocketmaps.addFragmentToActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        addFragmentToActivity(supportFragmentManager, HomeFragment(), fragment.id)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}
/*
    private fun loginView(needsTransition:Boolean) {
        fragment.removeAllViews()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val homeFragment = HomeFragment();

        if(needsTransition) {
            fragmentTransaction.add(fragment.id ,homeFragment, HomeFragment.TAG)
        } else {
            fragmentTransaction.add(fragment.id ,homeFragment, HomeFragment.TAG)
        }

        fragmentTransaction.commit()
        fragment.bringToFront()
    }

    override fun loginSuccess() {
        fragment.removeAllViews()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val mapViewFragment = MapViewFragment();
        fragmentTransaction.add(fragment.id, mapViewFragment, MapViewFragment.TAG)
        fragmentTransaction.commit()
        fragment.bringToFront()
    }

    override fun logoutSuccess() {
        loginView(true)
    }
*/

