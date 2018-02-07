package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvpmaps.manoj.com.mvpwebsocketmaps.dagger.FragmentScope

/**
 * Created by priyamanoj on 2018-02-07.
 */
@FragmentScope
@Module
abstract class MembersListFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector(modules = [MembersListFragmentModule::class])
    abstract fun contributesMemberListFragment(): MembersListFragment
}