package com.example.happybirthday

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import java.io.File

class greet : AppCompatActivity() {
    companion object {
        const val NAME_EXTRA = "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greet)
        val name = intent.getStringExtra(NAME_EXTRA)//NAME_EXTRA is the key of name input of mainactivity
        val greetUser=findViewById<TextView>(R.id.textt).setText("Happy Birthday\n$name!")
        val finalImage = findViewById<ConstraintLayout>(R.id.finalimage)
        val share = findViewById<Button>(R.id.share).setOnClickListener{
            val image: Bitmap = getBitmapFromView(finalImage)
            shareImageAndText(image)
        }
    }

    private fun shareImageAndText(image: Bitmap) {
        val uri: Uri = getImageToShared(image)
    }

    private fun getImageToShared(image: Bitmap): Uri {
        val imageFolder: File = File(cacheDir,"image")
        val uri: Uri? = null
        try {
            imageFolder.mkdirs()
        }catch (e: Exception ){

        }
        return uri!!
    }

    private fun getBitmapFromView(view: View): Bitmap {
        //define a bitmap with same height and width
        val returnedBitmap: Bitmap = Bitmap.createBitmap(view.width,view.height,Bitmap.Config.ARGB_8888)
        //make a canvas .bind a canvas to it
        val canvas:Canvas = Canvas(returnedBitmap)
        //get the background view of the layout
        val background: Drawable = view.background
        if(background != null){
            background.draw(canvas)
        }
        else{
            canvas.drawColor(Color.WHITE)
        }
        //draw view on canvas
        view.draw(canvas)
        return returnedBitmap
    }



}
