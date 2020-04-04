package ru.glabrion.main.screens.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_general.*
import ru.glabrion.R
import ru.glabrion.base.view.BaseFragment
import ru.glabrion.common.Status
import ru.glabrion.common.toast
import ru.glabrion.main.MainActivity

class GeneralFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_general, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainViewModel = ViewModelProviders.of(this).get(GeneralViewModel::class.java)

        mainViewModel.content.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> showLoading()
                Status.SUCCESS -> showSuccess(it.data)
                Status.ERROR -> showError()
            }
        })
        mainViewModel.getContent()
    }

    private fun showError() {
        toast("Ошибка загрузки данных")
    }

    private fun showSuccess(data: String?) {
        (activity as? MainActivity)?.hideProgress()
        data?.apply {
            content.text = data
        }
        toast("Данные получены!")
    }

    private fun showLoading() {
        (activity as? MainActivity)?.showProgress()
    }
}
