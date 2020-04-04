package ru.glabrion.common

import android.view.View
import android.widget.Toast
import ru.glabrion.base.view.BaseFragment

interface ProgressManager {
    fun showProgress()
    fun hideProgress()
}

fun BaseFragment.toast(msg: String) {
    activity?.apply {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}