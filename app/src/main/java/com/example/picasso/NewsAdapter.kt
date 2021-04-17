package com.example.retrofit

import android.content.Context
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.picasso.NewsModel
import com.example.picasso.PictureModel
import com.example.picasso.R
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class NewsAdapter(val context: Context, val data: List<NewsModel.Articles>): RecyclerView.Adapter<NewsAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_row, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.CustomViewHolder, position: Int) {
        val currentItem = data[position]

        holder.description.text = currentItem.description
        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.urlToImage).into(holder.img)

        holder.container.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data[position]?.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        var description: TextView
        var title: TextView
        var img: ImageView
        var container: ConstraintLayout

        init {
            description = view.findViewById(R.id.description)
            title = view.findViewById(R.id.title)
            img = view.findViewById(R.id.img)
            container = view.findViewById(R.id.container)
        }
    }
}