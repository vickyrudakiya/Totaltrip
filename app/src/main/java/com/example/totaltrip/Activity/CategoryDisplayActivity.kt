package com.example.totaltrip.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.totaltrip.databinding.ActivityCategoryDisplayBinding

class CategoryDisplayActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoryDisplayBinding
    lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initview()
    }

    private fun initview() {
        if (intent != null) {

            var place = intent.getStringExtra("place").toString()
            var Location = intent.getStringExtra("Location").toString()
//            var Price = intent.getStringExtra("price").toString()
            var Rate = intent.getStringExtra("Rate").toString()
            var img = intent.getStringExtra("img").toString()
            var Book_beach = intent.getStringExtra("Book_beach").toString()
            var key = intent.getStringExtra("key").toString()


            binding.txtplace.text = place
            binding.txtLocation.text = Location
//            binding.txtPrice.text = Price
            binding.txtRate.text = Rate

            Glide.with(baseContext).load(img).into(binding.imgBeach)


        }
    }
}