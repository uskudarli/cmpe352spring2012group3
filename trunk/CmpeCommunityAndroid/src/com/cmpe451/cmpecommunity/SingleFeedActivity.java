package com.cmpe451.cmpecommunity;

import java.io.IOException;
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
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class SingleFeedActivity extends ListActivity{

	ReplyAdapter adapter;
	
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

		adapter = new ReplyAdapter(this, R.layout.reply_item);
		for(Reply reply : StaticUser.chosenFeed.getReplies())
			adapter.add(reply);

		setListAdapter(adapter);
		
		final EditText replyText = (EditText) findViewById(R.id.replyText);
		replyText.setOnEditorActionListener(new OnEditorActionListener() {
		    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		        if (actionId == EditorInfo.IME_ACTION_SEND) {
		        	new HttpTask().execute(replyText.getText().toString());
		            return false;
		        }
		        return false;
		    }
		});
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
	
	final class HttpTask extends AsyncTask<String, Boolean, String> {
		private String reply;
		
		@Override
		protected String doInBackground(String... param) {
		    publishProgress(true);

		    reply = param[0];
		    
			// Creating HTTP client
			HttpClient httpClient = new DefaultHttpClient();

			// Creating HTTP Post
			HttpPost httpPost = new HttpPost(StaticUser.URL + "/CmpeCommunityWeb/AndroidApi/reply/" + StaticUser.chosenFeed.getId());

			// Url Encoding the POST parameters
			try {
				List<NameValuePair> nameValuePair = StaticUser.GetNameValuePair();
				nameValuePair.add(new BasicNameValuePair("body", reply));
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
			SingleFeedActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(SingleFeedActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				if(json.getBoolean("success"))
				{
					adapter.add(new Reply(StaticUser.currentUser.getName(), StaticUser.currentUser.getId(), reply, "now"));
					EditText replyText = (EditText) findViewById(R.id.replyText);
					replyText.setText("");
				}
				else
				{
					Toast.makeText(SingleFeedActivity.this, json.getString("error"), Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}
}
