package mvpmaps.manoj.com.mvpwebsocketmaps.app

import android.app.Application
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.NetworkModule
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.AppComponent
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.AppModule
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.DaggerAppComponent
import java.io.File
/**
 * Created by priyamanoj on 2018-02-05.
 */
class App : Application() {
    var appComponent:AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        val cacheFile = File(cacheDir, "responses")
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(cacheFile))
                .build()
    }
}