package mvpmaps.manoj.com.mvpwebsocketmaps.dagger

import dagger.Component
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.HTTPNetworkService
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.NetworkModule
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.HomeActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.HomeFragment
import javax.inject.Singleton

/**
 * Created by priyamanoj on 2018-02-05.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
     fun inject(homeActivity: HomeActivity)
}