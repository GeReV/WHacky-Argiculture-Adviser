package AgriculureWeather.Display;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class AgricultureWeatherActivity extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ((Button) findViewById(R.id.ButtonIRScan)).setWidth(ScreenWidth()/2);
        ((Button) findViewById(R.id.ButtonCheckField)).setWidth(ScreenWidth()/2);

        
        ((Button) findViewById(R.id.ButtonIRScan)).setOnClickListener(this);
        ((Button) findViewById(R.id.ButtonCheckField)).setOnClickListener(this);

//        ((Button) findViewById(R.id.ButtonIRPhoto)).setOnClickListener(this);
        
        // Use the LocationManager class to obtain GPS locations */

//        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//
//        LocationListener mlocListener = new MyLocationListener();
//
//
//        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
//

        
    }
    
    private int ScreenWidth() 
    {
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        String width=""+dm.widthPixels;
        return Integer.parseInt(width);
}

    
//    @Override
//    	  public boolean onCreateOptionsMenu(Menu menu) 
//    {  
//    	    //menu.add(group1Id,searchBtnId ,searchBtnId,"Search");   
//    	    // the following line will hide search   
//    	    // when we turn the 2nd parameter to false  
//    	    //menu.setGroupVisible(1, false);  
//    	    return super.onCreateOptionsMenu(menu);  
//    	  } 
    
    
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.ButtonCheckField:
//            //activities to create a new account
//            //startActivity(new Intent(this, Prefs.class));
//
//
//
//                //addSaver("String");
//                return true;
//            case R.id.ButtonIRPhoto:
//                Intent i = new Intent(AgricultureWeatherActivity.this, plantcameracapture.class);
//                startActivity(i);
//                return true;
//        // More items go here (if any) ...
//        }
//        return false;
//    }

    
    
    
    

// // Acquire a reference to the system Location Manager
//    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//    Location _location = null;
//    // Define a listener that responds to location updates
//    public class MyLocationListener implements LocationListener
//
//    {
//
//    @Override
//
//    public void onLocationChanged(Location loc)
//
//    {
//
//    loc.getLatitude();
//
//    loc.getLongitude();
//
//    String Text = "My current location is: " +
//
//    "Latitud = " + loc.getLatitude() +
//
//    "Longitud = " + loc.getLongitude();
//
//
//    Toast.makeText( getApplicationContext(),
//
//    Text,
//
//    Toast.LENGTH_SHORT).show();
//
//    }
//
//
//    @Override
//
//    public void onProviderDisabled(String provider)
//
//    {
//
//    Toast.makeText( getApplicationContext(),
//
//    "Gps Disabled",
//
//    Toast.LENGTH_SHORT ).show();
//
//    }
//
//
//    @Override
//
//    public void onProviderEnabled(String provider)
//
//    {
//
//    Toast.makeText( getApplicationContext(),
//
//    "Gps Enabled",
//
//    Toast.LENGTH_SHORT).show();
//
//    }
//
//
//    @Override
//
//    public void onStatusChanged(String provider, int status, Bundle extras)
//
//    {
//
//
//    }
//
//    }/* End of Class MyLocationListener */
//
//    /* End of UseGps Activity */
//
//    // Register the listener with the Location Manager to receive location updates
//    
//    
//    
    
//    
	//@Override
	public void onClick(View v) 
	{
    	switch(v.getId())
    	{
    	case R.id.ButtonCheckField:
//    		_location = null;
//    		//locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//    		while(_location == null)
//    		{}
    		Random generator = new Random();
    		double latid = 38.281301 + generator.nextInt(2) + 1; //_location.getLatitude();
    		double longit = 53.876953 + generator.nextInt(2) + 1;; //_location.getLongitude();
    		
    		//String textP = latid +","+ longit; 
        	//String TextMsg = �My current location is: latid = � + latid + longit = � + longit;

    		//http://maps.google.com/maps?q=%D7%AA%D7%9C+%D7%90%D7%91%D7%99%D7%91&hl=en&ie=UTF8&ll=31.936822,34.738287&spn=0.005253,0.010568&sll=37.0625,-95.677068&sspn=38.281301,53.876953&vpsrc=6&hnear=Tel+Aviv,+Israel&t=k&z=17
        	//Toast.makeText( getApplicationContext(), textP,  Toast.LENGTH_SHORT).show();
    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.43.60/weather/?lat="+latid + "&long=" +longit));
    		startActivity(browserIntent);
////        	String userName = ((EditText)findViewById(R.id.editTextUserName)).getText().toString();
////    		String userID = ((EditText)findViewById(R.id.editTextUserID)).getText().toString();
////    		String password =  ((EditText)findViewById(R.id.editTextPassword)).getText().toString();
////
////    		if(_gradesConfig == null)
////    		{
////    			_gradesConfig = new GradesConfig(userName,userID,password);
////    		}
////    		else
////    		{
////    			if (!_gradesConfig.UserName.equalsIgnoreCase(userName) || !_gradesConfig.UserID.equalsIgnoreCase(userID))
////    				_gradesConfig.GradesList = new GradesCollection();
////    		}
////    		
////    		_gradesConfig.UserName = userName;
////    		_gradesConfig.UserID = userID;
////    		_gradesConfig.Password = password;
////    		
////    		_gradesConfig.SaveToMachine();
////    		GradesUtilMethods.SetAlarm(this, _gradesConfig, true);
//
//    		break;
    	case R.id.ButtonIRScan:
    		Intent myIntent = new Intent(AgricultureWeatherActivity.this,plantcameracapture.class);

    		AgricultureWeatherActivity.this.startActivity(myIntent); 
    		//GradesUtilMethods.StopAlarm(this);
    		break;
    	}
	}
}
//    
