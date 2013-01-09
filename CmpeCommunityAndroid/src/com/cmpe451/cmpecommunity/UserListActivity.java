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

public class UserListActivity extends ListActivity{
	private UserAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_view);

		adapter = new UserAdapter(this, R.layout.user_item);

		new HttpTask().execute(getIntent().getExtras().getString("Path"));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		StaticUser.chosenUser = adapter.getItem(position);

		Intent i = new Intent(this, HomeActivity.class);
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
			UserListActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(UserListActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				JSONArray users = json.getJSONArray("users");

				for(int i=0; i<users.length(); ++i) 
				{
					JSONObject user = users.getJSONObject(i);
					adapter.add(new User(user.getInt("id"), user.getString("name"), user.getString("profile_image")));
				}

				UserListActivity.this.setListAdapter(adapter);
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}

}
