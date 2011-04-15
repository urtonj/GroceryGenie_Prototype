package com.groceryadvance.grocerygeine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

	EditText Username;
	EditText Password;
	Button LoginButton;
	Button CreateLogin;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Username = (EditText) findViewById(R.id.Username);
		Password = (EditText) findViewById(R.id.Password);

		LoginButton = (Button) findViewById(R.id.LoginButton);
		CreateLogin = (Button) findViewById(R.id.CreateLogin);
		
		Button cancel = (Button) findViewById(R.id.cancel);
/*		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(getApplicationContext(), Login.class);
				startActivity(myIntent);
				
			}
		});*/
		
		// Button next = (Button) findViewById(R.id.Button01);
		CreateLogin.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(),
						CreateAccount.class);
				startActivityForResult(myIntent, 0);
			}
		});
		
		LoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(view.getContext(),
						Lists.class);
				startActivity(myIntent);				
			}
		});
	}
}
