package com.rezeda.usadbamyasnika

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.User

class RegFragment : Fragment() {

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_reg, container, false)

        val text_auth = view.findViewById<TextView>(R.id.text_auth)
        val text_reg = view.findViewById<TextView>(R.id.text_reg)
        val editTextName = view.findViewById<EditText>(R.id.editTextName)
        val editTextPhone = view.findViewById<EditText>(R.id.editTextPhone)
        val editTextPass = view.findViewById<EditText>(R.id.editTextPass)
        val btn_reg = view.findViewById<Button>(R.id.btn_reg)

        var mString_auth = "Авторизация"
        var mString_reg = "Регистрация"
        var mSpannableString_auth = SpannableString(mString_auth)
        var mSpannableString_reg = SpannableString(mString_reg)
        mSpannableString_reg.setSpan(UnderlineSpan(), 0, mSpannableString_reg.length, 0)
        text_reg.text = mSpannableString_reg
        text_auth.setOnClickListener {
            mSpannableString_auth = SpannableString(mString_auth)
            mSpannableString_auth.setSpan(UnderlineSpan(), 0, mSpannableString_auth.length, 0)
            text_auth.text = mSpannableString_auth
            text_auth.setTextColor(R.color.red)
            text_reg.text = mString_reg
            text_reg.setTextColor(R.color.black)
            findNavController().navigate(R.id.action_regFragment_to_profileFragment)
        }
        text_reg.setOnClickListener {
            mSpannableString_reg = SpannableString(mString_reg)
            mSpannableString_reg.setSpan(UnderlineSpan(), 0, mSpannableString_reg.length, 0)
            text_reg.text = mSpannableString_reg
            text_reg.setTextColor(R.color.red)
            text_auth.text = mString_auth
            text_auth.setTextColor(R.color.black)
            findNavController().navigate(R.id.action_profileFragment_to_regFragment)
        }

        val database =
            FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/")
        val table = database.getReference("User")

        btn_reg.setOnClickListener {
            if(editTextName.text.isEmpty()){
                editTextName.setHintTextColor(Color.RED)
            } else if(editTextPhone.text.isEmpty()){
                editTextPhone.setHintTextColor(Color.RED)
            } else if(editTextPass.text.isEmpty()){
                editTextPass.setHintTextColor(Color.RED)
            } else {
                table.addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.child(editTextPhone.text.toString()).exists()){
                            Toast.makeText(context, "Пользователь с таким номером телефона уже зарегистрирован", Toast.LENGTH_LONG).show()
                        } else {
                            val user = User(editTextName.text.toString(), editTextPass.text.toString())
                            table.child(editTextPhone.text.toString()).setValue(user)
                            editTextName.setText("")
                            editTextPhone.setText("")
                            editTextPass.setText("")
                            btn_reg.setText("Готово")
                            Toast.makeText(context, "Регистрация прошла успешно", Toast.LENGTH_LONG).show()

                            // Открывается страница профиля
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Проверьте интернет соединение", Toast.LENGTH_LONG)
                            .show()
                    }

                })
            }
        }



        return view
    }

}