package AgriculureWeather.Display;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class plantcameracapture extends Activity {
	private static final String TAG = "CameraDemo";
	Camera camera;
	Preview preview;
	Button buttonClick;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plantcameracapture);

		preview = new Preview(this);
		((FrameLayout) findViewById(R.id.frameLayout1)).addView(preview);

		buttonClick = (Button) findViewById(R.id.buttonClick);
		buttonClick.setOnClickListener( new OnClickListener() {
			public void onClick(View v) {
				preview.camera.takePicture(shutterCallback, rawCallback, jpegCallback);
			}
		});

		Log.d(TAG, "onCreate'd");
	}

	 public static void SaveToHD(byte[] data)
	    {
	    	File root = Environment.getExternalStorageDirectory();
	    	File dir = new File(root.getAbsolutePath()+"/testApp");
	    	dir.mkdirs();
	    	File dataFile = new File(dir,"pic.jpg");
	    	if (!dataFile.exists())
	    	{
	    		try 
	    		{
					dataFile.createNewFile();
				} 
	    		catch (IOException e) 
	    		{
					e.printStackTrace();
					return;
				}
	    	}
	    	FileOutputStream fileWriter = null;
			try 
			{
				fileWriter = new FileOutputStream(dataFile);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				return;
			}
			
			try 
			{
				fileWriter.write(data);
				fileWriter.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
				return;
			}
	    }
	
	

	ShutterCallback shutterCallback = new ShutterCallback() {
		public void onShutter() {
			Log.d(TAG, "onShutter'd");
		}
	};

	/** Handles data for raw picture */
	PictureCallback rawCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) 
		{
			Log.d(TAG, "onPictureTaken - raw");
		}
	};

	/** Handles data for jpeg picture */
	PictureCallback jpegCallback = new PictureCallback() 
	{
		public void onPictureTaken(byte[] data, Camera camera) 
		{
			//FileOutputStream outStream = null;
			//try {
				// write to local sandbox file system
//				outStream = CameraDemo.this.openFileOutput(String.format("%d.jpg", System.currentTimeMillis()), 0);	
				// Or write to sdcard
//				outStream = new FileOutputStream(String.format("/sdcard/pic.jpg"));//, System.currentTimeMillis()));	
//				outStream.write(data);
//				outStream.close();
//				Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//			}
				SaveToHD(data);
			Log.d(TAG, "onPictureTaken - jpeg");
			
    		Intent myIntent = new Intent(plantcameracapture.this, PictureAnalysis.class);

    		plantcameracapture.this.startActivity(myIntent); 
		}
	};
	//};
}
