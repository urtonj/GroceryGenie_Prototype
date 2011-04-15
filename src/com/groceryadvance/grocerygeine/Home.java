package com.groceryadvance.grocerygeine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        Button browse = (Button) findViewById(R.id.browse);
        browse.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), BrowseCirculars.class);
				startActivity(i);
			}
		});
        
        Button list = (Button) findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), GroceryList.class);
				startActivity(i);
			}
		});
	}

}
