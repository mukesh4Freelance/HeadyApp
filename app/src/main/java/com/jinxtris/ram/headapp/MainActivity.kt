package com.jinxtris.ram.headapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jinxtris.ram.headapp.model.Root
import com.jinxtris.ram.headapp.retrofit.APIService
import com.jinxtris.ram.headapp.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callService()
    }

    private fun callService() {
        val service = RetrofitClient.retroInstance?.create(APIService::class.java)
        val call = service?.categoryData()

        call?.enqueue(object : Callback<Root> {
            override fun onFailure(call: Call<Root>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                val body = response?.body()
                val information = body?.categories
                val ranking = body?.rankings
                Toast.makeText(
                    applicationContext,
                    "Category Size: ${information?.size} \n Ranking Size : ${ranking?.size}",
                    Toast.LENGTH_LONG
                ).show()

            }

        })
    }
}
