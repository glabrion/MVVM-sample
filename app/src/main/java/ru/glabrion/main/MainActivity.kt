package ru.glabrion.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.glabrion.R
import ru.glabrion.base.view.BaseActivity
import ru.glabrion.common.ProgressManager
import ru.glabrion.common.gone
import ru.glabrion.common.visible
import ru.glabrion.main.screens.general.GeneralFragment

class MainActivity : BaseActivity(), ProgressManager {

  override val layoutResId: Int
    get() = R.layout.activity_main

  override fun init(state: Bundle?) {
    openGeneralScreen()
  }

  override fun showProgress() {
    main_progress.visible()
  }

  override fun hideProgress() {
    main_progress.gone()
  }

  private fun openGeneralScreen(){
    val generalFragment = GeneralFragment()
    supportFragmentManager.beginTransaction().replace(
      R.id.main_fragment_container,
      generalFragment
    ).addToBackStack(generalFragment.tag)
      .commit()
  }
}