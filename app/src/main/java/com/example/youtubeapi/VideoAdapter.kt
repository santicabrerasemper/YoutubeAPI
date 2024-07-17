package com.example.youtubeapi

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi.response.Item

class VideoAdapter(
    val context: Context,
    var videosList: List<Item>
) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cvVideo = itemView.findViewById(R.id.cv_video) as CardView
        val ivThumbnails = itemView.findViewById(R.id.img_thumb_nails) as ImageView
        val tvTitle = itemView.findViewById(R.id.tv_title) as TextView
        val tvDescription = itemView.findViewById(R.id.tv_description) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_video, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videosList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videosList[position]

        holder.cvVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v="+video.id.videoId)
            )
            context.startActivity(intent)
        }

        Glide
            .with(context)
            .load(video.snippet.thumbnails.high.url)
            .centerCrop()
            .into(holder.ivThumbnails)

        holder.tvTitle.text = video.snippet.title
        holder.tvDescription.text = video.snippet.description
    }
}