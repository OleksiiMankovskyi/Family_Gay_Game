package com.example.family_gay_game


import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import android.preference.Preference
import android.preference.PreferenceManager
import android.support.v4.content.ContextCompat.startActivity
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    var imageArray = ArrayList<ImageView>()
    var handler: Handler = Handler()
    var runnable: Runnable = Runnable { }
    var score: Int = 0
    var secondImageArray = ArrayList<ImageView>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score = 0
        imageArray = arrayListOf(
            peterimageView,
            peterimageView1,
            peterimageView2,
            peterimageView3,
            peterimageView4,
            peterimageView5,
            peterimageView6,
            peterimageView7,
            peterimageView8

        )
        hideImage()
        secondImageArray = arrayListOf(
            megimageView,
            megimageView1,
            megimageView2,
            megimageView3,
            megimageView4,
            megimageView5,
            megimageView6,
            megimageView7,
            megimageView8
        )
        hideImage()

        object : CountDownTimer(36000, 1000) {
            override fun onFinish() {
                timeText.text = "Time is off"
                handler.removeCallbacks(runnable)
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE

                }
                for(image in secondImageArray){
                    image.visibility = View.INVISIBLE
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time " + millisUntilFinished / 1000
            }


        }.start()
    }

    fun hideImage() {
        runnable = object : Runnable {
            override fun run() {


                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                for (image in secondImageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random
                val index = random.nextInt(8 - 0)
                val megIndex = random.nextInt(  8-0)
                imageArray[index].visibility = View.VISIBLE
                secondImageArray[megIndex].visibility = View.VISIBLE
                handler.postDelayed(runnable, 700)


            }

        }
        handler.post(runnable)

    }

    fun Score(view: View) {

        resultText.text =  "Score is " + score
        score++

    }
    fun MissClick(view: View){
        resultText.text= "Score is " + score
        score--
    }

    fun restart(view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
    fun exit(view: View){
        val intent = Intent(applicationContext, Starting_activity::class.java)
        startActivity(intent)

    }
}
