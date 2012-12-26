package com.cmpe451.cmpecommunity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class SingleFeedActivity extends ListActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_view);

		TextView nameText = (TextView) findViewById(R.id.name);
		nameText.setText(StaticUser.chosenFeed.getOwnerName());
		TextView contentText = (TextView) findViewById(R.id.content);
		contentText.setText(StaticUser.chosenFeed.getContent());
		TextView postingTimeText = (TextView) findViewById(R.id.posting_time);
		postingTimeText.setText(StaticUser.chosenFeed.getPostingTime());

		nameText.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				StaticUser.chosenUser = new User(StaticUser.chosenFeed.getOwnerId(), StaticUser.chosenFeed.getOwnerName(), "URL");
				startActivity(new Intent(SingleFeedActivity.this, HomeActivity.class));
			}
		});

		ReplyAdapter adapter = new ReplyAdapter(this, R.layout.reply_item);
		for(Reply reply : StaticUser.chosenFeed.getReplies())
			adapter.add(reply);

		setListAdapter(adapter);

	}

	@Override 
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

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
