package ru.glabrion.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.glabrion.common.Event
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(app: Application) : AndroidViewModel(app), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun <T> getData(
        liveData: MutableLiveData<Event<T>>,
        request: suspend () -> T
    ) {
        liveData.postValue(Event.loading())
        launch(coroutineContext) {
            try {
                val response = request.invoke()
                if (response != null) {
                    liveData.postValue(Event.success(response))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                liveData.postValue(Event.error(null))
            }
        }
    }
}