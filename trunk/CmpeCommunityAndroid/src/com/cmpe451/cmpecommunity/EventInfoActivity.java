package com.cmpe451.cmpecommunity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class EventInfoActivity extends Activity{

	ReplyAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_view);

		TextView placeText = (TextView) findViewById(R.id.place);
		placeText.setText(StaticUser.chosenEvent.getPlace());
		TextView nameText = (TextView) findViewById(R.id.name);
		nameText.setText(StaticUser.chosenEvent.getOwnerName());
		TextView descriptionText = (TextView) findViewById(R.id.description);
		descriptionText.setText(StaticUser.chosenEvent.getDescription());
		TextView dateText = (TextView) findViewById(R.id.date);
		dateText.setText(StaticUser.chosenEvent.getTime());

		nameText.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				StaticUser.chosenUser = new User(StaticUser.chosenEvent.getOwnerId(), StaticUser.chosenEvent.getOwnerName(), "URL");
				startActivity(new Intent(EventInfoActivity.this, HomeActivity.class));
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
