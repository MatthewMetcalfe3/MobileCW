/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff;

import java.util.List;

import org.me.myandroidstuff.data.RssItem;
import org.me.myandroidstuff.listner.ListListner2;
import org.me.myandroidstuff.util.RssReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentIncidents extends Activity {
	Button buttons;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.currentincidents_layout);

		try {

			final RssReader rssReader = new RssReader(
					"http://www.trafficscotland.org/rss/feeds/currentincidents.aspx");
			final ListView Items = (ListView) findViewById(R.id.listView3);
			// create list adapet
			final ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(
					this, R.layout.custom_layout, rssReader.getItems());
			// set list adapter ofor listview
			Items.setAdapter(adapter);
			// set list view item click listner
			Items.setOnItemClickListener(new ListListner2(rssReader.getItems(),
					this));

			int morethan1 = 0;

			TextView textview = (TextView) findViewById(R.id.textviewci);

			morethan1 = Items.getCount(); // Items.getLastVisiblePosition()-
											// Items.getFirstVisiblePosition();
			if (morethan1 >= 5) {
				textview.setTextColor(this.getResources()
						.getColor(R.color.redy));
			} else if (morethan1 >= 2) {
				textview.setTextColor(this.getResources().getColor(
						R.color.orangey));
			} else if (morethan1 >= 0) {
				textview.setTextColor(this.getResources().getColor(
						R.color.greeny));
			}
			buttons = (Button) findViewById(R.id.buttonloads);
			buttons.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					List<RssItem> newItems;
					try {
						newItems = rssReader.getItems();
						adapter.clear();
						adapter.addAll(newItems);
						adapter.notifyDataSetChanged();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					String toasty = "Feed Refreshed";
					Toast.makeText(CurrentIncidents.this, toasty,
							Toast.LENGTH_SHORT).show();

				}

			});

		} catch (Exception e) {
			Log.e("TrafficRssReader", e.getMessage());

		}
	}
}
