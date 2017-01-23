package com.resturant.me;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.PopupMenu;

public class Pat extends Activity implements OnClickListener{

	ImageButton s3,sabr,menuBar,Three;
	Animation animTranslate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.pate);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);

        animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		s3=(ImageButton) findViewById(R.id.s3);
		sabr=(ImageButton) findViewById(R.id.sabr);
        menuBar = (ImageButton) findViewById(R.id.menuMenu);
        Three = (ImageButton) findViewById(R.id.threeMenu);


		s3.setOnClickListener(this);
		sabr.setOnClickListener(this);
        menuBar.setOnClickListener(this);
        Three.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent i=new Intent(Pat.this,AllPat.class);
		switch(v.getId())
		{
		case R.id.s3:
			v.startAnimation(animTranslate);
			i.putExtra("pat", "s3");
			i.putExtra("num","tel:0473215566");
			startActivity(i);
			break;
		case R.id.sabr:
			v.startAnimation(animTranslate);
			i.putExtra("pat", "sabr");
			i.putExtra("num","tel:01012124006");
			startActivity(i);
			break;

            case R.id.menuMenu:
                View mm=findViewById(R.id.menuMenu);
                PopupMenu popm=new PopupMenu(Pat.this,mm);
                popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
                popm.show();
                popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurest:
                                Intent i = new Intent(Pat.this,Rest.class);
                                startActivity(i);
                                break;
                            case R.id.menupat:
                                Intent i1 = new Intent(Pat.this,Pat.class);
                                startActivity(i1);
                                break;
                            case R.id.menucafe:
                                Intent i11 = new Intent(Pat.this,Cafes.class);
                                startActivity(i11);
                                break;
                            case R.id.menuice:
                                Intent i12 = new Intent(Pat.this,Ice.class);
                                startActivity(i12);
                                break;

                        }
                        return false;
                    }
                });
                break;
            case R.id.threeMenu:
                View mn=findViewById(R.id.threeMenu);
                PopupMenu popm1=new PopupMenu(Pat.this,mn);
                popm1.getMenuInflater().inflate(R.menu.settingsbar, popm1.getMenu());
                popm1.show();
                popm1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurate:
                                String url = "https://play.google.com/store/apps/details?id=com.resturant.me";
                                Intent i1 = new Intent(Intent.ACTION_VIEW);
                                i1.setData(Uri.parse(url));
                                startActivity(i1);
                                break;
                            case R.id.menucreates:
                                Intent i = new Intent(Pat.this,Names.class);
                                startActivity(i);
                                break;
                            case R.id.menucontact:
                                String url1 = "https://www.facebook.com/3rfnyKFS";
                                Intent i11 = new Intent(Intent.ACTION_VIEW);
                                i11.setData(Uri.parse(url1));
                                startActivity(i11);
                                break;

                        }
                        return false;
                    }
                });
                break;


        }
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
	//	MenuInflater mm=getMenuInflater();
	//	mm.inflate(R.menu.bar,menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{

		}
		
		
		return true;
	}
	
}
