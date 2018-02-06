package mvpmaps.manoj.com.mvpwebsocketmaps.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.home.HomeActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.home.HomeFragmentProvider

/**
 * Created by priyamanoj on 2018-02-05.
 */

@ActivityScope
@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [HomeFragmentProvider::class])
    abstract fun contributesHomeActivity(): HomeActivity
}