package com.example.data

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.work.testing.TestListenableWorkerBuilder
import com.example.worker.MoviesSyncWorker
import com.google.common.truth.ExpectFailure.assertThat
import org.hamcrest.core.Is.`is`

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyMovieWorkTest {
//    @get:Rule
//
//    private lateinit var context: Context
//
//    @Before
//    fun setup() {
//        context = ApplicationProvider.getApplicationContext()
//    }
//    @Test
//    fun testMyWork() {
//        // Get the ListenableWorker
//        val worker =
//            TestListenableWorkerBuilder<MoviesSyncWorker>(context).build()
//        // Run the worker synchronously
//        val result = worker.startWork().get()
//
//    }


}