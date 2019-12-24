package com.example.hasee.myprojectframework.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.hasee.myprojectframework.R
import com.example.hasee.myprojectframework.ui.MainFragment
import com.example.hasee.myprojectframework.ui.home.adapter.ViewPage2Adapter
import kotlinx.android.synthetic.main.fragment_home_container.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeContainerFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeContainerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeContainerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var fragments: MutableList<Fragment>? = ArrayList<Fragment>()
    private var vpAdapter: ViewPage2Adapter? = null
    private var fm: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fm = childFragmentManager
        vpAdapter = ViewPage2Adapter(context, activity!!)
        fragments?.add(FollowFragment.newInstance("", ""))
        fragments?.add(RecommendFragment.newInstance("", ""))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_container, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    private fun initData() {
        vp2.adapter = vpAdapter
        vpAdapter!!.updataList(fragments!!)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeContainerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeContainerFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (parentFragment is HomeParentFragment) {
            var homeParentFragment = parentFragment as HomeParentFragment
            var fragment = homeParentFragment.parentFragment
            if (fragment is MainFragment) {
                fragment.setViewPageScroll(!hidden)
            }
        }
    }
}
