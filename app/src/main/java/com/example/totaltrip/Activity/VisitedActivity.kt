package com.example.totaltrip.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.totaltrip.R
import com.example.totaltrip.databinding.ActivityVisitedBinding

class VisitedActivity : AppCompatActivity() {
    lateinit var binding : ActivityVisitedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisitedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {

        if (intent != null) {


            var key = intent.getStringExtra("key").toString()
            var Location = intent.getStringExtra("Location").toString()
            var place = intent.getStringExtra("place").toString()
            var Rate = intent.getStringExtra("Rate").toString()
            var img = intent.getStringExtra("img").toString()

            binding.palce.text = place
            binding.txtLocation.text = Location
            binding.price.text = Rate

            Glide.with(baseContext).load(img).into(binding.img)


        }
    }
}