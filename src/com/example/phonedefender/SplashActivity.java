package com.example.phonedefender;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置不要显示标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
	 
		initControls();
	}

	private void initControls() {
		TextView textView = (TextView)findViewById(R.id.start_splash_version);
		textView.setText("PhoneDefender "+getVersion());
		
		View  layout = findViewById(R.id.splash_layout);
		AlphaAnimation animation = new AlphaAnimation(0.5f,1.0f); 
		animation.setDuration(2000);
		layout.setAnimation(animation);
	}
	
	String  getVersion() {
		PackageManager manager = getPackageManager();
		PackageInfo info;
		try {
			info = manager.getPackageInfo(getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Not found version id";
		}
		return info.versionName;
		
	}

}
