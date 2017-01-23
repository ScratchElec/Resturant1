package com.resturant.me;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Mahmoud Ellawatty on 16/07/2016.
 */
public class ConnectivityChangeReceiver extends BroadcastReceiver {
    SharedPreferences sharedPref;

    @Override
    public void onReceive(Context context, Intent intent) {
       // Toast.makeText(context, String.valueOf(isConnected(context)), Toast.LENGTH_LONG).show();
       // if (isConnected(context)) {
          //  Toast.makeText(context,String.valueOf("INSide"), Toast.LENGTH_LONG).show();
            Intent upload = new Intent(context, Upload.class);
            context.startService(upload);
        //}
       // sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
       // UploadData sendData = new UploadData(context,sharedPref);
       // sendData.execute();

    }

    public  boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null ;

    }
}
