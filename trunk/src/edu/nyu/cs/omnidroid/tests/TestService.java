package edu.nyu.cs.omnidroid.tests;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.nyu.cs.omnidroid.R;

public class TestService extends Activity {
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      setContentView(R.layout.test_service);

      Button button = (Button) findViewById(R.id.test_service_br);
      button.setOnClickListener(BRListener);
      // OmLogger.write("Starting Backgnd Service");
      // Intent intentBR=new Intent("",null,this,com.OmniBR.BRService.class);\

    } catch (Exception e) {
      Log.i("Exception", e.getLocalizedMessage());

    }
  }

  private OnClickListener BRListener = new OnClickListener() {
    public void onClick(View v) {
      // To be deleted from this code

      // Call to start the BR
      // ComponentName comp = new ComponentName(this.getClass().getPackage().getName(),
      // BRService.class.getName());
      // startService(new Intent().setComponent(comp));

      Intent intentBR = new Intent();
      intentBR.setClassName("edu.nyu.cs.omnidroid", "edu.nyu.cs.omnidroid.bkgservice.BRService");
      startService(intentBR);
      Intent intent = new Intent("SMS_RECEIVED");
      sendBroadcast(intent);

    }
  };
}