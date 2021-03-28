package com.megamott.rl2_legengs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.megamott.rl2_legengs.abstracts.view.fragments.UserListFragment

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        if (supportFragmentManager.findFragmentById(R.id.users_list_container) == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.users_list_container, UserListFragment())
                .commit()
        }
    }
}