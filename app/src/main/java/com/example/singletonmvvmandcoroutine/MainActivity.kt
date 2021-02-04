package com.example.singletonmvvmandcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("DEBUG: ${ExampleSingleton.singletonUser}")

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(this, Observer { user ->
            println("DEBUG: $user")
            var myText: TextView = findViewById(R.id.myTextView);
            myText.setText(user.toString())
        })

        viewModel.setUserId("1")


    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.canellJob()
    }
}