/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff.util;

import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.me.myandroidstuff.data.RssItem;

public class RssReader {
	private String rssUrl;

	public RssReader(String rssUrl) {
		this.rssUrl = rssUrl;
	}

	public List<RssItem> getItems() throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		RssParseHandler handler = new RssParseHandler();
		saxParser.parse(rssUrl, handler);
		return handler.getItems();
	}
}