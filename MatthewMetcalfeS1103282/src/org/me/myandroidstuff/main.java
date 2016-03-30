/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff;

import android.app.TabActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class main extends TabActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TabHost tabHost = getTabHost();

		// Tab for Current Incidents
		TabSpec currentIncidentsspec = tabHost.newTabSpec("currentIncidents");
		// setting Title for the Tab
		currentIncidentsspec.setIndicator("Current Incidents", getResources()
				.getDrawable(R.drawable.cone));
		Intent currentIncidentsIntent = new Intent(this, CurrentIncidents.class);
		currentIncidentsspec.setContent(currentIncidentsIntent);

		// Tab for Current Roadworks
		TabSpec currentRoadworksspec = tabHost.newTabSpec("currentRoadworks");
		currentRoadworksspec.setIndicator("Current Roadworks", getResources()
				.getDrawable(R.drawable.trafficlight));
		Intent currentRoadworksIntent = new Intent(this, CurrentRoadworks.class);
		currentRoadworksspec.setContent(currentRoadworksIntent);

		// Tab for Planned Roadworks
		TabSpec plannedRoadworksspec = tabHost.newTabSpec("plannedRoadwork");
		plannedRoadworksspec.setIndicator("Planned Roadworks", getResources()
				.getDrawable(R.drawable.car));
		Intent plannedRoadworksIntent = new Intent(this, PlannedRoadworks.class);
		plannedRoadworksspec.setContent(plannedRoadworksIntent);

		// Adding all TabSpec to TabHost
		tabHost.addTab(currentIncidentsspec);
		tabHost.addTab(currentRoadworksspec);
		tabHost.addTab(plannedRoadworksspec);

	}
}