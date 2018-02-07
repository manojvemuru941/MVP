package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_home.*
import mvpmaps.manoj.com.mvpwebsocketmaps.R
import mvpmaps.manoj.com.mvpwebsocketmaps.addFragmentToActivity
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-07.
 */
class MembersListActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        addFragmentToActivity(supportFragmentManager, MembersListFragment(), fragment.id)
    }
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}