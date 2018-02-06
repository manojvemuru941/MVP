package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.FragmentScope

/**
 * Created by priyamanoj on 2018-02-06.
 */
@FragmentScope
@Module
abstract class MapViewFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MapViewFragmentModule::class])
    abstract fun contributesMapViewFragment(): MapViewFragment
}