package com.example.authenticationsql

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var first_name:EditText
    lateinit var second_name:EditText
    lateinit var edt_email:EditText
    lateinit var edt_password:EditText
    lateinit var account_button:Button
    lateinit var login_button:Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        first_name = findViewById(R.id.edtname1)
        second_name = findViewById(R.id.edtname2)
        edt_email = findViewById(R.id.edtemail)
        edt_password = findViewById(R.id.edtpassword)
        account_button = findViewById(R.id.btnaccount)
        login_button = findViewById(R.id.btnlogin)

        db = openOrCreateDatabase("usersDB", Context.MODE_PRIVATE, null)

//        creating a table
        db.execSQL("CREATE TABLE IF NOT  EXISTS users(name1 VARCHAR, name2 VARCHAR, email VARCHAR, passcode VARCHAR)")

        account_button.setOnClickListener {
            //Receive data from the user
            var jina1 = first_name.text.toString()
            var jina2 = second_name.text.toString()
            var arafa = edt_email.text.toString()
            var pin = edt_password.text.toString()

            //Check if the user is trying to submit empty records
            if (jina1.isEmpty() or jina2.isEmpty() or arafa.isEmpty() or pin.isEmpty()){
                //Use the display_message() to Display a message telling the user to fill all the inputs

                //toast a message to say cannot submit empty field
                Toast.makeText(this, "CANNOT SUBMIT EMPTY FIELDS", Toast.LENGTH_SHORT).show()


            }else{
                //Proceed to save your data into the db
                db.execSQL("INSERT INTO users VALUES('"+jina1+"', '"+jina2+"', '"+arafa+"', '"+pin+"')")


                //Toast a success message
                Toast.makeText(this, "USER CREATED SUCCESSFULLY ", Toast.LENGTH_SHORT).show()

                var gotologin = Intent(this, LoginActivity::class.java)
                startActivity(gotologin)

            }


        }

    }
}