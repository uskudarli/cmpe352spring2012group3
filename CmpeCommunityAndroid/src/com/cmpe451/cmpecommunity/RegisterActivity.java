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

public class RegisterActivity extends Activity {

	private EditText firstnameText, lastnameText, emailText, passwordText, passwordRepeatText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set View to register.xml
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);  
		setContentView(R.layout.register);

		firstnameText = (EditText) findViewById(R.id.reg_name);
		lastnameText = (EditText) findViewById(R.id.reg_lastname);
		emailText = (EditText) findViewById(R.id.reg_email);
		passwordText = (EditText) findViewById(R.id.reg_password);
		passwordRepeatText = (EditText) findViewById(R.id.reg_passwordrepeat);

		TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
		// Listening to Login Screen link
		loginScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Switching to Login Screen/closing register screen
				finish();
			}
		});


		Button registerButton = (Button) findViewById(R.id.btnRegister);
		registerButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				if(!passwordText.getText().toString().equals(passwordRepeatText.getText().toString()))
				{
					Toast.makeText(RegisterActivity.this, "Password fields do not match! Please try again.", Toast.LENGTH_SHORT).show();
					return;
				}

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
			HttpPost httpPost = new HttpPost("http://192.168.0.11:8082/CmpeCommunityWeb/AndroidApi/register");

			// Building post parameters, key and value pair
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);

			nameValuePair.add(new BasicNameValuePair("name", firstnameText.getText().toString()));
			nameValuePair.add(new BasicNameValuePair("last_name", lastnameText.getText().toString()));
			nameValuePair.add(new BasicNameValuePair("email", emailText.getText().toString()));
			nameValuePair.add(new BasicNameValuePair("password", passwordText.getText().toString()));

			try {

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
			RegisterActivity.this.setProgressBarIndeterminateVisibility(progress[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			publishProgress(false);

			if(result == null)
			{
				Toast.makeText(RegisterActivity.this, "Server connection error!", Toast.LENGTH_SHORT).show();
				return;
			}

			try
			{
				JSONObject json = new JSONObject(result);

				if(json.getBoolean("success"))
				{
					Toast.makeText(RegisterActivity.this, "Your registration is successful. Thank you for joining us.", Toast.LENGTH_SHORT).show();
					finish();
					Intent i = new Intent(getApplicationContext(), LoginActivity.class);
					startActivity(i);
				}
				else
				{
					Toast.makeText(RegisterActivity.this, json.getString("error"), Toast.LENGTH_SHORT).show();
				}
			} catch (JSONException e) {
				// writing exception to log
				e.printStackTrace();
			}
		}
	}
}