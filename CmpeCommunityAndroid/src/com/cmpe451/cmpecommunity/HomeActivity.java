package com.cmpe451.cmpecommunity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class HomeActivity extends TabActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(StaticUser.name);
		setContentView(R.layout.home);
		TabHost tabHost = getTabHost();

		
		TabSpec profileTab = tabHost.newTabSpec("Profile");
		profileTab.setIndicator("Profile", getResources().getDrawable(R.drawable.profile));
		profileTab.setContent(new Intent(this, ProfileActivity.class));

		TabSpec tagsTab = tabHost.newTabSpec("Tags");		
		tagsTab.setIndicator("Tags", getResources().getDrawable(R.drawable.tags));
		tagsTab.setContent(new Intent(this, TagListActivity.class));

		TabSpec eventsTab = tabHost.newTabSpec("Events");
		eventsTab.setIndicator("Events", getResources().getDrawable(R.drawable.events));
		eventsTab.setContent(R.id.events);
		
		tabHost.addTab(profileTab);
		tabHost.addTab(tagsTab);
		tabHost.addTab(eventsTab); 
		}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.options_menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.logout:
	            finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
