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
public class EventsActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events);

		TabHost tabHost = getTabHost();
		Intent i;
		Bundle b = new Bundle();

		// Attended Events Tab
		i = new Intent(this, EventListActivity.class);
		b.putString("EventType", "attendedEvents");
		i.putExtras(b); 

		TabSpec newsFeedTab = tabHost.newTabSpec("Attending Events");	
		newsFeedTab.setContent(i);
		newsFeedTab.setIndicator("Attending Events");

		// My Events tab
		i = new Intent(this, EventListActivity.class);
		b.putString("EventType", "myEvents");
		i.putExtras(b); 

		TabSpec wallTab = tabHost.newTabSpec("My Events");
		wallTab.setIndicator("My Events");
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
