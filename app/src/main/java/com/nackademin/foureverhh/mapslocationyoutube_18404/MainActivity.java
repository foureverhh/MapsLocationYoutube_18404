package com.nackademin.foureverhh.mapslocationyoutube_18404;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.1Check whether google play service works
        if(googleServiceAvailable()){
            Toast.makeText(this,"Perfect!!!Google play services works!",Toast.LENGTH_LONG).show();
        }
    }

    //1.to check whether google service is available
    public boolean googleServiceAvailable(){
        //To check whether google play service is installed
        //and the version is no older than the app
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS) {
            return true;
        }//User can handle the GoogleApi problem
        else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this,isAvailable,0);
            dialog.show();
        }else{
            Toast.makeText(this,"Can not connect to google play services",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
