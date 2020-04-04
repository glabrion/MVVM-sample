package ru.glabrion.main.screens.general

import android.app.Application
import androidx.lifecycle.MutableLiveData
import ru.glabrion.base.viewmodel.BaseViewModel
import ru.glabrion.common.Event

class GeneralViewModel(application: Application) : BaseViewModel(application) {

    val content = MutableLiveData<Event<String>>()

    private val mainRepository =
        GeneralRepository()

    fun getContent() {
        getData(content){mainRepository.getContentDB()}
    }
}

