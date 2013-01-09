package com.cmpe451.cmpecommunity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class HomeActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(StaticUser.chosenUser.getName());
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
		eventsTab.setContent(new Intent(this, EventsActivity.class));

		tabHost.addTab(profileTab);
		tabHost.addTab(tagsTab);
		tabHost.addTab(eventsTab);

		tabHost.setOnTabChangedListener(new OnTabChangeListener() {

			public void onTabChanged(String tabId) {
				if(getCurrentFocus() != null)
					((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
			}
		});
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
		Intent i;
		switch (item.getItemId()) {
		case R.id.home:
			StaticUser.chosenUser = StaticUser.currentUser;
			i = new Intent(getApplicationContext(), HomeActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
			return true;
		case R.id.logout:
			StaticUser.currentUser = null;
			i = new Intent(getApplicationContext(), LoginActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
