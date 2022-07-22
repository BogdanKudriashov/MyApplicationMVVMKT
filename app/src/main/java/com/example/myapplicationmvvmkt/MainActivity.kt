package com.example.myapplicationmvvmkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplicationmvvmkt.databinding.ActivityMainBinding
import com.example.myapplicationmvvmkt.model.User
import com.example.myapplicationmvvmkt.screens.UserDetailsFragment
import com.example.myapplicationmvvmkt.screens.UsersListFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, UsersListFragment()).commit()
        }
    }

    override fun showDetails(user: User) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, UserDetailsFragment.newInstance(user.id))
            .commit()
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun toast(messageRes: Int) {
        Toast.makeText(this, messageRes, Toast.LENGTH_SHORT).show()
    }
}