package com.example.utsppam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView

class OrderDetails : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    val EXTRA_TITLE = "com.example.android.twoactivities.extra.TITLE"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val name_final = findViewById<TextView>(R.id.order_name)
        val store_final = findViewById<TextView>(R.id.order_store)
        val title_final = findViewById<TextView>(R.id.title_final)

        val notifSucsess = findViewById<TextView>(R.id.letter_done)

        val intent = intent
        val name_navbar = intent.getStringExtra(EXTRA_MESSAGE)
        name_final.text = name_navbar

        val store = intent.getStringExtra(EXTRA_MESSAGE_STORE)
        store_final.text = store

        val title = intent.getStringExtra(EXTRA_TITLE)
        title_final.text = title

        notifSucsess.text = " Terima kasih $name_navbar sudah memesan \n" +
                "ditoko kami, pesanan $title \n" +
                "anda dikirim menggunakan Fast Delivery"
    }
}