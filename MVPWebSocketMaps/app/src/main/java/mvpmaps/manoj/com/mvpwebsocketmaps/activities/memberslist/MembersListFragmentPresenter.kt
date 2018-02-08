package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.app.Application
import android.content.Context
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import javax.inject.Inject
import org.json.JSONObject
import java.io.IOException
import android.graphics.BitmapFactory
import com.google.gson.GsonBuilder
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import java.io.InputStream
import java.nio.charset.Charset


/**
 * Created by priyamanoj on 2018-02-07.
 */
class MembersListFragmentPresenter @Inject constructor(context: Application) :MembersListContract.Presenter {

    private var context:Context? = null
    private var adapter:MemberListAdapter? = null
    init {
        this.context = context
    }
    override fun getMembersList(): ArrayList<MemberModel> {

        return  loadDummyData()
    }

    override fun getListAdapter(): MemberListAdapter {
        adapter = MemberListAdapter(getMembersList())
        return adapter as MemberListAdapter
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val file = context!!.applicationContext.assets.open("members.json")
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    private fun loadDummyData(): ArrayList<MemberModel> {
        val data:String? = loadJSONFromAsset()
        val jsonObject:JSONObject = JSONObject(data).getJSONObject("family")
        val gson = GsonBuilder().create()
        val familyModel:FamilyModel = gson.fromJson(jsonObject.toString(), FamilyModel::class.java)
        familyModel.members?.forEach {
            var imageInput:InputStream = context?.assets!!.open("member-images/"+it.image)
            it.bitmap = BitmapFactory.decodeStream(imageInput)
        }
        return when(familyModel.membersCount!! > 0){
            true -> familyModel.members as ArrayList<MemberModel>
            false -> ArrayList()
        }
    }
}