package com.jinxtris.ram.headapp

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), BaseView {

    fun setEnableDisableClick(isLoading:Boolean, view: View){
        view.isClickable = isLoading
    }

    fun showKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = this.requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun hideKeyboard() {
        val view = this.requireActivity().currentFocus
        if (view != null) {
            val imm = this.requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
    }
}