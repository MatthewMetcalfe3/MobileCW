/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff.listner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
//import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import org.me.myandroidstuff.PlannedRoadworks;
import org.me.myandroidstuff.data.RssItem;

public class ListListner implements OnItemClickListener {

	List<RssItem> listItems;

	Activity activity;

	public ListListner(List<RssItem> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity = anActivity;
	}

	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {		
	
		
	
		RssItem item = listItems.get(pos);
		String display = "";
		display = item.getDescription();
		display = removeBr(display);
	
		String[] myArray = display.split(" ");

		String startDate = (myArray[3] + " " + myArray[4] + " " + myArray[5]);
		String endDate = (myArray[10] + " " + myArray[11] + " " + myArray[12]);
		String bothDates = ("Start Date : " + startDate +   "\n End Date : " + endDate);

		

		Toast.makeText(activity, bothDates, Toast.LENGTH_SHORT).show();
		new AlertDialog.Builder(activity).setTitle("Extra Information")
				.setMessage(display)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						dialog.cancel();
					}
				}).show();
	}

	private String removeBr(String str1) {
		str1 = str1.replaceAll(">br /<", "");
		str1 = str1.replaceAll(">br/<", "");
		str1 = str1.replaceAll("<br />", "");
		str1 = str1.replaceAll(">/p<", "");
		str1 = str1.replaceAll(">p<", "");
		str1 = str1.replaceAll("<p>", "");
		str1 = str1.replaceAll("</p>", "");
		str1 = str1.replaceAll("&nbsp;", "");
		str1 = str1.replaceAll("<br/>", "");
		return str1;
	}


}
