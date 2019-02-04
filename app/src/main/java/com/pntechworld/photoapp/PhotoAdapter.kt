package com.pntechworld.photoapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pntechworld.photoapp.models.Photo

class PhotoAdapter(photos: List<Photo>?) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private var mPhotos: List<Photo>? = photos

    init {
        mPhotos = photos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mPhotos!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var photo: Photo = mPhotos?.get(position)!!

        if (photo.previewURL.isNotEmpty())
            Glide.with(holder.photo.context).load(photo.previewURL).into(holder.photo)

        holder.photo.setOnClickListener {
            val intent = Intent(holder.photo.context, DetailActivity::class.java).apply {
                putExtra("Intent", photo)
            }
            holder.photo.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.iv_photo)
    }
}
