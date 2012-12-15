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

public class TagListActivity extends ListActivity{
	private TagAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tag_view);

		adapter = new TagAdapter(this, R.layout.tag_item);

		new HttpTask().execute();
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		StaticUser.chosenTag = adapter.getItem(position);
		Intent i = new Intent(this, TagActivity.class);
		startActivity(i);
	}

	final class HttpTask extends AsyncTask<Void, Boolean, String> {
		@Override
		protected String doInBackground(Void... param) {
			publishProgress(true);

			// Creating HTTP client
			HttpClient httpClient = new DefaultHttpClient();

			// Creating HTTP Post
			HttpPost httpPost = new HttpPost("http://192.168.150.225:8082/CmpeCommunityWeb/AndroidApi/tags");


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
			TagListActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(TagListActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				JSONArray tags = json.getJSONArray("tags");
				
				for(int i=0; i<tags.length(); ++i) 
				{
					JSONObject tag = tags.getJSONObject(i);
					adapter.add(new Tag(tag.getInt("id"), tag.getString("tag")));
				}

				TagListActivity.this.setListAdapter(adapter);
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}

}
