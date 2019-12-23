package com.example.hasee.myprojectframework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.hasee.myprojectframework.R
import com.example.hasee.myprojectframework.ui.home.HomeParentFragment
import com.example.hasee.myprojectframework.ui.home.adapter.ViewPage2Adapter
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var fragments: MutableList<Fragment> = ArrayList<Fragment>()
    private var vpAdapter: ViewPage2Adapter? = null
    private var fm: FragmentManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fm = childFragmentManager
        vpAdapter = ViewPage2Adapter(context, fm!!)
        fragments.add(HomeParentFragment.newInstance("", ""))
        fragments.add(PersonalDetailFragment.newInstance("", ""))
    }

//    override fun initData() {
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//        vpAdapter = ViewPage2Adapter(context, fm)
//        fragments.add(HomeParentFragment.newInstance("", ""))
//        fragments.add(PersonalDetailFragment.newInstance("", ""))
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

//    override fun setLayout(): Int {
//        return R.layout.fragment_main
//    }


//    override fun initView(view: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vp.adapter = vpAdapter
        vpAdapter!!.updataList(fragments!!)
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