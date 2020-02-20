package com.jinxtris.ram.headapp.viewModel.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jinxtris.ram.headapp.BaseFragment
import com.jinxtris.ram.headapp.R
import com.jinxtris.ram.headapp.model.Root
import com.jinxtris.ram.headapp.viewModel.MainViewModel


class HomeFragment : BaseFragment() {
    private lateinit var mainViewModel: MainViewModel
    private var rootData: Root = Root()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun initializeResources() {
        mainViewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")


        mainViewModel.callService()

        mainViewModel.rootLiveData.observe(viewLifecycleOwner, Observer {
            rootData = it

            if (rootData.categories!!.size > 0) {

            }

            if (rootData.rankings!!.size > 0) {

            }
        })

        /*portfolioModel.orderHistoryLiveDataList.observe(viewLifecycleOwner, Observer {

            val latestCount =
                PreferenceHelper.customPrefs(this.requireContext(), USER_ID)
                    .getInt(ParamConstants.PARAM_LATEST_COUNT, 0)
            val previousCount =
                PreferenceHelper.customPrefs(this.requireContext(), USER_ID)
                    .getInt(ParamConstants.PARAM_PREVIOUS_COUNT, 0)
            if (latestCount > previousCount) {
                ivNotification.visibility = View.VISIBLE
            } else {
                ivNotification.visibility = View.GONE
            }
            //compre shared pref
        })*/

    }

}
