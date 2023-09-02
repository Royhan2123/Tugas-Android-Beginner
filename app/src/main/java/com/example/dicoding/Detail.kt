package com.example.dicoding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.dicoding.databinding.ActivityDetailBinding

class Detail : AppCompatActivity(){
    private lateinit var binding: ActivityDetailBinding
    private lateinit var imgBackDetail: ImageView

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DATA, Novel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if (data != null) {
            val dataName = data.name
            val dataDesc = data.description
            val dataImg = data.photo


            binding.txtName.text = dataName
            binding.txtDesc.text = dataDesc
            binding.imgView.setImageResource(dataImg)

        }

    }
}