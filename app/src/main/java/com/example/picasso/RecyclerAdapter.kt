package com.example.retrofit

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.picasso.PictureModel
import com.example.picasso.R
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class RecyclerAdapter(val context: Context, val data: List<PictureModel>): RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = data[position]

        holder.id.text = currentItem.id.toString()
        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.url).into(holder.img)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        var id: TextView
        var title: TextView
        var img: ImageView

        init {
            id = view.findViewById(R.id.id)
            title = view.findViewById(R.id.title)
            img = view.findViewById(R.id.img)
        }
    }
}