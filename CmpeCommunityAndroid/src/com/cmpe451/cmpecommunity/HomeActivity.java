package com.cmpe451.cmpecommunity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		Button logoutButton = (Button) findViewById(R.id.logout);
		// Listening to register new account link
		logoutButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				finish();
				
				Intent i = new Intent(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		});

	}
}
