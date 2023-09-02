package com.example.dicoding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvHeroes: RecyclerView
    private lateinit var imgCircle:ImageView
    private val list = ArrayList<Novel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgCircle = findViewById(R.id.imgCircle)
        rvHeroes = findViewById(R.id.recyclerView)
        rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()

        imgCircle.setOnClickListener(this)
    }

    private fun getListHeroes(): ArrayList<Novel> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Novel>()
        for (i in dataName.indices) {
            val hero = Novel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        dataPhoto.recycle()
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Novel) {
                val moveWithObjectIntent = Intent(this@MainActivity, Detail::class.java)
                moveWithObjectIntent.putExtra(Detail.EXTRA_DATA, data)
                startActivity(moveWithObjectIntent)
            }
        })
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.imgCircle -> {
                val Intent = Intent(this@MainActivity,About::class.java)
                startActivity(Intent)
            }
        }
    }
}
