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
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rezeda.usadbamyasnika.models.User
import org.w3c.dom.Text

class ProfileFragment : Fragment() {

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val text_auth = view.findViewById<TextView>(R.id.text_auth)
        val text_reg = view.findViewById<TextView>(R.id.text_reg)
        val editTextPhone = view.findViewById<EditText>(R.id.editTextPhone)
        val editTextPass = view.findViewById<EditText>(R.id.editTextPass)
        val btn_auth = view.findViewById<Button>(R.id.btn_auth)

        var mString_auth = "Авторизация"
        var mString_reg = "Регистрация"
        var mSpannableString_auth = SpannableString(mString_auth)
        var mSpannableString_reg = SpannableString(mString_auth)
        mSpannableString_auth.setSpan(UnderlineSpan(), 0, mSpannableString_auth.length, 0)
        text_auth.text = mSpannableString_auth
        text_reg.setOnClickListener {
            mSpannableString_reg = SpannableString(mString_reg)
            mSpannableString_reg.setSpan(UnderlineSpan(), 0, mSpannableString_reg.length, 0)
            text_reg.text = mSpannableString_reg
            text_reg.setTextColor(R.color.red)
            text_auth.text = mString_auth
            text_auth.setTextColor(R.color.black)
            findNavController().navigate(R.id.action_profileFragment_to_regFragment)
        }
        text_auth.setOnClickListener {
            mSpannableString_auth = SpannableString(mString_auth)
            mSpannableString_auth.setSpan(UnderlineSpan(), 0, mSpannableString_auth.length, 0)
            text_auth.text = mSpannableString_auth
            text_auth.setTextColor(R.color.red)
            text_reg.text = mString_reg
            text_reg.setTextColor(R.color.black)
            findNavController().navigate(R.id.action_regFragment_to_profileFragment)
        }

        val database =
            FirebaseDatabase.getInstance("https://usadbamyasnika-default-rtdb.europe-west1.firebasedatabase.app/")
        val table = database.getReference("User")

        btn_auth.setOnClickListener {
            if (editTextPhone.text.isEmpty()) {
                editTextPhone.setHintTextColor(Color.RED)
            } else if (editTextPass.text.isEmpty()) {
                editTextPass.setHintTextColor(Color.RED)
            } else {
                table.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {

                        if (snapshot.child(editTextPhone.text.toString()).exists()) {
                            val user: User? = snapshot.child(editTextPhone.text.toString())
                                .getValue(User::class.java)
                            if (editTextPass.text.toString().equals(user?.user_pass)) {
                                findNavController().navigate(R.id.action_profileFragment_to_authProfileFragment)
                                Toast.makeText(context, "Авторизован", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(context, "Пароль не верный", Toast.LENGTH_LONG)
                                    .show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Такой пользователь не зарегистрирован. Перейдите на страницу регистрации",
                                Toast.LENGTH_LONG
                            ).show()
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

