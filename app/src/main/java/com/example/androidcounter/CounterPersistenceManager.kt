package com.example.androidcounter

import android.content.Context
import android.content.SharedPreferences

class CounterPersistenceManager(private val context: Context) {

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences("counter", Context.MODE_PRIVATE)
    }

    fun persistContent(counter: Counter) {
        preferences.edit().putInt(COUNTER_KEY, counter.counterValue).apply()
    }

    fun loadCounter(): Counter {
        return Counter(preferences.getInt(COUNTER_KEY, 0))
    }

    companion object {
        private const val COUNTER_KEY = "counter_value"
    }

}