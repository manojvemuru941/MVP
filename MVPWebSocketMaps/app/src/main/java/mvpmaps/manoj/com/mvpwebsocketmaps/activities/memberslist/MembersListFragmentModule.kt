package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import dagger.Binds
import dagger.Module
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.FragmentScope

/**
 * Created by priyamanoj on 2018-02-07.
 */
@FragmentScope
@Module
abstract class MembersListFragmentModule {
    @FragmentScope
    @Binds
    abstract fun provideMemberListView(membersListFragment: MembersListFragment): MembersListContract.View

    @FragmentScope
    @Binds
    abstract fun provideMemberListPresenter(membersListFragmentPresenter: MembersListFragmentPresenter) : MembersListContract.Presenter;
}