package com.example.cinemaxv3.view.ui.activity

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.work.BackoffPolicy
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.ActivityMainBinding
import com.example.cinemaxv3.databinding.InternetConnectionDialogBinding
import com.example.cinemaxv3.receivers.ConnectivityObserver
import com.example.cinemaxv3.receivers.ConnectivityObserverImpl
import com.example.worker.MoviesSyncWorker
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var internetPopup: InternetConnectionDialogBinding
    private lateinit var status: String
    private lateinit var connectivityObserver: ConnectivityObserver
    private lateinit var connectivityDialog: Dialog

    private val networkConnectivityObserver: ConnectivityObserverImpl by lazy {
        ConnectivityObserverImpl(this)
    }

    private var isDialogShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        internetPopup = InternetConnectionDialogBinding.inflate(layoutInflater)

        connectivityDialog = Dialog(this)
        connectivityDialog.setContentView(R.layout.internet_connection_dialog)
        connectivityDialog.window?.setGravity(Gravity.CENTER)

        internetPopup.buttonRetry.setOnClickListener {
            hideDialog()
            Log.d("MAIN ACTIVITY", "Retry button clicked")

        }

        observeConnectivityChanges()
        setUpNavigation()
        startBackgroundWork()
    }

    private fun startBackgroundWork(){
        val constraints = androidx.work.Constraints.Builder()
            .setRequiresCharging(false)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val periodicWorkRequest:WorkRequest = PeriodicWorkRequestBuilder<MoviesSyncWorker>(
            repeatInterval = 1, // Repeat every 1 day
            repeatIntervalTimeUnit = TimeUnit.DAYS
        )
            .setConstraints(constraints)
            .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5, TimeUnit.SECONDS)
            .build()

        WorkManager.getInstance(this).enqueue(
            periodicWorkRequest
        )
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id)
            .observe(this,
                Observer { workInfo ->
                    if (workInfo.state == WorkInfo.State.RUNNING) {
                        println("running")
                        Log.i("MAIN ACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITY", "Running")
                    } else if (workInfo.state == WorkInfo.State.FAILED) {
                        println("failed")
                        Log.i("MAIN ACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITY", "Failed")
                    } else if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                        println("succeed")
                        Log.i("MAIN ACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITY", "Succeed")
                    } else if (workInfo.state == WorkInfo.State.ENQUEUED) {
                        println("Enqueud")
                        Log.i("MAIN ACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITY", "Enqued")
                    }

                })

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(periodicWorkRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    val toast = Toast.makeText(this, "Tsk completed", Toast.LENGTH_SHORT) // in Activity
                    toast.show()
                    Log.d("MAIN ACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITY", "Task successful")
                }else{
                    Log.d("MAIN ACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITYACTIVITY", "Task failed")
                }
            })
    }

    private fun observeConnectivityChanges() {
        lifecycleScope.launch {
            networkConnectivityObserver.observer().collect { status ->
                when (status) {
                    ConnectivityObserver.Status.UnAvailable -> showDialog()
                    ConnectivityObserver.Status.Available -> hideDialog()
                }
            }
        }
    }

    private fun showDialog() {
        if (!isDialogShown) {
            connectivityDialog.show()
            isDialogShown = true
        }
    }

    private fun hideDialog() {
        if (isDialogShown) {
            connectivityDialog.dismiss()
            isDialogShown = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkConnectivityObserver.networkChangeReceiver)
    }

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.movieNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        mainBinding.bottomNavigationView.setupWithNavController(navController)
    }
}






