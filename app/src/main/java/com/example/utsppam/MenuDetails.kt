package com.example.utsppam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MenuDetails : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    val EXTRA_PRICE = "com.example.android.twoactivities.extra.PRICE"
    val EXTRA_TITLE = "com.example.android.twoactivities.extra.TITLE"
    val EXTRA_DETAIL2 = "com.example.android.twoactivities.extra.DETAIL2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_details)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        val viewPrice = findViewById<TextView>(R.id.price)
        val viewTitle = findViewById<TextView>(R.id.title_detail)
        val viewDetail2 = findViewById<TextView>(R.id.detail_view)
        val intent = intent
        val price = intent.getStringExtra(EXTRA_PRICE)
        viewPrice.text = price
        val title = intent.getStringExtra(EXTRA_TITLE)
        viewTitle.text = title
        val detail2 = intent.getStringExtra(EXTRA_DETAIL2)
        viewDetail2.text = detail2

        val name_navbar = intent.getStringExtra(EXTRA_MESSAGE)
        val store = intent.getStringExtra(EXTRA_MESSAGE_STORE)


//        if (store != null) {
//            Log.d("Haikal", store)
//        }



        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener({
            onBackPressed()
        })

        val orderButton = findViewById<Button>(R.id.order_button)
        orderButton.setOnClickListener({
            val intent = Intent(this, OrderDetails::class.java)
            intent.putExtra(EXTRA_MESSAGE, name_navbar)
            intent.putExtra(EXTRA_MESSAGE_STORE, store)
            intent.putExtra(EXTRA_TITLE, title)
            startActivity(intent)
        })



    }
}