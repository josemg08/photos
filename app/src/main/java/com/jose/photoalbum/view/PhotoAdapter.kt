package com.jose.photoalbum.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jose.photoalbum.R
import com.jose.photoalbum.model.PhotoModel

class PhotoAdapter(private val userList: List<PhotoModel>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.photo_item_adapter, viewGroup, false)
        context = viewGroup.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = userList[position].title

        Glide
            .with(context)
            .load(userList[position].url)
            .into(viewHolder.photo)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)!!
        val photo = itemView.findViewById<ImageView>(R.id.photo)!!
    }
}