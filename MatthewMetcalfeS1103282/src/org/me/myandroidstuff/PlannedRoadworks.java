/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff;

import java.util.Date;
import java.util.List;

import org.me.myandroidstuff.data.RssItem;
import org.me.myandroidstuff.listner.ListListner;
import org.me.myandroidstuff.util.RssReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;


public class PlannedRoadworks extends Activity {
	String startyDate = "";
	String endyDate = "";
	Date startDate = null;
	Date endDate = null;
	Button button;
	List<RssItem> listItems;

	Activity activity;

	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plannedroadworks_layout); 
		
		//public ListListner(List<RssItem> mListItems, Activity anActivity) {
		//listItems = mListItems;
		//activity = anActivity;
		//RssItem item = listItems.get(pos);
	    //	startyDate = listItems.startDate;
	//}
	      button = (Button) findViewById(R.id.button1);
	        button.setOnClickListener(new OnClickListener() 
	        {

	            public void onClick(View v) 
	            {
	            
	            	DatePicker myDatePicker = (DatePicker) findViewById(R.id.datePicker1);
	       			int month = myDatePicker.getMonth() + 1;
                    int day = myDatePicker.getDayOfMonth();
                    int year = myDatePicker.getYear();
                    String intoast = (day+"/"+month+"/"+year);
                   
                    Toast.makeText(PlannedRoadworks.this, intoast, Toast.LENGTH_SHORT).show();
	            }

	        });
		 

		
		try {
			RssReader rssReader = new RssReader(
					"http://www.trafficscotland.org/rss/feeds/plannedroadworks.aspx");
			ListView Items = (ListView) findViewById(R.id.listView2);
			// create list adapet
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(this,	R.layout.custom_layout, rssReader.getItems());
			// set list adapter ofor listview
			Items.setAdapter(adapter);
			// set list view item click listner
			Items.setOnItemClickListener(new ListListner(rssReader.getItems(),
					this));
		} catch (Exception e) {
			Log.e("TrafficRssReader", e.getMessage());

		}}}

	

