package com.sgaikar1.broadcastreceiverexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityReceiver.connectivityReceiverListener = this;
    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        Toast.makeText(this, isConnected?"Connected to internet":"Disconnectd", Toast.LENGTH_SHORT).show();
    }
}
