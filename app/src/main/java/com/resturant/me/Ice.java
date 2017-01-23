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

public class Ice extends Activity implements OnClickListener{

	ImageButton rsh,kok,robin,nine,ft,menuBar,Three;
	Animation animTranslate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.ice);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);



		animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		rsh=(ImageButton) findViewById(R.id.rsh);
		robin=(ImageButton) findViewById(R.id.robin);
		kok=(ImageButton) findViewById(R.id.kok);
		nine=(ImageButton) findViewById(R.id.nine);
		ft=(ImageButton) findViewById(R.id.ft);
        menuBar = (ImageButton) findViewById(R.id.menuMenu);
        Three = (ImageButton) findViewById(R.id.threeMenu);

        menuBar.setOnClickListener(this);
        Three.setOnClickListener(this);
		rsh.setOnClickListener(this);
		nine.setOnClickListener(this);
		kok.setOnClickListener(this);
		robin.setOnClickListener(this);
		ft.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent i=new Intent(Ice.this,AllIce.class);
		switch(v.getId())
		{
		
		case R.id.robin:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","robin");
			i.putExtra("num","tel:01002906162");
			startActivity(i);
			break;
		case R.id.rsh:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","rsh");
			i.putExtra("num","tel:01111091313");
			startActivity(i);
			break;
		case R.id.kok:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","kok");
			i.putExtra("num","tel:01014115363");
			startActivity(i);
			break;
		case R.id.nine:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","nine");
			i.putExtra("num","tel:01143250911");
			startActivity(i);
			break;
		case R.id.ft:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","ft");
            i.putExtra("num","tel:0473221310");
			startActivity(i);
			break;

            case R.id.menuMenu:
                View mm=findViewById(R.id.menuMenu);
                PopupMenu popm=new PopupMenu(Ice.this,mm);
                popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
                popm.show();
                popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurest:
                                Intent i = new Intent(Ice.this,Rest.class);
                                startActivity(i);
                                break;
                            case R.id.menucafe:
                                Intent i1 = new Intent(Ice.this,Cafes.class);
                                startActivity(i1);
                                break;
                            case R.id.menupat:
                                Intent i11 = new Intent(Ice.this,Pat.class);
                                startActivity(i11);
                                break;
                            case R.id.menuice:
                                Intent i12 = new Intent(Ice.this,Ice.class);
                                startActivity(i12);
                                break;

                        }
                        return false;
                    }
                });
                break;
            case R.id.threeMenu:
                View mn=findViewById(R.id.threeMenu);
                PopupMenu popm1=new PopupMenu(Ice.this,mn);
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
                                Intent i = new Intent(Ice.this,Names.class);
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
