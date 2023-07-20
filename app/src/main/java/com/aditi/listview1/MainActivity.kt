package com.aditi.listview1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Saumya", "Aditi", "Ankit", "Pradeep", "Shivam")

        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "Great")

        val lastMsgTime = arrayOf("5:35 AM", "8:30 PM", "7:00 PM", "6:3 PM", "9:30 AM")

        val phoneNumber = arrayOf("9787766729", "8788749663", "7298778897", "7876623729", "9667937376")

        val imgId = intArrayOf(R.drawable.pic5, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic1)

        userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            // open a new activity

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this, UserActivity::class.java)

            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }


    }
}