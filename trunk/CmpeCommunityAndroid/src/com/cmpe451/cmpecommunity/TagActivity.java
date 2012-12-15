package com.cmpe451.cmpecommunity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class TagActivity extends TabActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tag_page);
		
		setTitle(StaticUser.chosenTag.getTag());
		
		TabHost tabHost = getTabHost();
		
		// Wall tab
		Intent i = new Intent(this, FeedActivity.class);
		Bundle b = new Bundle();
		b.putString("FeedType", "tagWall");
		b.putBoolean("TagPage", true);
		i.putExtras(b); 
		
		TabSpec wallTab = tabHost.newTabSpec("Wall");
		wallTab.setIndicator("Wall");
		wallTab.setContent(i);
		
		// News Feed Tab	
		TabSpec usersTab = tabHost.newTabSpec("Users");	
		usersTab.setContent(new Intent(this, UserListActivity.class));
		usersTab.setIndicator("Users");
		
		// add tabs
		tabHost.addTab(wallTab);
		tabHost.addTab(usersTab);
		
		}
	}
