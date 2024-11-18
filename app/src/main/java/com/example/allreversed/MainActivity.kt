package com.example.allreversed

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.allreversed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.apply {
            transformButton.setOnClickListener {
                if (input.text.isBlank()) {
                    Toast.makeText(this@MainActivity, "Enter text please", Toast.LENGTH_LONG).show()
                } else {
                    result.text = getString(R.string.result_ready).format(input.text.reversed())
                    val count = input.text.toString().replace(" ", "").count()
                    symbolsCount.text = getString(R.string.symbols_count_ready).format(count)
                }
            }
        }
    }
}