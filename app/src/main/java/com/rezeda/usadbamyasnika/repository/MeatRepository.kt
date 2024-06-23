package com.rezeda.usadbamyasnika.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.Kolbasa
import com.rezeda.usadbamyasnika.models.Meat

class MeatRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Meat")

    @Volatile private var INSTANCE : MeatRepository ?= null
    fun getInstance () : MeatRepository{
        return INSTANCE ?: synchronized(this){
            val instance = MeatRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadMeat (meatList: MutableLiveData<List<Meat>>){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try{
                    val _meatList: List<Meat> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Meat::class.java)!!
                    }
                    meatList.postValue(_meatList)
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
