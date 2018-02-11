package mvpmaps.manoj.com.mvpwebsocketmaps.app

import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel

/**
 * Created by priyamanoj on 2018-02-10.
 */
class FamilyLocatorMVP private constructor() {

    var familyModel:FamilyModel = FamilyModel()

    private object Holder { val INSTANCE = FamilyLocatorMVP() }

    companion object {
        val instance: FamilyLocatorMVP by lazy { Holder.INSTANCE }
    }

}