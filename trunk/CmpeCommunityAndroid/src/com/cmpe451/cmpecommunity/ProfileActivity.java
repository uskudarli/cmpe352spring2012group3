package com.cmpe451.cmpecommunity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
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
		b.putBoolean("TagPage", false);
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

		for(int j=0; j<tabHost.getTabWidget().getChildCount(); ++j)
			tabHost.getTabWidget().getChildAt(j).getLayoutParams().height = 55;

		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			public void onTabChanged(String tabId) {
				if(getCurrentFocus() != null)
					((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
			}
		});
	}
}
