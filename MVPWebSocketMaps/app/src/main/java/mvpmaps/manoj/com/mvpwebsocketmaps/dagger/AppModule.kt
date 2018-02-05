package mvpmaps.manoj.com.mvpwebsocketmaps.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by priyamanoj on 2018-02-01.
 */
@Module
class AppModule(private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app
}