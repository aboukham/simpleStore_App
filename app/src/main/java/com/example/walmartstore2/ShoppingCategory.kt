package com.example.walmartstore2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        var email = findViewById<TextView>(R.id.welcome)
        var intent = intent
        email.text = intent.getStringExtra("email")

    }
    fun click(view: View){
        when (view.id){
            R.id.clothingImage -> Toast.makeText(this, "You have chosen the clothing category", Toast.LENGTH_LONG).show()
            R.id.beautyImage -> Toast.makeText(this, "You have chosen the beauty category", Toast.LENGTH_LONG).show()
            R.id.electronicImage -> Toast.makeText(this, "You have chosen the electronic category", Toast.LENGTH_LONG).show()
            R.id.foodImage -> Toast.makeText(this, "You have chosen the food category", Toast.LENGTH_LONG).show()
        }
    }
}