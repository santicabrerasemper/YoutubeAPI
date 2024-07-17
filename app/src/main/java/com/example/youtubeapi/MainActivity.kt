package com.example.youtubeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpRecyclerView()
        viewModel.getVideos()
        viewModel.videosList.observe(this) {
            adapter.videosList = it
            adapter.notifyDataSetChanged()
        }

    }

    private fun setUpRecyclerView() {
        binding.rvVideos.layoutManager = LinearLayoutManager(this)
        adapter = VideoAdapter(this, arrayListOf())
        binding.rvVideos.adapter = adapter
    }
}