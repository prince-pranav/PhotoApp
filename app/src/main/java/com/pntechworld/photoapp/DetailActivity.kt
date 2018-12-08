package com.pntechworld.photoapp

import android.media.Image
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.pntechworld.photoapp.models.Photo

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        var imageView = findViewById<ImageView>(R.id.iv_photo)
        var tvTags = findViewById<TextView>(R.id.tv_tags)
        var tvLikes = findViewById<TextView>(R.id.tv_likes)
        var tvFavs = findViewById<TextView>(R.id.tv_fav)

        var photo: Photo = intent.getSerializableExtra("Intent") as Photo

        Glide.with(imageView.context).load(photo.webformatURL).into(imageView)
        tvTags.text = "Tags : " + photo.tags
        tvLikes.text = "Total likes : " + photo.likes
        tvFavs.text = "Total Favourites : " + photo.favorites
    }
}
