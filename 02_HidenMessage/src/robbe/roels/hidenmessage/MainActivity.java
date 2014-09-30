package robbe.roels.hidenmessage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private OnClickListener qrButtonListener;
	private MainActivity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        //init button stuffs
        qrButtonListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				IntentIntegrator integrator = new IntentIntegrator(activity);
				integrator.initiateScan();
				
				
				
			}
		};
        ((Button) findViewById(R.id.qrButton)).setOnClickListener(qrButtonListener);
        
        return true;
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    	  if (scanResult != null) {
    	    ((TextView) findViewById(R.id.textField)).setText(scanResult.getContents());
    	  }
    	}
    
    
    
}
