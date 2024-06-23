package com.rezeda.usadbamyasnika.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezeda.usadbamyasnika.repository.KolbasaRepository

class KolbasaViewModel : ViewModel() {

    private val repository: KolbasaRepository
    private val _allKolbasa = MutableLiveData<List<Kolbasa>>()
            val allKolbasa: LiveData<List<Kolbasa>> = _allKolbasa

    init {
        repository = KolbasaRepository().getInstance()
        repository.loadKolbasa(_allKolbasa)
    }
}