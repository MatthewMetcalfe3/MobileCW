/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff;

import org.me.myandroidstuff.data.RssItem;
import org.me.myandroidstuff.listner.ListListner;
import org.me.myandroidstuff.util.RssReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import android.widget.ArrayAdapter;

import android.widget.ListView;


public class CurrentRoadworks extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.currentroadworks_layout);
	
		try {
			
			RssReader rssReader = new RssReader(
					"http://www.trafficscotland.org/rss/feeds/roadworks.aspx");
			ListView Items = (ListView) findViewById(R.id.listView1);
			// create list adapet
			ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(this,
					R.layout.custom_layout, rssReader.getItems());
			// set list adapter ofor listview
			Items.setAdapter(adapter);
			// set list view item click listner
			Items.setOnItemClickListener(new ListListner(rssReader.getItems(),
					this));
		} catch (Exception e) {
			Log.e("TrafficRssReader", e.getMessage());
		}


	}
}
