package com.groceryadvance.grocerygeine;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class GroceryList extends Activity {
    /** Called when the activity is first created. */
	List<GroceryListItem> GroceryList;
	GroceryListAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grocery_list);
        
        ListView list = (ListView)findViewById(R.id.ListView01);
        
        GroceryList = new ArrayList<GroceryListItem>();
        GroceryList.add(new GroceryListItem("Eggs", "12"));
        GroceryList.add(new GroceryListItem("Butter", "1"));
        GroceryList.add(new GroceryListItem("Ham", "1"));
        GroceryList.add(new GroceryListItem("Swiss cheese", "1"));
        GroceryList.add(new GroceryListItem("Wine", "2"));
        GroceryList.add(new GroceryListItem("Bread", "1"));
        GroceryList.add(new GroceryListItem("Apples", "5"));
        GroceryList.add(new GroceryListItem("Tomatoes", "3"));
        GroceryList.add(new GroceryListItem("Chicken soup", "2"));
        
        adapter = new GroceryListAdapter(this, GroceryList);
        
        list.setAdapter(adapter);
        
        Button add = (Button) findViewById(R.id.plus);
        add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { addItem(); }
		});
        
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { deleteList(); }
		});  

        Button share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { shareList(); }
		});
        
        Button back = (Button) findViewById(R.id.home_back);
        back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) { 
				Intent i = new Intent(getApplicationContext(), Lists.class);
				startActivity(i);
			}
		});
        
    }
    
    private void addItem() {
    	
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);
    	alert.setTitle("Add an Item"); alert.setMessage("Name:");
    	final EditText input = new EditText(this);
    	alert.setView(input);
    	//InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    	///imm.showSoftInput(input, 0);
    	
    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    			String value = input.getText().toString();
    			GroceryList.add(new GroceryListItem(value, "1"));
    			adapter.notifyDataSetChanged();
       		}
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {}
    	});
    	alert.show();
    }
    
    private void deleteList() {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);
    	alert.setTitle("Are you sure you want to delete this list?"); 
    	alert.setMessage("This cannot be undone!");
    	alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    			Intent i = new Intent(getApplicationContext(), Lists.class);
    			startActivity(i);
       		}
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {}
    	});
    	alert.show();
    }
    
    private void shareList() {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);
    	alert.setTitle("Who would you like to share this list with?"); 
    	alert.setMessage("Enter email addresses below.");
    	final EditText input = new EditText(this);
    	alert.setView(input);

    	alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    			String value = input.getText().toString();
    			shared(value);
       		}
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {}
    	});
    	alert.show();
    }
    
    private void shared(String name) {
    	Toast.makeText(this, "List successfully shared with " + name + "!", 
    			Toast.LENGTH_LONG).show();
    }
    
}