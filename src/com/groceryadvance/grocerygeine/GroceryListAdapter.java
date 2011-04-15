package com.groceryadvance.grocerygeine;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GroceryListAdapter extends BaseAdapter implements OnClickListener {
    private Context context;
    private boolean state = false;
    private List<GroceryListItem> GroceryList;
    GroceryListItem entry;
    
    public GroceryListAdapter(Context context, List<GroceryListItem> listPhonebook) {
        this.context = context;
        this.GroceryList = listPhonebook;
    }

    public int getCount() {
        return GroceryList.size();
    }

    public Object getItem(int position) {
        return GroceryList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    
    public boolean getState() {
    	return state;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
    	entry = GroceryList.get(position);
    	
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grocery_list_row, null);
        }
        
        TextView tvContact = (TextView) convertView.findViewById(R.id.tvContact);
        tvContact.setText(entry.getName());
        tvContact.setOnClickListener(this);
        tvContact.setTag(entry);
        
        TextView quantity = (TextView) convertView.findViewById(R.id.item_quantity);
        quantity.setText(entry.getQuantity());
        quantity.setOnClickListener(this);
        quantity.setTag(entry);
        
        Button btnRemove = (Button) convertView.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(this);
        btnRemove.setTag(entry);

        return convertView;
    }
    
    private void editItem(GroceryListItem item) {

    	entry = item;
    	AlertDialog.Builder alert = new AlertDialog.Builder(context);
    	alert.setTitle("Edit item"); alert.setMessage("Name:");
    	final EditText input = new EditText(context);
    	input.setText(entry.getName());
    	alert.setView(input);

    	alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    			String value = input.getText().toString();
    			entry.setName(value);
    			notifyDataSetChanged();
       		}
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {}
    	});
    	alert.show();
    }
    
    @Override
    public void onClick(View view) {
    	boolean test = view instanceof Button;
    	Log.d("Type", String.valueOf(test));
    	if (view instanceof Button == true) { 
    		GroceryListItem entry = (GroceryListItem) view.getTag();
        	GroceryList.remove(entry);
            notifyDataSetChanged(); 
    	} 
    	else {
    		
    		GroceryListItem entry = (GroceryListItem) view.getTag();
    		editItem(entry); 
    		 
    	}
  		
    }

}
