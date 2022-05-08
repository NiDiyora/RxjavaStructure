package com.example.cleancoderxjava.presentation.base

import androidx.lifecycle.*
import com.example.cleancoderxjava.comman.Utils.debounce
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.nio.channels.spi.AbstractSelector

class ViewStateStore<T : Any>(initialState: T) {

    private val stateLiveData = MutableLiveData<T>().apply {
        value = initialState
    }

    val state: T
        get() = stateLiveData.value!!


    fun <S> observe(
        owner: LifecycleOwner,
        selector: (T) -> S,
        onDataChanged: Boolean = true,
        debounce: Long = 0L,
        observer: Observer<S>
    ) {
        when {
            onDataChanged ->
                stateLiveData.map(selector).distinctUntilChanged().observe(owner, observer)
            debounce != 0L ->
                stateLiveData.map(selector).debounce(debounce, CoroutineScope(Dispatchers.Main))
                    .observe(owner, observer)
            else ->
                stateLiveData.map(selector).observe(owner, observer)
        }
    }

    fun dispatchState(state: T) {
        stateLiveData.value = state
    }

    fun <S> observe(
        selector: (T) -> S,
        observer: Observer<S>
    ) {
        stateLiveData.map(selector).observeForever(observer)
    }
}