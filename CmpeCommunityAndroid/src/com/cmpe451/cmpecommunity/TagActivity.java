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
