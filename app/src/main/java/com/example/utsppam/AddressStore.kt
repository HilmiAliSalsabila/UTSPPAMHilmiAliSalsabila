package com.example.utsppam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class AddressStore : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_address_store)

        val intent2 = intent
        val message2 = intent2.getStringExtra(EXTRA_MESSAGE_STORE)
        val textView2 = findViewById<TextView>(R.id.store)
        textView2.text = message2
//        if (message2 != null) {
//            Log.d("test string", message2)
//        }

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.tv_name)
        textView.text = message
//        if (message != null) {
//            Log.d("test name", message)
//        }

        val seeMenuButton=findViewById<Button>(R.id.seeMenuButton)
        seeMenuButton.setOnClickListener({
            val intent = Intent(this, MenuStore::class.java)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            startActivity(intent)
        })
    }
}