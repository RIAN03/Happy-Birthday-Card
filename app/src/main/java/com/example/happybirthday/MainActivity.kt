package com.example.happybirthday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.happybirthday.greet.Companion.NAME_EXTRA

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    fun createBirthdayCard(view: View) {

        //       val name =nameInput.editableText.toString()
        //       Toast.makeText(this,"Name is ",Toast.LENGTH_LONG).show()
        val name= findViewById<TextView>(R.id.nameInput).editableText.toString()
        Toast.makeText(this,"Name is $name ", Toast.LENGTH_LONG).show()
        val intent= Intent(this, greet::class.java)
        intent.putExtra(greet.NAME_EXTRA,name )
        startActivity(intent)
    }
}