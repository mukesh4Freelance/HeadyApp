package com.jinxtris.ram.headapp.viewModel.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jinxtris.ram.headapp.BaseFragment
import com.jinxtris.ram.headapp.R
import com.jinxtris.ram.headapp.extension.toast
import com.jinxtris.ram.headapp.model.Categories
import com.jinxtris.ram.headapp.model.Rankings
import com.jinxtris.ram.headapp.model.Root
import com.jinxtris.ram.headapp.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() {
    private lateinit var mainViewModel: MainViewModel
    private var rootData: Root = Root()
    private val listCategory = ArrayList<Categories>()
    private val listSubCategory = ArrayList<Categories>()
    private val listRanking = ArrayList<Rankings>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeResources()
    }

    override fun initializeResources() {
        mainViewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        //mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.callService()

        mainViewModel.rootLiveData.observe(viewLifecycleOwner, Observer {
            rootData = it

            if (rootData.categories!!.isNotEmpty()) {
                var categoryListData: Categories

                rootData.categories!!.forEach { it ->
                    categoryListData = it

                    if (it.child_categories!!.isNotEmpty()) {
                        listCategory.add(categoryListData)
                    } else {
                        listSubCategory.add(categoryListData)
                    }
                }

                fillCategorySpinner()
                fillSubCategorySpinner(0)
            }

            if (rootData.rankings!!.isNotEmpty()) {
                var rankingData: Rankings

                rootData.rankings!!.forEach {
                    rankingData = it
                    listRanking.add(rankingData)
                }

                setRankingAdapter()
            }
        })

        clickListner()
    }

    private fun clickListner() {
        spinner_home_category?.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                fillSubCategorySpinner(position)
            }

        }
    }

    private fun fillCategorySpinner() {
        spinner_home_category.adapter = CategoryAdapter(requireContext(), listCategory)
    }

    private fun fillSubCategorySpinner(position: Int) {
        var tempSubCategory = ArrayList<Categories>()
        var childCategory = ArrayList<String>()

        childCategory = listCategory[position].child_categories as ArrayList<String>

        listCategory.forEach { cat ->
            if (childCategory.contains(cat.id.toString())) {
                tempSubCategory.add(cat)

                cat.child_categories!!.forEach {
                    childCategory.add(it)
                }
            }
        }

        listSubCategory.forEach {
            if (childCategory.contains(it.id.toString())) {
                tempSubCategory.add(it)
            }
        }

        if (tempSubCategory.size > 0) {
            spinner_home_subcategory.adapter = CategoryAdapter(requireContext(), tempSubCategory)
        } else {
            spinner_home_subcategory.adapter = CategoryAdapter(requireContext(), tempSubCategory)
            toast("No Sub category for selected category")
        }
    }

    private fun setRankingAdapter() {
        val adapter = HomeAdapter(listRanking)
        rl_home_data.adapter = adapter
        adapter.notifyDataSetChanged()

        adapter.onItemClick = { rankingData ->
           /* val bundle = Bundle()
            bundle.putParcelable(ARG_ORDER_HISTORY_DATA, orderHistoryData)

            findNavController().navigate(
                R.id.action_orderHistoryFragment_to_orderDetailsFragment,
                bundle
            )*/
        }
    }

}
