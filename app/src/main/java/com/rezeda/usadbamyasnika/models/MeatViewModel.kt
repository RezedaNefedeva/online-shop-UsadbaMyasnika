package com.rezeda.usadbamyasnika.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezeda.usadbamyasnika.repository.KolbasaRepository
import com.rezeda.usadbamyasnika.repository.MeatRepository

class MeatViewModel : ViewModel() {

    private val repository: MeatRepository
    private val _allMeat = MutableLiveData<List<Meat>>()
    val allMeat: LiveData<List<Meat>> = _allMeat

    init {
        repository = MeatRepository().getInstance()
        repository.loadMeat(_allMeat)
    }
}