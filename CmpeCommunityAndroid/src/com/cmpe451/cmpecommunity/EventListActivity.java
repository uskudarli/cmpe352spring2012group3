package com.cmpe451.cmpecommunity;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class EventListActivity extends ListActivity{
	private EventAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);

		adapter = new EventAdapter(this, R.layout.event_item);

		//String path = getIntent().getExtras().getString("EventType") +  "/" + StaticUser.chosenUser.getId(); 	

		new HttpTask().execute(getIntent().getExtras().getString("EventType") +  "/" + StaticUser.chosenUser.getId());

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		StaticUser.chosenEvent = adapter.getItem(position);
		Intent i = new Intent(this, SingleEventActivity.class);
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
			EventListActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(EventListActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				JSONArray jsonEvents = json.getJSONArray("events");

				for(int i=0; i<jsonEvents.length(); ++i) 
				{
					JSONObject jsonEvent = jsonEvents.getJSONObject(i);
					adapter.add(new Event(jsonEvent.getInt("id"), jsonEvent.getString("place"), jsonEvent.getString("description"), jsonEvent.getString("time"), jsonEvent.getString("owner_name"), jsonEvent.getInt("owner_id")));
				}

				EventListActivity.this.setListAdapter(adapter);
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}

}
