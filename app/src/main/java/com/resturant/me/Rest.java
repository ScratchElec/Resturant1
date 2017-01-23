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

public class Rest extends Activity implements OnClickListener{

	ImageButton mo,exp,pota,bake,kh,hd,st,am,ban,ayoub,kat,kin,wel,zen,sph,ageba,wal,menuBar,Three;
	Animation animTranslate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.grb);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.header);
        menuBar = (ImageButton) findViewById(R.id.menuMenu);
        Three = (ImageButton) findViewById(R.id.threeMenu);
        menuBar.setOnClickListener(this);
        Three.setOnClickListener(this);

		animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		mo=(ImageButton) findViewById(R.id.mo);
		exp=(ImageButton) findViewById(R.id.x);
		pota=(ImageButton) findViewById(R.id.pot);
		bake=(ImageButton) findViewById(R.id.bake);
		kh=(ImageButton) findViewById(R.id.kh);
		hd=(ImageButton) findViewById(R.id.hd);
		st=(ImageButton) findViewById(R.id.stakoza);
		am=(ImageButton) findViewById(R.id.american);
		ban=(ImageButton) findViewById(R.id.ban);
		ayoub=(ImageButton) findViewById(R.id.ayoub);
		kat=(ImageButton) findViewById(R.id.katchup);
		kin=(ImageButton) findViewById(R.id.kin);
		wel=(ImageButton) findViewById(R.id.wel);
		zen=(ImageButton) findViewById(R.id.zen);
		sph=(ImageButton) findViewById(R.id.sph);
		ageba=(ImageButton) findViewById(R.id.ageba);
		wal=(ImageButton) findViewById(R.id.wal);
		
		mo.setOnClickListener(this);
		exp.setOnClickListener(this);
		pota.setOnClickListener(this);
		bake.setOnClickListener(this);
		kh.setOnClickListener(this);
		hd.setOnClickListener(this);
		wel.setOnClickListener(this);
		kin.setOnClickListener(this);
		kat.setOnClickListener(this);
		ayoub.setOnClickListener(this);
		ban.setOnClickListener(this);
		am.setOnClickListener(this);
		st.setOnClickListener(this);
		zen.setOnClickListener(this);
		ageba.setOnClickListener(this);
		sph.setOnClickListener(this);
		wal.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent i=new Intent(Rest.this,AllRest.class);
		switch(v.getId())
		{
            case R.id.menuMenu:
                View mm=findViewById(R.id.menuMenu);
                PopupMenu popm=new PopupMenu(Rest.this,mm);
                popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
                popm.show();
                popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch(item.getItemId())
                        {
                            case R.id.menurest:
                                Intent i = new Intent(Rest.this,Rest.class);
                                startActivity(i);
                                break;
                            case R.id.menucafe:
                                Intent i1 = new Intent(Rest.this,Pat.class);
                                startActivity(i1);
                                break;

                            case R.id.menupat:
                                Intent i11 = new Intent(Rest.this,Cafes.class);
                                startActivity(i11);
                                break;
                            case R.id.menuice:
                                Intent i12 = new Intent(Rest.this,Ice.class);
                                startActivity(i12);
                                break;

                        }
                        return true;
                    }
                });
                break;

            case R.id.threeMenu:
                View mn=findViewById(R.id.threeMenu);
                PopupMenu popm1=new PopupMenu(Rest.this,mn);
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
                                Intent i = new Intent(Rest.this,Names.class);
                                startActivity(i);
                                break;
                            case R.id.menucontact:
                                String url1 = "https://www.facebook.com/3rfnyKFS";
                                Intent i11 = new Intent(Intent.ACTION_VIEW);
                                i11.setData(Uri.parse(url1));
                                startActivity(i11);
                                break;

                        }
                        return true;
                    }
                });
                break;
		
		case R.id.mo:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","mo");
			i.putExtra("num","tel:16600");
			startActivity(i);
			break;
		

		case R.id.bake:
			v.startAnimation(animTranslate);
			i.putExtra("kin","bake");
			i.putExtra("num","tel:01007272083");
			startActivity(i);
			break;
		case R.id.pot:
			v.startAnimation(animTranslate);
			i.putExtra("kin","pot");
			i.putExtra("num","tel:01099004194");
			startActivity(i);
			break;
		case R.id.x:
			v.startAnimation(animTranslate);
			i.putExtra("kin","x");
			i.putExtra("num","tel:0473227111");
			startActivity(i);
			break;
		case R.id.hd:
			v.startAnimation(animTranslate);
			i.putExtra("kin","hd");
			i.putExtra("num","tel:01011462951");
			startActivity(i);
			break;
		case R.id.kh:
			v.startAnimation(animTranslate);
			i.putExtra("kin","kh");
			i.putExtra("num","tel:01006562482");
			startActivity(i);
			break;
		
		case R.id.stakoza:
			v.startAnimation(animTranslate);
			i.putExtra( "kin","st");
			i.putExtra("num","tel:01270104001");
			startActivity(i);
			break;
			
		case R.id.american:
			v.startAnimation(animTranslate);
			i.putExtra("kin","am");
			i.putExtra("num","tel:01156269996");
			startActivity(i);
			break;
		case R.id.ban:
			v.startAnimation(animTranslate);
			i.putExtra("kin","ban");
			i.putExtra("num","tel:01066671929");
			startActivity(i);
			break;
		case R.id.ayoub:
			v.startAnimation(animTranslate);
			i.putExtra("kin","ayoub");
			i.putExtra("num","tel:16365");
			startActivity(i);
			break;
		case R.id.katchup:
			v.startAnimation(animTranslate);
			i.putExtra("kin","kat");
			i.putExtra("num","tel:01023001020");
			startActivity(i);
			break;
		case R.id.kin:
			v.startAnimation(animTranslate);
			i.putExtra("kin","kin");
			i.putExtra("num","tel:19019");
			startActivity(i);
			break;
		case R.id.wel:
			v.startAnimation(animTranslate);
			i.putExtra("kin","wel");
			i.putExtra("num","tel:16799");
			startActivity(i);
			break;
		case R.id.zen:
			v.startAnimation(animTranslate);
			i.putExtra("kin","zen");
			i.putExtra("num","tel:01020267020");
			startActivity(i);
			break;
		case R.id.sph:
			v.startAnimation(animTranslate);
			i.putExtra("kin","sph");
			i.putExtra("num","tel:01013688856");
			startActivity(i);
			break;
		case R.id.ageba:
			v.startAnimation(animTranslate);
			i.putExtra("kin","ageba");
			i.putExtra("num","tel:01004878987");
			startActivity(i);
			break;
		case R.id.wal:
			v.startAnimation(animTranslate);
			i.putExtra("kin","wal");
			i.putExtra("num","tel:01066652324");
			startActivity(i);
			break;
		}
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		//MenuInflater mm=getMenuInflater();
		//mm.inflate(R.menu.bar,menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		/*case R.id.menubar:
			View mm=findViewById(R.id.menubar);
			PopupMenu popm=new PopupMenu(Rest.this,mm);
			popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
			popm.show();
			popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					switch(item.getItemId())
					{
					case R.id.menurest:
						Intent i = new Intent(Rest.this,Rest.class);
						startActivity(i);
						break;
					case R.id.menucafe:
						Intent i1 = new Intent(Rest.this,Cafes.class);
						startActivity(i1);
						break;
					case R.id.menupat:
						Intent i11 = new Intent(Rest.this,Pat.class);
						startActivity(i11);
						break;
					case R.id.menuice:
						Intent i12 = new Intent(Rest.this,Ice.class);
						startActivity(i12);
						break;
					
					}
					return false;
				}
			});
			break;
		case R.id.settings:
			View mn=findViewById(R.id.settings);
			PopupMenu popm1=new PopupMenu(Rest.this,mn);
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
						Intent i = new Intent(Rest.this,Names.class);
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
		*/
		}

		
		return true;
	}
	
}
