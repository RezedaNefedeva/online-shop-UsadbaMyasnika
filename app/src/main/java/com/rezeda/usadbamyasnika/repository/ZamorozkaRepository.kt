package com.rezeda.usadbamyasnika.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.Kolbasa
import com.rezeda.usadbamyasnika.models.Zamorozka

class ZamorozkaRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Zamorozka")

    @Volatile private var INSTANCE : ZamorozkaRepository ?= null
    fun getInstance () : ZamorozkaRepository{
        return INSTANCE ?: synchronized(this){
            val instance = ZamorozkaRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadZamorozka (zamorozkaList: MutableLiveData<List<Zamorozka>>){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try{
                    val _zamorozkaList: List<Zamorozka> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Zamorozka::class.java)!!
                    }
                    zamorozkaList.postValue(_zamorozkaList)
                }
                catch (e: Exception){

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
