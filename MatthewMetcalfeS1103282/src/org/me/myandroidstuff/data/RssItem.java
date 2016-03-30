/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff.data;

//the data taken to store in the arrays
public class RssItem {
	private String title;
	private String description;
	private String link;
	private String date;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {

		return title;
	
	}
}
