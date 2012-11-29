package com.cmpe451.cmpecommunity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class HomeActivity extends TabActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		TabHost tabHost = getTabHost();
	
		TabSpec profileTab = tabHost.newTabSpec("Profile");
		profileTab.setContent(new Intent(this, ProfileActivity.class));
		profileTab.setIndicator("Profile", getResources().getDrawable(R.drawable.profile));

		TabSpec tagsTab = tabHost.newTabSpec("Tags");
		tagsTab.setIndicator("Tags", getResources().getDrawable(R.drawable.tags));
		tagsTab.setContent(R.id.tags);

		TabSpec eventsTab = tabHost.newTabSpec("Events");
		eventsTab.setIndicator("Events", getResources().getDrawable(R.drawable.events));
		eventsTab.setContent(R.id.events);
		
		tabHost.addTab(profileTab);
		tabHost.addTab(tagsTab);
		tabHost.addTab(eventsTab); 
		}
}
