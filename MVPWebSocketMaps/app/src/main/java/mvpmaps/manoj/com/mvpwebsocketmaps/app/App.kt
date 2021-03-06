package mvpmaps.manoj.com.mvpwebsocketmaps.app

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import mvpmaps.manoj.com.mvpwebsocketmaps.BuildConfig
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.NetworkModule
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.WebSocket
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.DaggerAppComponent
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import java.io.File
import javax.inject.Inject

/**
 * Created by priyamanoj on 2018-02-05.
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        val cacheFile = File(cacheDir, "responses")
        val networkModule = NetworkModule(cacheFile);
        DaggerAppComponent.builder().application(this).service(networkModule.providesService()).webSocket(WebSocket(BuildConfig.WSURL)).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}