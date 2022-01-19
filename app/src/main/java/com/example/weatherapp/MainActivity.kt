package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapp.Model.Weather
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val apiKey = "11e7f34bb18820657a280840aaf0de9f"
    val gson= Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            getWeather()
            binding.searchInput.text.clear()
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
                        var result= gson.fromJson(response, Weather::class.java)
                        binding.temperature.text= result.main.temp.toInt().toString()+ " C"
                        binding.status.text= result.weather[0].main
                        binding.textView.text= result.name+ ", "+ result.sys.country
                        binding.maxANDmain.text= "Max "+ result.main.temp_max.toInt() + " c | Min " + result.main.temp_min.toInt() +" c"


                    },
                    {
                        Toast.makeText(this, "something went wrong!",Toast.LENGTH_LONG ).show()
                        println(it.message)
                        }
                )
                queue.add(stringRequest)
            }else{
                Toast.makeText(this, "Type something", Toast.LENGTH_LONG).show()
            }

        }catch (err:Exception){

        }
    }
}