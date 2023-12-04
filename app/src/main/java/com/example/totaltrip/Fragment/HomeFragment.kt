package com.example.totaltrip.Fragment

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.totaltrip.Activity.CategorieActivity
import com.example.totaltrip.Activity.VisitedActivity
import com.example.totaltrip.Adapter.AdapterClass
import com.example.totaltrip.ModelClass.StudentModelClass
import com.example.totaltrip.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text
import java.util.Locale


class HomeFragment : Fragment() {


    private var Binding: FragmentHomeBinding? = null
    private lateinit var auth: FirebaseAuth
    lateinit var firebaseDatabase: DatabaseReference
    private val binding get() = Binding
    var list = arrayListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding?.root
        var refrence = FirebaseDatabase.getInstance().reference
        var list = ArrayList<StudentModelClass>()

        firebaseDatabase = FirebaseDatabase.getInstance().getReference()
        auth = Firebase.auth


        refrence.root.child("AdminTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: StudentModelClass? = child.getValue(StudentModelClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = AdapterClass(this@HomeFragment, list, onItemclick = {

                        place: String, Rate: String, img: String, key: String ->

                    var i = Intent(context, VisitedActivity::class.java)
                    i.putExtra("place", place)
                    i.putExtra("Rate", Rate)
                    i.putExtra("img", img)
                    i.putExtra("key", key)
                    startActivity(i)
                })
                var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding?.rcv?.layoutManager = manager
                binding?.rcv?.adapter = adpter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        initview()


        return view
    }

    private fun initview() {

        Binding?.imgMountain?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Mountain")
            startActivity(i)
        }
        Binding?.imgBeach?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Beach")
            startActivity(i)
        }
        Binding?.imgLakes?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Lakes")
            startActivity(i)
        }
        Binding?.imgCamp?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Camp")
            startActivity(i)
        }


    }




}

