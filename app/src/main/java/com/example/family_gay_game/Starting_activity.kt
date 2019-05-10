package com.example.family_gay_game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Starting_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting_activity)
    }
    fun launch(view: View){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }
}


