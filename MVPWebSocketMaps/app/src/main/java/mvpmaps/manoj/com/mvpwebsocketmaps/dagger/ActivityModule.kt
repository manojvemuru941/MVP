package mvpmaps.manoj.com.mvpwebsocketmaps.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.home.HomeActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.home.HomeFragmentProvider
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewFragmentProvider
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist.MembersListActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist.MembersListFragmentProvider

/**
 * Created by priyamanoj on 2018-02-05.
 */

@ActivityScope
@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [HomeFragmentProvider::class])
    abstract fun contributesHomeActivity(): HomeActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MapViewFragmentProvider::class])
    abstract fun contributesMapViewActivity() : MapViewActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MembersListFragmentProvider::class])
    abstract fun contributesMemberListActivity() : MembersListActivity
}