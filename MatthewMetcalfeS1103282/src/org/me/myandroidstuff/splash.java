package org.me.myandroidstuff;

import org.me.myandroidstuff.data.RssItem;
import org.me.myandroidstuff.util.RssReader;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.Intent;
 
public class splash extends Activity {
 //private ProgressBar progressBar;
 //private int progressStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
         
                    
        Thread background = new Thread() {
            public void run() {
            	  
                try {
                    
                    sleep(1*1000);
              
                    // After 1 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),main.class);
                    startActivity(i);
                    
                    //Remove activity
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        // start thread
        background.start();
         
    }
     
    @Override
    protected void onDestroy() {
         
        super.onDestroy();
         
    }
}