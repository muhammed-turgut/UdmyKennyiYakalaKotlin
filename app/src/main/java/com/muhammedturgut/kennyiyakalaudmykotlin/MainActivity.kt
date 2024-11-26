package com.muhammedturgut.kennyiyakalaudmykotlin

import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muhammedturgut.kennyiyakalaudmykotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.Runnable
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var score=0
    var imageArray=ArrayList<ImageView>()
    var ruunable= Runnable {  }
    var handler=Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ImageArray
        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)



        hideImages()

        //CountDownTimer

        object : CountDownTimer(15000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timeText.text = "Time:  ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.timeText.text = "Time: 0"
                handler.removeCallbacks(ruunable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage("Restrat The Game")
                    .setTitle("Game Over")
                    .setPositiveButton("Yes") { dialog, which ->
                        val intentFromMain = intent
                        finish()
                        startActivity(intentFromMain)
                    }

                    .setNegativeButton("Nocd _" +
                            ", ce") { dialog, which ->
                        Toast.makeText(this@MainActivity, "Game Over", Toast.LENGTH_SHORT).show()

                    }
                val dialog: AlertDialog = builder.create()
                dialog.show()

            }
        }.start()
    }

    fun hideImages(){
        ruunable=object:Runnable {
            override fun run() {

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                val randomindex = Random.nextInt(0, 9)
                imageArray[randomindex].visibility = View.VISIBLE

                handler.postDelayed(ruunable,500)
            }
        }
        handler.post(ruunable)
    }

    fun increaseScore(view: View){
        score=score+1
        binding.ScoreText.text="Score: ${score}"
    }

}
