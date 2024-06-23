package com.rezeda.usadbamyasnika.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rezeda.usadbamyasnika.repository.ZamorozkaRepository

class ZamorozkaViewModel : ViewModel() {

    private val repository: ZamorozkaRepository
    private val _allZamorozka = MutableLiveData<List<Zamorozka>>()
    val allZamorozka: LiveData<List<Zamorozka>> = _allZamorozka

    init {
        repository = ZamorozkaRepository().getInstance()
        repository.loadZamorozka(_allZamorozka)
    }
}