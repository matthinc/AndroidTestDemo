package com.example.androidcounter

import org.junit.Assert
import org.junit.Test

class CounterTest {

    @Test
    fun testNewCounter() {
        val counter = Counter(0)
        Assert.assertEquals(0, counter.counterValue)
    }

    @Test
    fun testIncrement() {
        val counter = Counter(0)
        counter.increment()
        Assert.assertEquals(1, counter.counterValue)
    }

    @Test
    fun testIncrementInitialValue() {
        val counter = Counter(5)
        counter.increment()
        Assert.assertEquals(6, counter.counterValue)
    }

    @Test
    fun testReset() {
        val counter = Counter(5)
        counter.reset()
        Assert.assertEquals(0, counter.counterValue)
    }


}