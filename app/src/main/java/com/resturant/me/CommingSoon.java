package com.resturant.me;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class CommingSoon extends Activity{

	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comming_soon);
		
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
			PopupMenu popm=new PopupMenu(CommingSoon.this,mm);
			popm.getMenuInflater().inflate(R.menu.menubar, popm.getMenu());
			popm.show();
			popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					switch(item.getItemId())
					{
					case R.id.menurest:
						Intent i = new Intent(CommingSoon.this,Rest.class);
						startActivity(i);
						break;
					case R.id.menucafe:
						Intent i1 = new Intent(CommingSoon.this,CommingSoon.class);
						startActivity(i1);
						break;
						
					case R.id.menupat:
						Intent i11 = new Intent(CommingSoon.this,CommingSoon.class);
						startActivity(i11);
						break;
					
					}
					return false;
				}
			});
			break;
		case R.id.settings:
			View mn=findViewById(R.id.settings);
			PopupMenu popm1=new PopupMenu(CommingSoon.this,mn);
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
						Intent i = new Intent(CommingSoon.this,Names.class);
						startActivity(i);
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
