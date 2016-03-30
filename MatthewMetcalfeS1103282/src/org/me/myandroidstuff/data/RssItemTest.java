package org.me.myandroidstuff.data;

import junit.framework.TestCase;

public class RssItemTest extends TestCase {
	
 public void testgetTitle()
 { 
	 RssItem test = new RssItem();
	 
	 assertTrue (test.getTitle()=="test");
 }

}
