package com.cmpe451.cmpecommunity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class ProfileActivity extends TabActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profile);
		
		TabHost tabHost = getTabHost();//=(TabHost)findViewById(R.id.tabHost);

		Intent i;
		Bundle b = new Bundle();
		
		
		// News Feed Tab
		i = new Intent(this, FeedActivity.class);
		b.putString("FeedType", "newsFeed");
		i.putExtras(b); 
			
		TabSpec newsFeedTab = tabHost.newTabSpec("News Feed");	
		newsFeedTab.setContent(i);
		newsFeedTab.setIndicator("News Feed");
		
		// Wall tab
		i = new Intent(this, FeedActivity.class);
		b.putString("FeedType", "wall");
		i.putExtras(b); 
		
		TabSpec wallTab = tabHost.newTabSpec("Wall");
		wallTab.setIndicator("Wall");
		wallTab.setContent(i);

		
		// add tabs
		tabHost.addTab(newsFeedTab);
		tabHost.addTab(wallTab);
		}
	}
