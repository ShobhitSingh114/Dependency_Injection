package com.example.dependencyinjection

import androidx.lifecycle.ViewModel
import com.example.dependencyinjection.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>
): ViewModel() {

    // if we remove the init block we don't see the hello in logcat
    // bcz of lazy repo.
    init {
        // so in this case here inside init block repo. used first time so now dependency is created this time
        // when we use it
        repository.get()
    }
}