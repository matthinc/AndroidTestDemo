package com.example.androidcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val counterPersistenceManager by lazy {
        CounterPersistenceManager(this)
    }

    private val counter by lazy {
        counterPersistenceManager.loadCounter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.increment_button).setOnClickListener {
            counter.increment()
            updateCounter()
        }

        findViewById<Button>(R.id.reset_button).setOnClickListener {
            counter.reset()
            updateCounter()
        }

        updateCounter()
    }

    private fun updateCounter() {
        findViewById<TextView>(R.id.counter_value).text = "${counter.counterValue}"
        counterPersistenceManager.persistContent(counter)
    }
}