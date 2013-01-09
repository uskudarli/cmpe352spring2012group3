package com.cmpe451.cmpecommunity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class FeedActivity extends ListActivity{
	private FeedAdapter adapter;

	String path;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);

		adapter = new FeedAdapter(this, R.layout.feed_item);

		path = getIntent().getExtras().getString("FeedType");
		if(path.equalsIgnoreCase("wall") || path.equalsIgnoreCase("tagWall"))
		{
			EditText postText = (EditText) findViewById(R.id.postText);
			postText.setVisibility(View.VISIBLE);

			if(getIntent().getExtras().getBoolean("TagPage"))
			{
				postText.setHint("@" + StaticUser.chosenTag.getTag());
			}
			else if(StaticUser.chosenUser.getId() != StaticUser.currentUser.getId())
				postText.setHint("@" + StaticUser.chosenUser.getName());
		}

		if(getIntent().getExtras().getBoolean("TagPage")) 
			path += "/" + StaticUser.chosenTag.getId();
		else
			path += "/" + StaticUser.chosenUser.getId(); 

		final EditText postText = (EditText) findViewById(R.id.postText);
		postText.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					new PostTask().execute(postText.getText().toString());
					((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
					return false;
				}
				return false;
			}
		});

		new HttpTask().execute(path);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		StaticUser.chosenFeed = adapter.getItem(position);
		Intent i = new Intent(this, SingleFeedActivity.class);
		startActivity(i);
	}


	final class HttpTask extends AsyncTask<String, Boolean, String> {
		@Override
		protected String doInBackground(String... param) {
			publishProgress(true);

			// Creating HTTP client
			HttpClient httpClient = new DefaultHttpClient();

			// Creating HTTP Post
			HttpPost httpPost = new HttpPost(StaticUser.URL + "/CmpeCommunityWeb/AndroidApi/" + param[0]);


			// Url Encoding the POST parameters
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(StaticUser.GetNameValuePair()));

				// Making HTTP Request
				HttpResponse response = httpClient.execute(httpPost);

				return EntityUtils.toString(response.getEntity());

			} catch (ClientProtocolException e) {
				// writing exception to log
				e.printStackTrace();

			} catch (IOException e) {
				// writing exception to log
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onProgressUpdate(Boolean... progress) {
			FeedActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(FeedActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				JSONArray jsonFeeds = json.getJSONArray("posts");

				for(int i=0; i<jsonFeeds.length(); ++i) 
				{
					JSONObject jsonFeed = jsonFeeds.getJSONObject(i);
					Feed feed = new Feed(jsonFeed.getInt("id"), jsonFeed.getString("owner_name"), jsonFeed.getInt("owner_id"), jsonFeed.getString("content"), jsonFeed.getString("posting_time"));

					ArrayList<Reply> replies = new ArrayList<Reply>();
					JSONArray jsonReplies = jsonFeed.getJSONArray("replies");
					for(int j=0; j<jsonReplies.length(); ++j)
					{
						JSONObject jsonReply = jsonReplies.getJSONObject(j);
						replies.add(new Reply(jsonReply.getString("name"), jsonReply.getInt("owner_id"), jsonReply.getString("content"), jsonReply.getString("posting_time")));
					}
					feed.setReplies(replies);
					adapter.add(feed);
				}

				FeedActivity.this.setListAdapter(adapter);
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}

	final class PostTask extends AsyncTask<String, Boolean, String> {
		private String post;

		@Override
		protected String doInBackground(String... param) {
			publishProgress(true);

			post = param[0];

			// Creating HTTP client
			HttpClient httpClient = new DefaultHttpClient();

			// Creating HTTP Post
			String function = getIntent().getExtras().getBoolean("TagPage") ? "ToTag/" + StaticUser.chosenTag.getId() : "ToUser/" + StaticUser.chosenUser.getId();
			HttpPost httpPost = new HttpPost(StaticUser.URL + "/CmpeCommunityWeb/AndroidApi/post" + function);

			// Url Encoding the POST parameters
			try {
				List<NameValuePair> nameValuePair = StaticUser.GetNameValuePair();
				nameValuePair.add(new BasicNameValuePair("body", post));
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

				// Making HTTP Request
				HttpResponse response = httpClient.execute(httpPost);

				return EntityUtils.toString(response.getEntity());

			} catch (ClientProtocolException e) {
				// writing exception to log
				e.printStackTrace();

			} catch (IOException e) {
				// writing exception to log
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onProgressUpdate(Boolean... progress) {
			FeedActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(FeedActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				if(json.getBoolean("success"))
				{
					Feed feed = new Feed(0, StaticUser.currentUser.getName(), StaticUser.currentUser.getId(), post, "now");
					feed.setReplies(new ArrayList<Reply>());
					adapter.insert(feed, 0);

					EditText postText = (EditText) findViewById(R.id.postText);
					postText.setText("");
				}
				else
				{
					Toast.makeText(FeedActivity.this, json.getString("error"), Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}

}
