package com.example.utsppam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MenuStore : AppCompatActivity() {

    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_MESSAGE_STORE = "com.example.android.twoactivities.extra.MESSAGE2"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    val EXTRA_PRICE = "com.example.android.twoactivities.extra.PRICE"
    val EXTRA_TITLE = "com.example.android.twoactivities.extra.TITLE"
    val EXTRA_DETAIL2 = "com.example.android.twoactivities.extra.DETAIL2"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_store)

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)


        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textname)
        textView.text = message

        val message2 = intent.getStringExtra(EXTRA_MESSAGE_STORE)

//        if (message != null) {
//            Log.d("rv", message)
//        }

        val image = listOf(
            R.drawable.imgfood,
            R.drawable.imgfood2,
            R.drawable.imgfood3,
            R.drawable.imgfood4
        )

        val title = listOf(
            "Pepperoni Pizza",
            "Spagheti",
            "Burger",
            "Steak"
        )
        val detail = listOf(
            "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat",
            "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental",
            "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal",
            "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat"
        )

        val price = listOf(
            "Rp. 90.000,-",
            "Rp. 50.000,-",
            "Rp. 30.000,-",
            "Rp. 150.000,-"
        )

        val detail2 = listOf(
            "Pepperoni pizza adalah pizza yang memiliki  topping daging pepperoni sapi asli. Di Italia, pepperoni disebut salame piccante (salami panas). Biasa menjadi bahan baku pizza di Amerika Serikat, yang sering mewakili 30% pelengkap. Pizza ini cocok untuk santap siang ataupun malam anda",
            "Spaghetti adalah hidangan pasta yang terdiri dari pasta panjang dan tipis yang dimasak hingga al dente dan disajikan dengan berbagai jenis saus, seperti saus tomat, carbonara, atau pesto. Biasanya dihiasi dengan keju parmesan dan saus tambahan sesuai selera.",
            " Burger adalah makanan yang terdiri dari patty daging (seringkali sapi) yang dibumbui dan dipanggang atau digoreng, kemudian ditempatkan di dalam roti burger. Patty ini sering disajikan dengan berbagai topping seperti keju, sayuran, saus, dan bahan tambahan lainnya.",
            "Steak adalah potongan daging tebal yang umumnya berasal dari sapi dan dimasak dengan cara dipanggang atau digoreng. Steak sering disajikan dengan garam dan merica, dan biasanya dimasak hingga tingkat kematangan yang diinginkan, seperti rare, medium rare, medium, medium well, atau well-done."
        )

        val recyclerView =findViewById<RecyclerView>(R.id.recycleview)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val data = ArrayList<ItemsViewModel>()

        val loopLimit = minOf(image.size, title.size, detail.size,price.size)

        for (i in 0 until loopLimit){
            data.add(ItemsViewModel(image[i], title[i], detail[i], price[i], detail2[i]))
        }

        val adapter = CustomAdapter(data)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener { position ->
            val clickItem = data[position]
//            Log.d("Hilmi ganteng",clickItem.price_menu)
            val intent = Intent(this,MenuDetails::class.java)
            intent.putExtra(EXTRA_PRICE,clickItem.price_menu)
            intent.putExtra(EXTRA_TITLE,clickItem.title_menu)
            intent.putExtra(EXTRA_DETAIL2,clickItem.detail2_menu)
            intent.putExtra(EXTRA_MESSAGE, message)
            intent.putExtra(EXTRA_MESSAGE_STORE, message2)
            startActivity(intent)

        }






    }
}