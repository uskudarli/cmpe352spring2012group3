package com.cmpe451.cmpecommunity;

import android.app.ListActivity;
import android.os.Bundle;

public class FeedActivity extends ListActivity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feed_view);
		 
		FeedAdapter adapter = new FeedAdapter(this, R.layout.feed_item);

		adapter.add(new Feed("Joey Tribbiani", "How you doin'?"));
		adapter.add(new Feed("Emre Süneçli", "I can't help myself post another text here."));
		adapter.add(new Feed("Alper Güngörmüþler", "Finally got it!"));
		adapter.add(new Feed("Çiðdem Koçberber", "Hey there!"));
		adapter.add(new Feed("Alper Güngörmüþler", "What is there to do?"));
		adapter.add(new Feed("Erdem Orman", "You probably won't even see this!"));
		
		
		setListAdapter(adapter);
		
	}

}
