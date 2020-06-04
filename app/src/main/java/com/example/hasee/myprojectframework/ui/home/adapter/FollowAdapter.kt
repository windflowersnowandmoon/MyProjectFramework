package com.peng.administrator.myobjectkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hasee.myprojectframework.R
import kotlinx.android.synthetic.main.follow_item.view.*
import java.util.*


/**
 *   $desc$
 *   作   者 :彭付林
 *   邮   箱 :pengfl@kingchannels.com
 *   日   期 :2019/12/4
 *   描   述 :个人信息
 */
class FollowAdapter constructor(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list: MutableList<String>? = ArrayList<String>()
    private var context: Context = context

//    init {
//        list = ArrayList<String>()
//    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var itemView: View = LayoutInflater.from(context).inflate(R.layout.follow_item, p0 , false)
        return MyViewHolde(itemView)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        p0.itemView.im.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.home_page_no_network2x))
    }

    private class MyViewHolde(itemView: View) : RecyclerView.ViewHolder(itemView)

    public fun updataList(list: MutableList<String>) {
        this.list?.clear()
        this.list?.addAll(list)
    }
}