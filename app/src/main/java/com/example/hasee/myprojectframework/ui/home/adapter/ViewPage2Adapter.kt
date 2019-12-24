package com.example.hasee.myprojectframework.ui.home.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPage2Adapter constructor(fm: FragmentManager) : /*FragmentPagerAdapter*/FragmentStateAdapter(fm) {


    private var fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var context: Context? = null
    private var fm: FragmentManager? = fm


    constructor(context: Context?, fm: FragmentManager) : this(fm) {
        this.context = context
        this.fm = fm
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }


    override fun getItemCount(): Int {
        return fragments.size
    }

    public fun updataList(fragments: MutableList<Fragment>) {
        this.fragments.clear()
        this.fragments.addAll(fragments)
        notifyDataSetChanged()
    }

}