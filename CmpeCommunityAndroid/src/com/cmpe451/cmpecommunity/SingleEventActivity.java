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
public class SingleEventActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabview);

		setTitle(StaticUser.chosenEvent.getPlace());

		TabHost tabHost = getTabHost();

		// Event Info tab
		TabSpec wallTab = tabHost.newTabSpec("Info");
		wallTab.setIndicator("Info");
		wallTab.setContent(new Intent(this, EventInfoActivity.class));

		// Attending Users Tab	
		Intent i = new Intent(this, UserListActivity.class);
		Bundle b = new Bundle();
		b.putString("Path", "eventUsers/" + StaticUser.chosenEvent.getId());
		i.putExtras(b); 

		TabSpec usersTab = tabHost.newTabSpec("Attending Users");
		usersTab.setContent(i);
		usersTab.setIndicator("Attending Users");

		// add tabs
		tabHost.addTab(wallTab);
		tabHost.addTab(usersTab);
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
