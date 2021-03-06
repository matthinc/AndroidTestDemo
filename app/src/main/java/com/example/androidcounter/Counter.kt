package com.example.androidcounter

class Counter(private var value: Int) {
    fun increment() {
        ++value
    }

    fun reset() {
        value = 0
    }

    val counterValue
        get() = value
}