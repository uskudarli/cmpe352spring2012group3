package com.cmpe451.cmpecommunity;

import java.text.ChoiceFormat;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class SingleFeedActivity extends ListActivity{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_view);
		
		TextView nameText = (TextView) findViewById(R.id.name);
		nameText.setText(User.chosenFeed.getOwnerName());
		TextView contentText = (TextView) findViewById(R.id.content);
		contentText.setText(User.chosenFeed.getContent());
		TextView postingTimeText = (TextView) findViewById(R.id.posting_time);
		postingTimeText.setText(User.chosenFeed.getPostingTime());
	
		ReplyAdapter adapter = new ReplyAdapter(this, R.layout.reply_item);
		adapter.addAll(User.chosenFeed.getReplies());
		
		//adapter.add(new Feed(feed.getInt("id"), feed.getString("owner_name"), feed.getInt("owner_id"), feed.getString("content"), feed.getString("posting_time")));
		
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	        
	}
}
