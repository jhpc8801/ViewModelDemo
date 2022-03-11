package com.example.viewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Student : ViewModel() {

    // Mutable: allow to change it in the future
    var id = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var subject = MutableLiveData<Int>()

}