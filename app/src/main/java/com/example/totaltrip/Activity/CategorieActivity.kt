package com.example.totaltrip.Activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.totaltrip.Adapter.CategorieAdapter
import com.example.totaltrip.ModelClass.MountainModalClass
import com.example.totaltrip.R
import com.example.totaltrip.databinding.ActivityCategorieBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CategorieActivity : AppCompatActivity() {

    lateinit var binding:ActivityCategorieBinding
    var reference = FirebaseDatabase.getInstance().reference
    var list = ArrayList<MountainModalClass>()
    lateinit var placeName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCategorieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.Button)
        }


        initview()
    }

    private fun initview() {

        if (intent!=null)
        {
            placeName=intent.getStringExtra("category").toString()
            binding.txtTitle.text = placeName

            if (placeName=="Mountain")
            {
                MountainCall()
            }
            else if (placeName=="Beach")
            {
                BeachCall()
            }
            if (placeName=="Lakes")
            {
                LakesCall()
            }
            if (placeName=="Camp")
            {
                CampCall()
            }
        }

    }

    private fun CampCall() {
        reference.root.child("CampTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModalClass? = child.getValue(MountainModalClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategorieActivity,list, onItemClick = {
                        place:String, Location:String, Price:String, Rate:String, img:String, key:String ->

                    var i=Intent(this@CategorieActivity,CategoryDisplayActivity::class.java)

                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",img)
                    i.putExtra("key",key)
                    startActivity(i)


                } )
                var manager = LinearLayoutManager(this@CategorieActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun LakesCall() {
        reference.root.child("LakesTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModalClass? = child.getValue(MountainModalClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategorieActivity,list, onItemClick = {
                        place:String, Location:String, Price:String, Rate:String, img:String, key:String ->

                    var i=Intent(this@CategorieActivity,CategoryDisplayActivity::class.java)

                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",img)
                    i.putExtra("key",key)
                    startActivity(i)



                } )
                var manager = LinearLayoutManager(this@CategorieActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun BeachCall() {
        reference.root.child("BeachTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModalClass? = child.getValue(MountainModalClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategorieActivity,list, onItemClick = {
                        place:String, Location:String, Price:String, Rate:String, img:String, key:String ->

                    var i=Intent(this@CategorieActivity,CategoryDisplayActivity::class.java)

                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",img)
                    i.putExtra("key",key)
                    startActivity(i)



                } )
                var manager = LinearLayoutManager(this@CategorieActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun MountainCall() {
        reference.root.child("MountainTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: MountainModalClass? = child.getValue(MountainModalClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = CategorieAdapter(this@CategorieActivity,list, onItemClick = {
                        place:String, Location:String, Price:String, Rate:String, img:String, key:String ->

                    var i=Intent(this@CategorieActivity,CategoryDisplayActivity::class.java)

                    i.putExtra("place",place)
                    i.putExtra("Location",Location)
                    i.putExtra("Price",Price)
                    i.putExtra("Rate",Rate)
                    i.putExtra("img",img)
                    i.putExtra("key",key)
                    startActivity(i)

                } )
                var manager = LinearLayoutManager(this@CategorieActivity, LinearLayoutManager.VERTICAL,false)
                binding?.rcvCategorie?.layoutManager =manager
                binding.rcvCategorie.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}