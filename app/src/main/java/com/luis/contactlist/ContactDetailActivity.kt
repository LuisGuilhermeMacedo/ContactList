package com.luis.contactlist

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)

        val imageRecover = findViewById<ImageView>(R.id.image)
        val nameRecover = findViewById<TextView>(R.id.name)
        val phoneRecover = findViewById<TextView>(R.id.phone)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val icon = intent.getIntExtra("icon", R.drawable.sample1)

        nameRecover.text = name
        phoneRecover.text = phone
        imageRecover.setImageResource(icon)

    }
}