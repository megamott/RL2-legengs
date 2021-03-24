package com.megamott.rl2_legengs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.megamott.rl2_legengs.abstracts.view.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.question_container, LoginFragment())
            .addToBackStack(null)
            .commit()
    }
}