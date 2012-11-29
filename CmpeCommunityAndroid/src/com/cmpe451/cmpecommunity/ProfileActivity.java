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

		TabSpec newsFeedTab = tabHost.newTabSpec("News Feed");
		//newsFeedTab.setContent(R.id.newsfeed);
		newsFeedTab.setContent(new Intent(this, FeedActivity.class));
		newsFeedTab.setIndicator("News Feed");
		
		TabSpec wallTab = tabHost.newTabSpec("Wall");
		wallTab.setIndicator("Wall");
		wallTab.setContent(R.id.wall);

		tabHost.addTab(newsFeedTab);
		tabHost.addTab(wallTab);
		}
	}
