package com.example.walmartstore2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAcountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acount)
        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            var firstName = findViewById<EditText>(R.id.firstNameText).text.toString()
            var lastName = findViewById<EditText>(R.id.lastNameText).text.toString()
            var username = findViewById<EditText>(R.id.emailAddressText).text.toString()
            var password = findViewById<EditText>(R.id.passwordText).text.toString()
            val user = User(firstName, lastName, username, password)
            var myIntent = Intent(this, MainActivity::class.java)
            myIntent.putExtra("user", user)
            setResult(Activity.RESULT_OK, myIntent)
            finish()

        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}


