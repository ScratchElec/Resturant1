package com.resturant.me;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.java.User;
import com.kinvey.java.core.KinveyClientCallback;

import java.util.ArrayList;

import data.access.RestuarantEntity;

/**
 * Created by Mahmoud Ellawatty on 16/07/2016.
 */
public class UploadData  extends AsyncTask<Void , Void , Void>{

    private final String ARRAY_VIEWS_KEY = "VIEWS_KEY";
    private final String ARRAY_CALLS_KEY = "CALLS_KEY";

    ArrayList<String> ViewsData = new ArrayList<String>();
    ArrayList<String> CallsData = new ArrayList<String>();

    String[] Names = {"kin" , "mo" , "kat" , "ayoub" , "x" , "fwakeh" , "zen" , "bake",
                      "wel" , "pota" , "ageba" , "am" , "ban" , "cono" , "ftoh" , "hd",
                      "bn"  , "rsh" , "s3" , "sabr" , "st" , "kh"};

    SharedPreferences sharedPreferences;
    Context context;

    private final String appKey="kid_Syyxg5dB";
    private final String appSecret="0a7e69ebd0654fe8835459fc3e482fe5";

    public UploadData( Context c , SharedPreferences prefs){
        this.sharedPreferences = prefs;
        this.context = c;
    }

    @Override
    protected Void doInBackground(Void... params) {
        SharedPreferencesArray preferencesArray = new SharedPreferencesArray(this.context);
        ArrayList<String> Views = preferencesArray.getArray(ARRAY_VIEWS_KEY);
        ArrayList<String> Calls = preferencesArray.getArray(ARRAY_CALLS_KEY);

        TelephonyManager phoneManager = (TelephonyManager)
                this.context.getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = phoneManager.getDeviceId();

        for(int i =0;i< Names.length ; i++){
            // views comparison variables
            int Current_Views_Count = getCount("V"+Names[i]);
            int Stored_Views_Count  = Integer.parseInt(Views.get(i));
            ViewsData.add(i,String.valueOf(Current_Views_Count));

            // calls comparison variables
            int Current_Calls_Count = getCount("C"+Names[i]);
            int Stored_Calls_Count  = Integer.parseInt(Calls.get(i));
            CallsData.add(i,String.valueOf(Current_Calls_Count));

            // views comparison algorithm
            if(Current_Views_Count > Stored_Views_Count){
                if( addValueinView(Names[i],String.valueOf(Current_Views_Count),String.valueOf(Stored_Calls_Count),phoneNumber)){

                    // update views data
                    preferencesArray.PutArray(ARRAY_VIEWS_KEY,ViewsData);

                }
            }

            // calls comparison algorithm
            if(Current_Calls_Count > Stored_Calls_Count){
                if(addValueinView(Names[i],String.valueOf(Current_Calls_Count),String.valueOf(Stored_Views_Count),phoneNumber)){

                    // update calls data
                    preferencesArray.PutArray(ARRAY_CALLS_KEY, CallsData);

                }
            }
        }


        return null;
    }

    public boolean addValueinView(String Name, String view_no , String call_no,String phoneNumber){
        final Client mKinveyClient = new Client.Builder(appKey , appSecret,this.context).build();
        final boolean[] done = {false};

        if(mKinveyClient.user().isUserLoggedIn()){

        }else {

            mKinveyClient.user().login("Ahmed", "1111", new KinveyUserCallback() {
                @Override
                public void onSuccess(User user) {
                    CharSequence text = user.getUsername() + ", your account has been created.";
                    Log.d("arafny", text.toString());
                }

                @Override
                public void onFailure(Throwable t) {
                    CharSequence text = "Could not sign up.";
                    Log.e("arafny", text.toString(), t);
                }
            });
        }
        Log.e("NEXT", "NEXT");
        RestuarantEntity restuarantEntity = new RestuarantEntity();
        restuarantEntity.put("studentName",Name);
        restuarantEntity.put("Views", view_no);
        restuarantEntity.put("Calls", call_no);
        restuarantEntity.put("PhoneNumber", phoneNumber);
        AsyncAppData<RestuarantEntity> Students_Info = mKinveyClient.appData("RestaurantsInfo",RestuarantEntity.class);
        Log.e("NEXT", "SAVE");
        // Students_Info.setCache(new InMemoryLRUCache(), CachePolicy.NETWORKFIRST);
        // Students_Info.setOffline(OfflinePolicy.ONLINE_FIRST, new SqlLiteOfflineStore<RestuarantEntity>(this));
        Students_Info.save(restuarantEntity, new KinveyClientCallback<RestuarantEntity>() {

            @Override
            public void onSuccess(RestuarantEntity studentEntity) {

                Log.e("NEXT","SUCCESS");
                done[0] = true;

            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("NEXT",String.valueOf(t));
            }
        });
        Log.e("NEXT", "Done");
        return done[0];


    }

    private int getCount(String Restaurant_Name) {
        int no = this.sharedPreferences.getInt(Restaurant_Name, 0);
        //Toast.makeText(getApplicationContext(),String.valueOf(no),Toast.LENGTH_SHORT).show();
        return no;
    }
}
