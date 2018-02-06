package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.FragmentScope

/**
 * Created by priyamanoj on 2018-02-05.
 */
@FragmentScope
@Module
abstract class HomeFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributesHomeFragment():HomeFragment
}