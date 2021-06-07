package com.example.androidcounter

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class PersistenceTest {

    @Before
    fun resetCounter() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CounterPersistenceManager(appContext).persistContent(Counter(0))
    }

    @Test
    fun testLoadCounter() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val manager = CounterPersistenceManager(appContext)
        val counter = manager.loadCounter()

        assertEquals(0, counter.counterValue)
    }

    @Test
    fun testStoreCounter() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        val counter = Counter(5)

        val manager = CounterPersistenceManager(appContext)
        manager.persistContent(counter)

        val counter2 = manager.loadCounter()
        assertEquals(5, counter2.counterValue)
    }

}