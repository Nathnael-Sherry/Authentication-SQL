package com.example.authenticationsql

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
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
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.edtmail)
        password_login = findViewById(R.id.edtpasscode)
        login_button = findViewById(R.id.btn_login)
        register_button = findViewById(R.id.btn_register)

        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null)



        login_button.setOnClickListener {
            var mailog = email_login.text.toString().trim()
            var passlog = password_login.text.toString().trim()

            //Validate fields
            if (mailog.isEmpty() or passlog.isEmpty()) {

                Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show()
            }else{
                val cursor = db.rawQuery("SELECT * FROM users WHERE email=? AND passcode=?", arrayOf(mailog, passlog))

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }

            }

        }

        register_button.setOnClickListener {
            var gotoaccreationpage = Intent(this, MainActivity::class.java)
            startActivity(gotoaccreationpage)
        }
    }
}