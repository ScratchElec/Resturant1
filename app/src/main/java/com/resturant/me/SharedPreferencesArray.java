package com.resturant.me;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Mahmoud Ellawatty on 16/07/2016.
 */
public class SharedPreferencesArray {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String[] Names = {"kin" , "mo" , "kat" , "ayoub" , "x" , "fwakeh" , "zen" , "bake",
            "wel" , "pota" , "ageba" , "am" , "ban" , "cono" , "ftoh" , "hd",
            "bn"  , "rsh" , "s3" , "sabr" , "st" , "kh"};


    public SharedPreferencesArray(Context context){
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        editor = sharedPreferences.edit();
    }

    public void PutArray(String key , ArrayList<String> arrayList){
       // JSONArray jArray = new JSONArray(arrayList);
       /* editor.remove(key);
        Set<String> set = new HashSet<String>();
        set.addAll(arrayList);
        editor.putStringSet(key, set);
        // editor.putInt(key, Integer.valueOf(jArray.toString()));
        editor.commit();*/

        editor.remove(key);
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(arrayList);

        editor.putString(key, jsonFavorites);

        editor.commit();

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public ArrayList<String> getArray(String key){
        ArrayList<String> values = new ArrayList<String>();
        String jArrayInteger = sharedPreferences.getString(key, "0");
        if(jArrayInteger == "0") return getDefaultArray();
        else {
            try{
                JSONArray jArray = new JSONArray(jArrayInteger);
                for (int i = 0 ; i< jArray.length() ; i++) {
                        values.add(i,jArray.getString(i));
                }
                return values;
            }catch (Exception ex){
                return getDefaultArray();
            }


        }
    }

    private ArrayList<String> getDefaultArray() {
        ArrayList<String> defaultArray = new ArrayList<String>();
        for(int i =0;i<Names.length ; i++){
            defaultArray.add(i,"0");
        }

        return defaultArray;
    }


    public int getCount(String Restaurant_Name) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        int no = sharedPreferences.getInt(Restaurant_Name, 0);
        //Toast.makeText(getApplicationContext(),String.valueOf(no),Toast.LENGTH_SHORT).show();
        return no;
    }
}
