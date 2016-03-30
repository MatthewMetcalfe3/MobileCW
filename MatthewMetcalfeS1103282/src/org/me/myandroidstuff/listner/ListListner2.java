/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff.listner;

import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import org.me.myandroidstuff.data.RssItem;

public class ListListner2 implements OnItemClickListener {

	List<RssItem> listItems;

	Activity activity;

	public ListListner2(List<RssItem> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity = anActivity;
	}

	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {		
	
		
	
		RssItem item = listItems.get(pos);
		String display = "";
		display = item.getDescription();

		display = removeBr(display);


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
