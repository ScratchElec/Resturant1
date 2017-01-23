package com.resturant.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

public class Spalsh extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		StrictMode.enableDefaults();
		Thread timer = new Thread()
		{
			public void run()
			{
				try
				{
					sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity= new Intent("com.resturant.me.MENU");
					startActivity(openMainActivity);
				}
				}
			

			
		};
		timer.start();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
