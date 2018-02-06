package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

/**
 * Created by priyamanoj on 2018-02-05.
 */
interface HomeFragmentContract {

    fun loginSuccess()

    fun logoutSuccess()

    interface HomePresenter {
        fun login()
        fun logout()
    }
}