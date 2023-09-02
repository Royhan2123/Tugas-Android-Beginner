package com.example.dicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class About : AppCompatActivity(), View.OnClickListener {
    private  lateinit var imgBack:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        imgBack = findViewById(R.id.imgBack)

        imgBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.imgBack -> {
                val intent = Intent(this@About,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}