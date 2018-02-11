package mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview

import dagger.Binds
import dagger.Module
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.FragmentScope

/**
 * Created by priyamanoj on 2018-02-06.
 */
@FragmentScope
@Module
abstract class MapViewFragmentModule {
    @FragmentScope
    @Binds
    abstract fun provideMapView(mapViewFragment: MapViewFragment): MapViewContract.View

    @FragmentScope
    @Binds
    abstract fun provideMapViewPresenter(mapViewFragmentPresenter: MapViewFragmentPresenter) : MapViewContract.Presenter;

}