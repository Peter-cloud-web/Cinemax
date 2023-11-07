package com.example.cinemaxv3.presentation.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import com.example.cinemaxv3.R;
import com.example.cinemaxv3.databinding.ActivityMainBinding;
import com.example.cinemaxv3.databinding.InternetConnectionDialogBinding;
import com.example.framework.receivers.ConnectivityObserver;
import com.example.framework.receivers.NetworkConnectivityObserver;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/cinemaxv3/presentation/ui/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "connectivityDialog", "Landroid/app/Dialog;", "connectivityObserver", "Lcom/example/framework/receivers/ConnectivityObserver;", "internetPopup", "Lcom/example/cinemaxv3/databinding/InternetConnectionDialogBinding;", "isDialogShown", "", "mainBinding", "Lcom/example/cinemaxv3/databinding/ActivityMainBinding;", "networkConnectivityObserver", "Lcom/example/framework/receivers/NetworkConnectivityObserver;", "getNetworkConnectivityObserver", "()Lcom/example/framework/receivers/NetworkConnectivityObserver;", "networkConnectivityObserver$delegate", "Lkotlin/Lazy;", "status", "", "hideDialog", "", "observeConnectivityChanges", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setUpNavigation", "showDialog", "presentation_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.cinemaxv3.databinding.ActivityMainBinding mainBinding;
    private com.example.cinemaxv3.databinding.InternetConnectionDialogBinding internetPopup;
    private java.lang.String status;
    private com.example.framework.receivers.ConnectivityObserver connectivityObserver;
    private android.app.Dialog connectivityDialog;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy networkConnectivityObserver$delegate = null;
    private boolean isDialogShown = false;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.framework.receivers.NetworkConnectivityObserver getNetworkConnectivityObserver() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeConnectivityChanges() {
    }
    
    private final void showDialog() {
    }
    
    private final void hideDialog() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void setUpNavigation() {
    }
}