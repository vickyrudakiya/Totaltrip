package com.example.totaltrip.Activity

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.totaltrip.ModelClass.MountainModalClass
import com.example.totaltrip.databinding.ActivityBeachBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class BeachActivity : AppCompatActivity() {

    lateinit var binding: ActivityBeachBinding
    private val PICK_IMAGE_REQUEST = 100
    lateinit var uri: Uri
    lateinit var ImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBeachBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initview()
    }

    private fun initview() {
        var reference = FirebaseDatabase.getInstance().reference

        binding.btnselectimag.setOnClickListener {


            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(
                    intent,
                    "Select Image from here..."
                ),
                PICK_IMAGE_REQUEST
            )

            binding.BtnAdd.setOnClickListener {
                var palce = binding.edtPlaceName.text.toString()
                var Location = binding.edtLocation.text.toString()
                var Price = binding.edtprice.text.toString()
                var Rate = binding.edtRate.text.toString()
                var description = binding.edtdescription.text.toString()



                var key = reference.root.child("BeachTb").push().key ?: ""

                var modelClass = MountainModalClass(
                    palce,
                    Location,
                    Price,
                    Rate,
                    description,
                    key, ImageUri
                )

                reference.root.child("BeachTb").child(key).setValue(modelClass)
                    .addOnCompleteListener {

                        if (it.isSuccessful) {
                            Toast.makeText(this, "Data Added Successful", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener { Log.e("TAG", "Error: " + it) }

            }


        }
    }
    fun uploadImage() {
        if (uri != null) {

            // Code for showing progressDialog while uploading
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            // Defining the child of storageReference
            val ref: StorageReference = FirebaseStorage.getInstance().getReference()
                .child("images/" + UUID.randomUUID().toString())

            // adding listeners on upload
            // or failure of image
            if (ref != null) {
                ref.putFile(uri).continueWith {

                    ref.downloadUrl.addOnCompleteListener {
                        ImageUri = it.result
                    }


                }

                    .addOnSuccessListener { // Image uploaded successfully
                        // Dismiss dialog
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@BeachActivity,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .addOnFailureListener { e -> // Error, Image not uploaded
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@BeachActivity,
                                "Failed " + e.message,
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }

            }
        }
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )


        if (requestCode == PICK_IMAGE_REQUEST && resultCode == AppCompatActivity.RESULT_OK && data != null && data.data != null) {

            // Get the Uri of data
            uri = data.data!!
            uploadImage()

        }
    }


}