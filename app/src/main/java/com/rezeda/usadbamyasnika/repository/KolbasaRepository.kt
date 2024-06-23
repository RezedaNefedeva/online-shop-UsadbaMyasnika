package com.rezeda.usadbamyasnika.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.Kolbasa

class KolbasaRepository {
    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Kolbasa")

    @Volatile private var INSTANCE : KolbasaRepository ?= null
    fun getInstance () : KolbasaRepository{
        return INSTANCE ?: synchronized(this){
            val instance = KolbasaRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadKolbasa (kolbasaList: MutableLiveData<List<Kolbasa>>){
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try{
                    val _kolbasaList: List<Kolbasa> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Kolbasa::class.java)!!
                    }
                    kolbasaList.postValue(_kolbasaList)
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