package data.access;

import android.content.Context;
import android.util.Log;

import com.kinvey.android.AsyncAppData;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyUserCallback;
import com.kinvey.android.offline.SqlLiteOfflineStore;
import com.kinvey.java.User;
import com.kinvey.java.core.KinveyClientCallback;
import com.kinvey.java.offline.OfflinePolicy;

/**
 * Created by Mahmoud Ellawatty on 11/06/2016.
 */
public class KinveyObject {

    private final String appKey="kid_ZyZKL_nLGW";
    private final String appSecret="3ce0f28583734036b4515d4d24fdeacf";
    final Client mKinveyClient;
    public Context context;

    public KinveyObject(Context myContext){
        context= myContext;
        mKinveyClient = new Client.Builder(appKey , appSecret,myContext).build();
    }

    public void logIn(){
        mKinveyClient.user().logout().execute();

        mKinveyClient.user().login("Ahmed", "1111", new KinveyUserCallback() {
            @Override
            public void onSuccess(User user) {
                CharSequence text = user.getUsername() + ", your account has been created.";
                Log.d("arafny", text.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                CharSequence text = "Could not sign up.";
                Log.e("arafny", text.toString(), throwable);
            }
        });
    }
    public void addValueinCall(String Name){
        logIn();
        RestuarantEntity restuarantEntity = new RestuarantEntity();
        restuarantEntity.put("restuarantName",Name);
        restuarantEntity.put("Call", "1");
        AsyncAppData<RestuarantEntity> Students_Info = mKinveyClient.appData("RestuarantCall",RestuarantEntity.class);
        Students_Info.setOffline(OfflinePolicy.LOCAL_FIRST, new SqlLiteOfflineStore<RestuarantEntity>(context));
        Students_Info.save(restuarantEntity, new KinveyClientCallback<RestuarantEntity>() {

            @Override
            public void onSuccess(RestuarantEntity studentEntity) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    public void addValueinView(String Name){
        logIn();
        RestuarantEntity restuarantEntity = new RestuarantEntity();
        restuarantEntity.put("restuarantName",Name);
        restuarantEntity.put("Views", "1");
        AsyncAppData<RestuarantEntity> Students_Info = mKinveyClient.appData("RestuarantViews",RestuarantEntity.class);
        Students_Info.setOffline(OfflinePolicy.LOCAL_FIRST, new SqlLiteOfflineStore<RestuarantEntity>(context));
        Students_Info.save(restuarantEntity, new KinveyClientCallback<RestuarantEntity>() {

            @Override
            public void onSuccess(RestuarantEntity studentEntity) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
