package com.anshu.wedin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anshu.wedin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.account.setOnClickListener {
           startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.signIn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}


