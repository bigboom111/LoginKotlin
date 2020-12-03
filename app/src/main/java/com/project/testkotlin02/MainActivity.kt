package com.project.testkotlin02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var mAuth : FirebaseAuth
    lateinit var mLogoutBtn : Button

    /*lateinit var editText: EditText
    lateinit var ratingBar: RatingBar
    lateinit var buttonSave: Button*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        mLogoutBtn = findViewById(R.id.MainLogoutBtn)

        /*editText = findViewById(R.id.editTextTextPersonName3)
        ratingBar = findViewById(R.id.ratingBar2)
        buttonSave = findViewById(R.id.btn_Save)

        buttonSave.setOnClickListener{
            saveHero()
        }*/

        mLogoutBtn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val startIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(startIntent)
            finish()

        }
    }

    /*private fun saveHero(){
        val name = editText.text.toString().trim()

        if (name.isEmpty()){
            editText.error="Please enter Name"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("heroes")
        val heroId = ref.push().key
        val hero = Hero(heroId.toString(), name , ratingBar.numStars)

        ref.child(heroId.toString()).setValue(hero).addOnCompleteListener{
            Toast.makeText(applicationContext,"Hero saved successfully" , Toast.LENGTH_LONG).toString()
        }
    }*/

    override fun onStart() {
        super.onStart()

        val currentUser = FirebaseAuth.getInstance().currentUser
        if(currentUser == null){

            val intent = Intent(applicationContext , LoginActivity::class.java)
            startActivity(intent)
            finish()

        }else{
            Toast.makeText(applicationContext , "Login Successfully " , Toast.LENGTH_SHORT).show()
        }
    }
}