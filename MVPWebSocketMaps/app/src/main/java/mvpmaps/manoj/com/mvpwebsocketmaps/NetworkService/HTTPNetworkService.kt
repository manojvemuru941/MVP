package mvpmaps.manoj.com.mvpwebsocketmaps.NetworkService

import mvpmaps.manoj.com.mvpwebsocketmaps.BuildConfig
import retrofit2.http.POST
import rx.Observable
import mvpmaps.manoj.com.mvpwebsocketmaps.model.UserModel
import retrofit2.http.DELETE

/**
 * Created by priyamanoj on 2018-02-05.
 */
public interface HTTPNetworkService {

    @POST(BuildConfig.LOGIN)
     fun login(): Observable<UserModel>

    @DELETE(BuildConfig.LOGOUT)
    fun logout(): Observable<UserModel>
}