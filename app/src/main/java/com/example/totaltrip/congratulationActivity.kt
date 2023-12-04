package com.example.totaltrip

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.totaltrip.Activity.DashBoardActivity
import com.example.totaltrip.databinding.ActivityCongratulationBinding

class congratulationActivity : AppCompatActivity() {

    lateinit var binding: ActivityCongratulationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnCongratulation.setOnClickListener {

            var intent = Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
        }

    }
}