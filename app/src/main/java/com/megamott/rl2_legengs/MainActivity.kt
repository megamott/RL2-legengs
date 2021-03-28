package com.megamott.rl2_legengs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.megamott.rl2_legengs.abstracts.view.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.login_container) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.login_container, LoginFragment())
                .commit()
        }
    }
}