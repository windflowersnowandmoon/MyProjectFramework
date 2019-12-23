package com.example.hasee.myprojectframework.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.common.base.BaseFragment
import com.example.hasee.myprojectframework.R
import com.example.hasee.myprojectframework.ui.messagecenter.MessagecenterFragment
import com.example.hasee.myprojectframework.ui.mycenter.UserCenterFragment
import com.example.hasee.myprojectframework.ui.samecity.SameCityFragment
import kotlinx.android.synthetic.main.fragment_home_parent.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeParentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeParentFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeParentFragment : BaseFragment() , View.OnClickListener{

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var ContainerId : Int = R.id.frame_container
    private var currentIndex: Int = 0
    private val fragments: MutableList<Fragment> = ArrayList<Fragment>()

    override fun initData() {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        fragments.add(HomeContainerFragment.newInstance("", ""))
        fragments.add(SameCityFragment.newInstance("", ""))
        fragments.add(MessagecenterFragment.newInstance("", ""))
        fragments.add(UserCenterFragment.newInstance("", ""))
    }

    override fun setLayout(): Int {
        return R.layout.fragment_home_parent
    }

    /**
     * 在onCreateView的时候调用控件对象，这个时候控件为null
     */
    override fun initView(view: View?) {
//        line1.setOnClickListener(this)
//        line2.setOnClickListener(this)
//        line3.setOnClickListener(this)
//        line4.setOnClickListener(this)
//        line4.setOnClickListener(this)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        switchFragmentShow(fragments.get(0) , ContainerId)
        line1.setOnClickListener(this)
        line2.setOnClickListener(this)
        line3.setOnClickListener(this)
        line4.setOnClickListener(this)
        line4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var id = v?.id
        when (id) {
            R.id.line1 -> switchFragment(0)
            R.id.line2 -> switchFragment(1)
            R.id.line3 -> {

            }
            R.id.line4 -> switchFragment(2)
            R.id.line5 -> {
                switchFragment(3)
            }

            else -> {
                switchFragment(0)
            }
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeParentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeParentFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    public fun switchFragment(tabIndex: Int) {
        if (currentIndex != tabIndex) {
            var transaction = childFragmentManager!!.beginTransaction()
            var formFragment = fragments.get(currentIndex)
            var toFragment = fragments.get(tabIndex)
            if (!toFragment.isAdded) {
                var simpleName = toFragment.javaClass.simpleName
                transaction.hide(formFragment).add(ContainerId, toFragment, simpleName)
            } else {
                transaction.hide(formFragment).show(toFragment)
            }
            transaction.addToBackStack(null)
            transaction.commit()
            currentIndex = tabIndex
        }
    }
}
