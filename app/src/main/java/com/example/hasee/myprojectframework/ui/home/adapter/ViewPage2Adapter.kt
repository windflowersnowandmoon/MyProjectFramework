package com.example.hasee.myprojectframework.ui.home.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.hasee.myprojectframework.R

class ViewPage2Adapter constructor(activity: FragmentActivity) : /*FragmentPagerAdapter*/FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments.get(position)
    }


    private var fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var context: Context? = null
    //    private var fm: FragmentManager? = fm
    private var activity: FragmentActivity? = activity


//    constructor(context: Context?, fm: FragmentManager) : this(fm) {
//        this.context = context
//        this.fm = fm
//    }

    constructor(context: Context?, activity: FragmentActivity) : this(activity) {
        this.context = context
        this.activity = activity
    }

    override fun onBindViewHolder(holder: FragmentViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
//        var itemView : FragmentViewHolder = FragmentViewHolder.create()
    }

//
//    override fun getItem(position: Int): Fragment {
//        return fragments.get(position)
//    }
//
//
//    override fun getItemCount(): Int {
//        return fragments.size
//    }


//    class MyHolder constructor(container : FrameLayout) : FragmentViewHolder(container) {
//
//    }

    public fun updataList(fragments: MutableList<Fragment>) {
        this.fragments.clear()
        this.fragments.addAll(fragments)
        notifyDataSetChanged()
    }

}