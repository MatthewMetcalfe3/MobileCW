/*
 * Trafic scotland RSS viewer
 * Code by Matthew Metcalfe S1103282
 */
package org.me.myandroidstuff.util;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.me.myandroidstuff.data.RssItem;

public class RssParseHandler extends DefaultHandler {
	private List<RssItem> rssItems;

	private RssItem currentItem;
	private boolean parsingTitle;
	private boolean parsingLink;
	private boolean parsingDate;
	private boolean parsingDescription;

	public RssParseHandler() {
		rssItems = new ArrayList<RssItem>();
	}

	public List<RssItem> getItems() {
		return rssItems;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("item".equals(qName)) {
			currentItem = new RssItem();
		} else if ("title".equals(qName)) {
			parsingTitle = true;
		} else if ("link".equals(qName)) {
			parsingLink = true;
		} else if ("date".equals(qName)) {
			parsingTitle = true;
		} else if ("description".equals(qName)) {
			parsingDescription = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("item".equals(qName)) {
			rssItems.add(currentItem);
			currentItem = null;
		} else if ("title".equals(qName)) {
			parsingTitle = false;
		} else if ("link".equals(qName)) {
			parsingLink = false;
		} else if ("date".equals(qName)) {
			parsingDate = false;
		} else if ("description".equals(qName)) {
			parsingDescription = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currentItem != null) {

			if (parsingTitle) {
				currentItem.setTitle(new String(ch, start, length));
			}

			if (parsingDate) {
				currentItem.setDate(new String(ch, start, length));
			}

			if (parsingLink) {
				currentItem.setLink(new String(ch, start, length));
			}

			if (parsingDescription) {
				String desc = new String(ch, start, length);

				if (currentItem.getDescription() != null) {
					String curDec = currentItem.getDescription();
					currentItem.setDescription(curDec + desc);
				} else {
					currentItem.setDescription(desc);
				}
			}
		}
	}
}
