package mvpmaps.manoj.com.mvpwebsocketmaps.activities.memberslist

import android.support.v7.widget.RecyclerView;
import android.view.View
import android.view.ViewGroup
import mvpmaps.manoj.com.mvpwebsocketmaps.model.MemberModel
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.member_item.view.*
import mvpmaps.manoj.com.mvpwebsocketmaps.R
import mvpmaps.manoj.com.mvpwebsocketmaps.model.FamilyModel
import rx.Observable
import rx.subjects.PublishSubject


/**
 * Created by priyamanoj on 2018-02-07.
 */
class MemberListAdapter constructor(familyModel: FamilyModel) : RecyclerView.Adapter<MemberListAdapter.MemberViewHolder>() {
    private var membersList:ArrayList<MemberModel>? = ArrayList()
    private val onClickSubject = PublishSubject.create<MemberModel>()
    private var familyModel: FamilyModel? = null

    init {
        this.familyModel = familyModel
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MemberListAdapter.MemberViewHolder {
        val itemView:View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.member_item, parent, false)
        return MemberViewHolder(itemView)
    }

    override fun getItemCount(): Int = when(membersList != null && membersList?.size!! > 0) {
        true -> membersList?.size!!
        false -> 0
    }

    override fun onBindViewHolder(holder: MemberViewHolder?, position: Int) {
        var memberModel = membersList!![position]
        holder?.itemView?.member_name?.text = memberModel.name
        holder?.itemView?.member_desc?.text = memberModel.desc
        holder?.itemView?.imageView?.setImageBitmap(memberModel.bitmap)
        holder?.itemView?.setOnClickListener({
            onClickSubject.onNext(membersList!![position])
        })
    }

    fun getPositionClicks(): Observable<MemberModel> {
        return onClickSubject.asObservable()
    }

    fun updateMembers(memberArrayList: ArrayList<MemberModel>) {
        when(this.membersList != null) {
            true -> this.membersList?.clear()
            false -> this.membersList = ArrayList()
        }
        this.membersList?.addAll(memberArrayList)
    }

    inner class MemberViewHolder(view: View) : RecyclerView.ViewHolder(view)
}