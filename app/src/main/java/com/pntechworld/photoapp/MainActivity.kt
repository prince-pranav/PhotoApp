package com.pntechworld.photoapp

import RetrofitUtils
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.pntechworld.photoapp.models.Photo
import com.pntechworld.photoapp.models.PhotoList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getPhoto()
    }

    fun getPhoto() {

        RetrofitUtils.getApiService().getPhotos().enqueue(object : Callback<PhotoList> {

            override fun onResponse(call: Call<PhotoList>, response: Response<PhotoList>) {
                var photos = response.body()!!.hits

                if (photos!!.isNotEmpty())
                    recyclerView.adapter = PhotoAdapter(photos)
                else
                    Toast.makeText(recyclerView.context, "Something went wrong", Toast.LENGTH_LONG)
            }

            override fun onFailure(call: Call<PhotoList>, t: Throwable) {
                Toast.makeText(recyclerView.context, "Something went wrong", Toast.LENGTH_LONG)
            }
        }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}