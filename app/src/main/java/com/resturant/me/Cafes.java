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

public class Cafes extends Activity implements OnClickListener{

	ImageButton lareka,bn,menuBar,Three;
	Animation animTranslate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.cafe);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);

        menuBar = (ImageButton) findViewById(R.id.menuMenu);
        Three = (ImageButton) findViewById(R.id.threeMenu);
        bn=(ImageButton) findViewById(R.id.bn);
        bn.setOnClickListener(this);
        menuBar.setOnClickListener(this);
        Three.setOnClickListener(this);
		animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		
		

		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent i=new Intent(Cafes.this,AllCAfes.class);
		switch(v.getId())
		{

		case R.id.bn:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","bn");
			startActivity(i);
			break;

            case R.id.menuMenu:
                View mm=findViewById(R.id.menuMenu);
                PopupMenu popm=new PopupMenu(Cafes.this,mm);
                popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
                popm.show();
                popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurest:
                                Intent i = new Intent(Cafes.this,Rest.class);
                                startActivity(i);
                                break;
                            case R.id.menucafe:
                                Intent i1 = new Intent(Cafes.this,Cafes.class);
                                startActivity(i1);
                                break;
                            case R.id.menupat:
                                Intent i11 = new Intent(Cafes.this,Pat.class);
                                startActivity(i11);
                                break;
                            case R.id.menuice:
                                Intent i12 = new Intent(Cafes.this,Ice.class);
                                startActivity(i12);
                                break;

                        }
                        return false;
                    }
                });
                break;
            case R.id.threeMenu:
                View mn=findViewById(R.id.threeMenu);
                PopupMenu popm1=new PopupMenu(Cafes.this,mn);
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
                                Intent i = new Intent(Cafes.this,Names.class);
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
