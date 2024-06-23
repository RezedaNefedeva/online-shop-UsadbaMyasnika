package com.rezeda.usadbamyasnika.repository

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.Delicates

class DelicatesRepository {

    private val databaseReference : DatabaseReference = FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Delicates")

    @Volatile private var INSTANCE : DelicatesRepository ?= null
    fun getInstance () : DelicatesRepository{
        return INSTANCE ?: synchronized(this){
            val instance = DelicatesRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadDelicates (delicatesList: MutableLiveData<List<Delicates>>){
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try{
                    val _delicatesList: List<Delicates> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Delicates::class.java)!!
                    }
                    delicatesList.postValue(_delicatesList)
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
