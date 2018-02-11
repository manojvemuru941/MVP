package mvpmaps.manoj.com.mvpwebsocketmaps.dagger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.NetworkModule
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.Service
import mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService.WebSocket
import mvpmaps.manoj.com.mvpwebsocketmaps.app.App
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import javax.inject.Singleton

/**
 * Created by priyamanoj on 2018-02-05.
 */
@Singleton
@Component(modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        Service::class,
        WebSocket::class,

        ActivityModule::class])

interface AppComponent {
     @Component.Builder
     interface  Builder {
            @BindsInstance
            fun application(application: Application): Builder

            @BindsInstance
            fun service(service: Service) :Builder

            @BindsInstance
            fun webSocket(webSocket: WebSocket) :Builder

            fun build(): AppComponent
     }

     fun inject(app: App)
}