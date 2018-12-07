package com.pntechworld.photoapp

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pntechworld.photoapp.models.Photo

class PhotoAdapter( photos: List<Photo>?) :
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
            Log.d("Image", position.toString())
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.iv_photo)
    }
}
