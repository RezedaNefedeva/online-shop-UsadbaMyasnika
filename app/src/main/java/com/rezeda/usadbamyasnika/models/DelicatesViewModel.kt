package com.rezeda.usadbamyasnika.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezeda.usadbamyasnika.repository.DelicatesRepository

class DelicatesViewModel : ViewModel() {

    private val repository: DelicatesRepository
    private val _allDelicates = MutableLiveData<List<Delicates>>()
    val allDelicates: LiveData<List<Delicates>> = _allDelicates

    init {
        repository = DelicatesRepository().getInstance()
        repository.loadDelicates(_allDelicates)
    }
}