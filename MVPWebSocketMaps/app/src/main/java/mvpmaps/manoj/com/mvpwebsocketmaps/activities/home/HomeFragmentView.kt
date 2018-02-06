package mvpmaps.manoj.com.mvpwebsocketmaps.activities.home

import mvpmaps.manoj.com.mvpwebsocketmaps.viewmodel.UserViewModel

/**
 * Created by priyamanoj on 2018-02-05.
 */
interface HomeFragmentView {
    fun showWait()

    fun removeWait()

    fun onFailure(appErrorMessage: String)

    fun success(response: UserViewModel)
}