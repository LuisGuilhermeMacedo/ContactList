package com.luis.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val iconList = findViewById<ImageView>(R.id.icon_list)
        val iconGrid = findViewById<ImageView>(R.id.icon_grid)
        iconList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        iconGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)

        }

        val adapter = ContactListAdapter()
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }

    }

}

val contacts = listOf(
    Contact("Luis", "(34) 99903-8891", R.drawable.sample1),
    Contact("Carlos", "(21) 91234-5678", R.drawable.sample2),
    Contact("Ana", "(11) 92345-6789", R.drawable.sample3),
    Contact("Mariana", "(31) 93456-7890", R.drawable.sample4),
    Contact("Pedro", "(41) 94567-8901", R.drawable.sample5),
    Contact("Beatriz", "(51) 95678-9012", R.drawable.sample6),
    Contact("João", "(71) 96789-0123", R.drawable.sample7),
    Contact("Camila", "(81) 97890-1234", R.drawable.sample8),
    Contact("Roberto", "(91) 98901-2345", R.drawable.sample9),
    Contact("Fernanda", "(61) 99012-3456", R.drawable.sample10),
    Contact("Marcelo", "(27) 99123-4567", R.drawable.sample11),
    Contact("Gabriela", "(67) 99234-5678", R.drawable.sample12),
    Contact("Thiago", "(83) 99345-6789", R.drawable.sample13),
    Contact("Larissa", "(84) 99456-7890", R.drawable.sample14),
    Contact("Felipe", "(85) 99567-8901", R.drawable.sample15),
    Contact("Lucas", "(86) 99678-9012", R.drawable.sample16)

)