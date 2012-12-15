package com.cmpe451.cmpecommunity;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText emailText, passwordText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);  
		setContentView(R.layout.login);

		emailText = (EditText) findViewById(R.id.email);
		passwordText = (EditText) findViewById(R.id.password);

		TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
		// Listening to register new account link
		registerScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});


		Button loginButton = (Button) findViewById(R.id.btnLogin);
		loginButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				new HttpTask().execute();

			}
		});
	}

	final class HttpTask extends AsyncTask<Void, Boolean, String> {
		@Override
		protected String doInBackground(Void... param) {
		    publishProgress(true);

			// Creating HTTP client
			HttpClient httpClient = new DefaultHttpClient();

			// Creating HTTP Post
			HttpPost httpPost = new HttpPost("http://192.168.150.225:8082/CmpeCommunityWeb/AndroidApi/login");

			// Building post parameters, key and value pair
			StaticUser.email = "emresunecli@gmail.com"; //emailText.getText().toString();
			StaticUser.password = "123456"; //passwordText.getText().toString();

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
			LoginActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(LoginActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				if(json.getBoolean("success"))
				{
					StaticUser.id = json.getInt("id");
					StaticUser.name = json.getString("name");
							
					Intent i = new Intent(getApplicationContext(), HomeActivity.class);
					startActivity(i);
				}
				else
				{
					Toast.makeText(LoginActivity.this, json.getString("error"), Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}
}