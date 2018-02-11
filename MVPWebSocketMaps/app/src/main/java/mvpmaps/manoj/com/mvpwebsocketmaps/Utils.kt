package mvpmaps.manoj.com.mvpwebsocketmaps

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.google.gson.GsonBuilder
import mvpmaps.manoj.com.mvpwebsocketmaps.activities.mapview.MapViewActivity
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

/**
 * Created by priyamanoj on 2018-02-05.
 */

fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment, containerViewId: Int) {
    val transaction = fragmentManager.beginTransaction()
    transaction.add(containerViewId, fragment)
    transaction.commit()
}

fun newMapActivytIntent(context: Context, any: Any, bundle: Bundle)  {
    val intent = Intent(context, MapViewActivity::class.java)
    intent.putExtras(bundle)
    context.startActivity(intent)
}

private fun loadJSONFromAsset(context: Context): String? {
    var json: String? = null
    try {
        val file = context.assets.open("members.json")
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

fun loadDummyData(context: Context): ArrayList<MemberModel> {
    val data:String? = loadJSONFromAsset(context)
    val jsonObject: JSONObject = JSONObject(data).getJSONObject("family")
    val gson = GsonBuilder().create()
    val familyModel: FamilyModel = gson.fromJson(jsonObject.toString(), FamilyModel::class.java)
    familyModel.members?.forEach {
        it.bitmap = loadBitmap(context, it.image.toString())
    }
    return when(familyModel.membersCount!! > 0){
        true -> familyModel.members as ArrayList<MemberModel>
        false -> ArrayList()
    }
}

fun loadBitmap(context: Context, name:String) : Bitmap {
    var imageInput:InputStream = context?.assets!!.open("member-images/"+name)
    return BitmapFactory.decodeStream(imageInput)
}

inline fun <reified T : Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = newArray(size)
        }

var TAG_FAMILY = "FAMILY_MODEL"

