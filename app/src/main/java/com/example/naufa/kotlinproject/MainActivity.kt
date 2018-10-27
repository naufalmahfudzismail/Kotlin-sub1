package com.example.naufa.kotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor


class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiate()
        rcy_club.layoutManager = GridLayoutManager(this, 2);
        rcy_club.adapter  = RecycleClubAdapter(this, items) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()

            /*val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("NAME", it.name )
            intent.putExtra("Image", it.image)
            startActivity(intent)*/
            startActivity(intentFor<DetailActivity>(
                    "NAME" to it.name, "IMAGE" to it.image, "DETAIL" to it.detail))
        }

    }

    private fun initiate(){

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)
        items.clear()
        for (i in name.indices)
        {
            items.add(Item(name[i], image.getResourceId(i, 0), detail[i]))
        }

        image.recycle()
    }
}
