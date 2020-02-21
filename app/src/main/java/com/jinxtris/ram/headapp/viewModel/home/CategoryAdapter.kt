package com.jinxtris.ram.headapp.viewModel.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.jinxtris.ram.headapp.R
import com.jinxtris.ram.headapp.model.Categories
import kotlinx.android.synthetic.main.adapter_spinner.view.*

class CategoryAdapter(
    ctx: Context,
    category: List<Categories>
) :
    ArrayAdapter<Categories>(ctx, 0, category) {
    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val categories = getItem(position)
        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.adapter_spinner,
            parent,
            false
        )

        view.txt_spinner_title.text = categories.name
        return view
    }
}