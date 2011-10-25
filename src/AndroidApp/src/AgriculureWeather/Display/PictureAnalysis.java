package AgriculureWeather.Display;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;



public class PictureAnalysis extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pictureanalysis);
        
//        ((Button) findViewById(R.id.ButtonCheckField)).setOnClickListener(this);
//        ((Button) findViewById(R.id.ButtonIRScan)).setOnClickListener(this);

        ImageView d = (ImageView) findViewById(R.id.imageViewPic);
		
        File root = Environment.getExternalStorageDirectory();
		File dir = new File(root.getAbsolutePath()+"/testApp");
		File dataFile = new File(dir,"pic.jpg");
        
		String myJpgPath = dataFile.getAbsolutePath();// "/sdcard/pic.JPG"; //UPDATE WITH YOUR OWN JPG FILE


        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);
        d.setImageBitmap(bm); 
    }
    
// // This filter removes all but the red values in an image
//    class GetRedFilter extends RGBImageFilter {
//        public GetRedFilter() {
//            // When this is set to true, the filter will work with images
//            // whose pixels are indices into a color table (IndexColorModel).
//            // In such a case, the color values in the color table are filtered.
//            canFilterIndexColorModel = true;
//        }
//
//        // This method is called for every pixel in the image
//        public int filterRGB(int x, int y, int rgb) {
//            if (x == -1) {
//                // The pixel value is from the image's color table rather than the image itself
//            }
//            // Return only the red component
//            return rgb & 0xffff0000;
//        }
//    }
    
    
    
	public static String LoadFromHD()
	{
		String xmlStr = "";
		File root = Environment.getExternalStorageDirectory();
		File dir = new File(root.getAbsolutePath()+"/testApp");
		File dataFile = new File(dir,"DataFile.txt");
		if (!dataFile.exists())
			return null;
		try
		{
			StringBuffer fileData = new StringBuffer(1000);
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			char[] buf = new char[1024];
			int numRead=0;
			while((numRead=reader.read(buf)) != -1){
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			reader.close();
			xmlStr = fileData.toString();
		}
		catch (Exception ex)
		{
			xmlStr = "";
		}
		return xmlStr;
	}

    

	public void onClick(View v) 
	{
    	switch(v.getId())
    	{
    	case R.id.ButtonCheckField:
//    		_location = null;
//    		//locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//    		while(_location == null)
//    		{}
    		double latid = 38.281301; //_location.getLatitude();
    		double longit = 53.876953; //_location.getLongitude();
    		
    		//String textP = latid +","+ longit; 
        	//String TextMsg = �My current location is: latid = � + latid + longit = � + longit;

    		//http://maps.google.com/maps?q=%D7%AA%D7%9C+%D7%90%D7%91%D7%99%D7%91&hl=en&ie=UTF8&ll=31.936822,34.738287&spn=0.005253,0.010568&sll=37.0625,-95.677068&sspn=38.281301,53.876953&vpsrc=6&hnear=Tel+Aviv,+Israel&t=k&z=17
        	//Toast.makeText( getApplicationContext(), textP,  Toast.LENGTH_SHORT).show();
    		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aspspider.info/weather/?lat="+latid + "&long=" +longit));
    		startActivity(browserIntent);

//
   		break;
    	case R.id.ButtonIRScan:
    		//Intent myIntent = new Intent(AgricultureWeatherActivity.this,plantcameracapture.class);

    		//AgricultureWeatherActivity.this.startActivity(myIntent); 
    		//GradesUtilMethods.StopAlarm(this);
    		break;
    	}
	}
}
//    
