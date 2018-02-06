package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import dagger.Binds
import dagger.Module
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.FragmentScope

/**
 * Created by priyamanoj on 2018-02-05.
 */
@FragmentScope
@Module
abstract class HomeFragmentModule {
    @FragmentScope
    @Binds
    abstract fun provideView(homeFragment: HomeFragment):HomeFragmentView

    @FragmentScope
    @Binds
    abstract fun providePresenter(homeFragmentPresenter: HomeFragmentPresenter) :HomeFragmentContract.HomePresenter;
}