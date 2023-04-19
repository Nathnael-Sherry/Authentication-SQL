package com.example.authenticationsql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var email_login:EditText
    lateinit var password_login:EditText
    lateinit var login_button:Button
    lateinit var register_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.edtmail)
        password_login = findViewById(R.id.edtpasscode)
        login_button = findViewById(R.id.btn_login)
        register_button = findViewById(R.id.btn_register)



        login_button.setOnClickListener {
            var mailog = email_login.text.toString()
            var passlog = password_login.text.toString()

            if (mailog.isEmpty() or passlog.isEmpty()) {

                Toast.makeText(this, "CANNOT SUBMIT EMPTY FIELDS", Toast.LENGTH_SHORT).show()
            }else{

            }

        }

        register_button.setOnClickListener {
            var gotoaccreationpage = Intent(this, MainActivity::class.java)
            startActivity(gotoaccreationpage)
        }


    }
}