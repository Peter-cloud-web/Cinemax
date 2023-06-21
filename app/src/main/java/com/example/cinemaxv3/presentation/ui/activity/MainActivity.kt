package com.example.cinemaxv3.presentation.ui.activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.cinemaxv3.R
import com.example.cinemaxv3.databinding.ActivityMainBinding
import com.example.cinemaxv3.databinding.InternetConnectionDialogBinding
import com.example.cinemaxv3.util.ConnectivityObserver
import com.example.cinemaxv3.util.NetworkConnectivityObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var internetPopup: InternetConnectionDialogBinding
    private lateinit var status : String
    private lateinit var connectivityObserver: ConnectivityObserver
    private lateinit var connectivityDialog: Dialog

    private val networkConnectivityObserver: NetworkConnectivityObserver by lazy {
        NetworkConnectivityObserver(this)
    }

    private var isDialogShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        internetPopup = InternetConnectionDialogBinding.inflate(layoutInflater)

        setContentView(mainBinding.root)

        connectivityDialog = Dialog(this)
        connectivityDialog.setContentView(R.layout.internet_connection_dialog)
        connectivityDialog.window?.setGravity(Gravity.CENTER)

        observeConnectivityChanges()
        setUpNavigation()

        }

    private fun observeConnectivityChanges() {
        lifecycleScope.launch {
            networkConnectivityObserver.observer().collect { status ->
                when (status) {
                    ConnectivityObserver.Status.UnAvailable -> {
                        showDialog()
                        internetPopup.buttonRetry.setOnClickListener{
                           hideDialog()
                           launch { delay(6000)  }
                           when(status){
                               ConnectivityObserver.Status.UnAvailable -> showDialog()
                               else -> {
                                   hideDialog()
                               }
                           }
                        }
                    }
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






