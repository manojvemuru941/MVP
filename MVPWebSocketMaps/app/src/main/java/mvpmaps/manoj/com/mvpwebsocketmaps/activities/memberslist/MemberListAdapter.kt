package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.support.v7.widget.RecyclerView;
import android.view.View
import android.view.ViewGroup
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.member_item.view.*
import mvpmaps.manoj.com.mvpwebsocketmaps.R


/**
 * Created by priyamanoj on 2018-02-07.
 */
class MemberListAdapter constructor(membersList:ArrayList<MemberModel>) : RecyclerView.Adapter<MemberListAdapter.MemberViewHolder>() {
    private var membersList:ArrayList<MemberModel>? = null

    init {
        this.membersList = membersList;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MemberListAdapter.MemberViewHolder {
        val itemView:View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.member_item, parent, false)
        return MemberViewHolder(itemView)
    }

    override fun getItemCount(): Int = membersList?.size!!

    override fun onBindViewHolder(holder: MemberViewHolder?, position: Int) {
        var memberModel = membersList!![position]
        holder?.itemView?.member_name?.text = memberModel.name
        holder?.itemView?.member_desc?.text = memberModel.desc
        holder?.itemView?.imageView?.setImageBitmap(memberModel.bitmap)
    }


    inner class MemberViewHolder(view: View) : RecyclerView.ViewHolder(view)
}