package com.example.walmartstore2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var users = ArrayList<User>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        users.add(User("Abdelaziz", "Aboukhame", "abdelazizaboukham@gmail.com", "aa@12"))
        users.add(User("Jhon", "Terry", "jhon@gmail.com", "jt@34"))
        users.add(User("David", "Villa", "david@gmail.com", "dv@56"))
        users.add(User("Leonel", "Messi", "leonel@gmail.com", "lm@78"))
        users.add(User("Abdelilah", "Khossan", "abdelilah@gmail.com", "ak@90"))
        val btn1 = findViewById<Button>(R.id.signIn)
        val btn2 = findViewById<Button>(R.id.account)
        btn1.setOnClickListener {
            val username = findViewById<EditText>(R.id.username).text.toString()
            val password = findViewById<EditText>(R.id.password).text.toString()
            if (isValidLogin(username, password)){
                var intent = Intent(this, ShoppingCategory::class.java)
                intent.putExtra("email", username)
                startActivity(intent)
            }else
                Toast.makeText(this, "username or password is not correct, please try again", Toast.LENGTH_LONG).show()
        }

        var resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
                if (result.resultCode == Activity.RESULT_OK){
                    val user = result.data!!.getSerializableExtra("user") as User
                    if (user != null)
                        users.add(user)
                }
        }
        btn2.setOnClickListener {
            var intent = Intent(this, CreateAcountActivity::class.java)
            resultContract.launch(intent)
        }

        val forgotPass = findViewById<TextView>(R.id.forgot)
        forgotPass.setOnClickListener {
            var username = findViewById<EditText>(R.id.username).text.toString()
            var password : String? = null
            var name : String? = null
            for (u : User in users){
                if (u.username.equals(username)) {
                    password = u.password
                    name = u.firstName
                    break
                }
            }
            if (password != null){
                val input = password
                val sendIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"))
                sendIntent.putExtra(Intent.EXTRA_EMAIL, username)
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "account password")
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi ${name}, here is your walmart account password: ${input}")
                startActivity(sendIntent)
            }else
                Toast.makeText(this, "username is not correct, please try again", Toast.LENGTH_LONG).show()
        }


    }



    fun isValidLogin(username: String, password: String): Boolean{
       for (u : User in users){
           if (u.username.equals(username) && u.password.equals(password))
               return true
       }
        return false
    }

}