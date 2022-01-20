package com.example.demoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.demoapp.databinding.ActivityListBinding
import com.example.demoapp.ui.adapter.ListDataAdapter
import com.example.demoapp.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    companion object {
        val EXTRA_LINK: String = "extra_link"
    }

    private val viewModel: ListViewModel by viewModels()
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObserver()

        intent.getStringExtra(EXTRA_LINK)?.let {
            viewModel.fetchApiResponse(it)
        }
    }

    private fun setObserver() {

        viewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    binding.progressBar.visibility = View.GONE

                    response.data?.Item?.filter { item ->
                        item.StationId != null
                    }?.let {
                        val adpter = ListDataAdapter(applicationContext, it)
                        binding.dataRecyclerView.setHasFixedSize(true)
                        binding.dataRecyclerView.adapter = adpter
                    }
                }

                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is NetworkResult.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("Error", "API Error: ${response.message}")
                    Toast.makeText(this@ListActivity, response.message, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }

    }

}