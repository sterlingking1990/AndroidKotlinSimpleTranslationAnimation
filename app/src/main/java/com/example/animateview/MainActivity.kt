package com.example.animateview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterViewAnimator
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    private var starImg: ImageView =findViewById(R.id.imgStar)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRotate.setOnClickListener {
            translateStar()
        }
    }

    fun translateStar(){
        var animator=ObjectAnimator.ofFloat(imgStar,View.TRANSLATION_X,0f,400f)
        animator.repeatCount=1
        animator.duration=2000
        animator.addListener(object:AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator?) {
                animator=ObjectAnimator.ofFloat(imgStar,View.TRANSLATION_X,-400f,0f)
                animator.repeatCount=1
                animator.duration=2000
                animator.start()
            }
        })
        animator.start()
    }


}