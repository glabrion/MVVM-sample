package ru.glabrion.main.screens.general

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlin.coroutines.CoroutineContext

class GeneralRepository : CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    suspend fun getContentDB(): String {
        delay(2000)
        return "HELLO MVVM"
    }
}