package com.example.hasee.myprojectframework.ui

import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.hasee.myprojectframework.R
import com.example.hasee.myprojectframework.contract.Node
import com.example.hasee.myprojectframework.contract.asd
import com.example.hasee.myprojectframework.svg.SvgSoftwareLayerSetter
import com.example.hasee.myprojectframework.ui.home.HomeParentFragment
import com.example.hasee.myprojectframework.ui.home.adapter.ViewPageAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import nl.komponents.kovenant.task
import nl.komponents.kovenant.then
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var vpAdapter: ViewPageAdapter? = null
    private var fm: FragmentManager? = null
    private val test : String?
    get() {
        return getString()?.let {
            Log.i("我怒号","----》我怒号")
            it
        }?: run {
            Log.i("我怒号","----》我怒号1")
            "我怒号"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fm = childFragmentManager
        vpAdapter = ViewPageAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        fragments.add(HomeParentFragment.newInstance("", ""))
        fragments.add(PersonalDetailFragment.newInstance("", ""))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    val properties: MutableList<UserProperty> = mutableListOf()

    fun <T : UserProperty> getByRef(ref: String) = properties.firstOrNull {
        it.ref == ref
    }!! as T


    class UserProperty(var ref: String, var name: String) {

        private val value: String
            get() = this.toString()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vp.adapter = vpAdapter
        vpAdapter!!.updataList(fragments!!)

        var sd: asd = asd()
        sd.testcallback1 { l ->
            Log.i("testcallback1", "---->$l" + "llasdasdasd")
            Log.i("testcallback1", "---->")
        }

        val result = sd.testcallback2(1, 2) { l, s ->
            /*l + s*/Log.i("testcallback2", "---->$l  s =  $s")
            Log.i("testcallback2", "---->$l  s =  $s")
        }

        var resources: MutableList<Node> = mutableListOf()
        var names: String = "洒水多"
        val index = resources.indexOfFirst { it.name == names }
        if (index == -1)
            Log.i("testcallback1", "---->result = $result")

//        GlobalScope.launch(Dispatchers.IO) {
//            Log.i("launch", "---->launch = ${Looper.getMainLooper().thread.id}    Thread.currentThread() =   ${Thread.currentThread().id}")
//            Thread.sleep(2000)
//            GlobalScope.launch(Dispatchers.Main) {
//                Log.i("launch", "---->launch1 = ${Looper.getMainLooper().thread.id}    Thread.currentThread() =   ${Thread.currentThread().id}")
//            }
//        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.i("launch", "---->launch2 = ${Looper.getMainLooper().thread.id}    Thread.currentThread() =   ${Thread.currentThread().id}")
            task {
                Log.i("launch", "---->launch3 = ${Looper.getMainLooper().thread.id}    Thread.currentThread() =   ${Thread.currentThread().id}")
            }.then {
                Log.i("launch", "---->launch4 = ${Looper.getMainLooper().thread.id}    Thread.currentThread() =   ${Thread.currentThread().id}")
                Thread.sleep(2000)
            }
            Log.i("launch", "---->launch5 = ${Looper.getMainLooper().thread.id}    Thread.currentThread() =   ${Thread.currentThread().id}")
        }

        for (i in 1..5) {
            var userProperty = UserProperty("你好1$i", "你好2$i")
            properties.add(userProperty)
        }

        var sdasdas = getByRef<UserProperty>("你好12").let {

            Log.i("UserProperty", "---->UserProperty = $it  it.ref = ${it.ref}   it.name = ${it.name}")
        }
        Log.i("test","---->test = $test")
    }

    fun getString() : String ?{
        return null
    }

    public fun setViewPageScroll(noScroll: Boolean) {
        vp.noScroll = noScroll
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

}
