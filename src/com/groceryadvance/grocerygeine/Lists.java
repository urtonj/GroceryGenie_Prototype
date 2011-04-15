package com.groceryadvance.grocerygeine;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Lists extends Activity {
	List<ListItem> GroceryList;
	ListAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_list);
        
        ListView list = (ListView)findViewById(R.id.ListView01);
        
        GroceryList = new ArrayList<ListItem>();
        GroceryList.add(new ListItem("Weekly groceries", "12"));
        GroceryList.add(new ListItem("Noah's party", "7"));
        
        adapter = new ListAdapter(this, GroceryList);
        
        list.setAdapter(adapter);
        
        Button add = (Button) findViewById(R.id.plus);
        add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { addItem(); }
		});
        
        Button browse = (Button) findViewById(R.id.browse_circulars);
        browse.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), BrowseCirculars.class);
				startActivity(i);
			}
		});
        
        Button open = (Button) findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), GroceryList.class);
				startActivity(i);
			}
		});
        
    }
    
    private void addItem() {
    	
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);
    	alert.setTitle("Add an List"); alert.setMessage("List name:");
    	final EditText input = new EditText(this);
    	alert.setView(input);
    	//InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	///imm.showSoftInput(input, 0);
    	
    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    			String value = input.getText().toString();
    			GroceryList.add(new ListItem(value, "1"));
    			adapter.notifyDataSetChanged();
       		}
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {}
    	});
    	alert.show();
    	
    }
/*
	@Override
	public void onClick(View v) {
		Log.d("VIEW", v.getContext().toString());
		Intent i = new Intent(v.getContext(), GroceryList.class);
		startActivity(i);
		
	}
    */
}