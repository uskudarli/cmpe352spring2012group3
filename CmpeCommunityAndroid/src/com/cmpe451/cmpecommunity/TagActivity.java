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
public class TagActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabview);

		setTitle(StaticUser.chosenTag.getTag());

		TabHost tabHost = getTabHost();

		Intent i;
		Bundle b;

		// Wall tab
		i = new Intent(this, FeedActivity.class);
		b = new Bundle();
		b.putString("FeedType", "tagWall");
		b.putBoolean("TagPage", true);
		i.putExtras(b); 

		TabSpec wallTab = tabHost.newTabSpec("Wall");
		wallTab.setIndicator("Wall");
		wallTab.setContent(i);

		// Users Tab	
		i = new Intent(this, UserListActivity.class);
		b = new Bundle();
		b.putString("Path", "tagUsers/" + StaticUser.chosenTag.getId());
		i.putExtras(b); 

		TabSpec usersTab = tabHost.newTabSpec("Users");	
		usersTab.setContent(i);
		usersTab.setIndicator("Users");

		// add tabs
		tabHost.addTab(wallTab);
		tabHost.addTab(usersTab);

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
