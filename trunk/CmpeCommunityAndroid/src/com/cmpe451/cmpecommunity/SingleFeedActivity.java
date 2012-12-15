package com.cmpe451.cmpecommunity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
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
				startActivity(new Intent(SingleFeedActivity.this, HomeActivity.class));
			}
		});
		
		ReplyAdapter adapter = new ReplyAdapter(this, R.layout.reply_item);
		adapter.addAll(StaticUser.chosenFeed.getReplies());
	
		setListAdapter(adapter);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        
	}
}
