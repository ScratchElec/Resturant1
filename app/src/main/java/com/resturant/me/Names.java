package com.resturant.me;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class Names extends Activity{

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.names);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater mm=getMenuInflater();
		mm.inflate(R.menu.bar,menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		case R.id.menubar:
			View mm=findViewById(R.id.menubar);
			PopupMenu popm=new PopupMenu(Names.this,mm);
			popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
			popm.show();
			popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					switch(item.getItemId())
					{
					case R.id.menurest:
						Intent i = new Intent(Names.this,Rest.class);
						startActivity(i);
						break;
					case R.id.menupat:
						Intent i1 = new Intent(Names.this,Pat.class);
						startActivity(i1);
						break;
						
					case R.id.menucafe:
						Intent i11 = new Intent(Names.this,Cafes.class);
						startActivity(i11);
						break;
					case R.id.menuice:
						Intent i12 = new Intent(Names.this,Ice.class);
						startActivity(i12);
						break;
					
					}
					return false;
				}
			});
			break;
		case R.id.settings:
			View mn=findViewById(R.id.settings);
			PopupMenu popm1=new PopupMenu(Names.this,mn);
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
						Intent i = new Intent(Names.this,Names.class);
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
		
		
		return true;
	}

	
	

}
