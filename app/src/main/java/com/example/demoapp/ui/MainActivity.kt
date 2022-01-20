package com.example.demoapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.demoapp.databinding.ActivityMainBinding
import com.example.demoapp.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.linkEditText.setText("http://phorus.vtuner.com/setupapp/phorus/asp/browsexml/navXML.asp?gofile=LocationLevelFourCityUS-North%20America-New%20York-ExtraDir-1-Inner-14&bkLvl=9237&mac=a8f58cd9758b710c43a7a63762e755947f83f0ad9194aa294bbaee55e0509e02&dlang=eng&fver=1.4.4.2299%20(20150604)&hw=CAP:%201.4.0.075%20MCU:%201.032%20BT:%200.002")

        binding.submitButton.setOnClickListener {
            val link = binding.linkEditText.text.toString().trim()
            when {
                link.isEmpty() -> binding.linkEditText.error = "Please enter link"
                !link.startsWith("http") -> binding.linkEditText.error = "Please enter valid link"
                else -> {
                    val intent = Intent(this, ListActivity::class.java)
                    intent.putExtra(ListActivity.EXTRA_LINK, link)
                    startActivity(intent)
                }
            }
        }
    }

}