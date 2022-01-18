package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val apiKey = "11e7f34bb18820657a280840aaf0de9f"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            getWeather()
        }
    }

    private fun getWeather() {

        try {
            if(binding.searchInput.text.isNotEmpty()){
                var fullURL=
                    "http://api.openweathermap.org/data/2.5/weather?q=${binding.searchInput.text}&units=metric&appid=$apiKey"
                val queue= Volley.newRequestQueue(this)
                val stringRequest=StringRequest(
                    Request.Method.POST, fullURL, { response ->
                           println(response.toString())
                    }, {
                        println(it.message)
                        }
                )
                queue.add(stringRequest)
            }

        }catch (err:Exception){

        }
    }
}