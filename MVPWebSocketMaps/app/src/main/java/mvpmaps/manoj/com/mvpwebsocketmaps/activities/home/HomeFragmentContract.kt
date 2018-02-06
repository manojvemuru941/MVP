package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import mvpmaps.manoj.com.mvpwebsocketmaps.viewmodel.UserViewModel

/**
 * Created by priyamanoj on 2018-02-05.
 */
interface HomeFragmentContract {

    interface View {
        fun showWait()

        fun removeWait()

        fun onFailure(appErrorMessage: String)

        fun success(response: UserViewModel)
    }

    interface HomePresenter {
        fun login()
        fun logout()
    }
}