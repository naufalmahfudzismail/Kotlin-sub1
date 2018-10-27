package com.example.naufa.kotlinproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailUI().setContentView(this)

        val img = intent.getIntExtra("IMAGE",0)
        val name = intent.getStringExtra("NAME")
        val detail = intent.getStringExtra("DETAIL")

        val nameDetail = find<TextView>(R.id.name_detail)
        val imgDetail = find<ImageView>(R.id.image_detail)
        val textDetail = find<TextView>(R.id.detail)

        nameDetail.text = name
        Glide.with(this).load(img).into(imgDetail)
        textDetail.text = detail

    }

    class DetailUI : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            relativeLayout {
                padding = dip(20)

                imageView {
                    id = R.id.image_detail
                }.lparams {
                    width = dip(120)
                    height = dip(120)
                    centerHorizontally()
                }

                textView {
                    textSize = sp(14).toFloat()
                    id = R.id.name_detail
                }.lparams {
                    centerHorizontally()
                    width = wrapContent
                    height = wrapContent
                    below(R.id.image_detail)
                }

                textView {
                    textSize = sp(12).toFloat()
                    id = R.id.detail
                }.lparams {
                    centerHorizontally()
                    width = wrapContent
                    height = wrapContent
                    below(R.id.name_detail)
                }
            }
        }
    }
}


