package com.maciejpatro.ntrack;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		EditText login = (EditText) findViewById(R.id.login);
		setTypeFaceForViewGroup((ViewGroup) login.getRootView());
		
		
		Button loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(getApplicationContext(), MenuAc.class);
        		startActivity(i);
        		}
        	});
		
		Button skipButton = (Button) findViewById(R.id.skip_button);
		skipButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent i = new Intent(getApplicationContext(), MenuAc.class);
        		startActivity(i);
        		}
        	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	private void setTypeFaceForViewGroup(ViewGroup vg) {

		for (int i = 0; i < vg.getChildCount(); i++) {

			if (vg.getChildAt(i) instanceof ViewGroup) {
				setTypeFaceForViewGroup((ViewGroup) vg.getChildAt(i));
			} else if (vg.getChildAt(i) instanceof TextView) {
				((TextView) vg.getChildAt(i)).setTypeface(Typeface
						.createFromAsset(getAssets(), "fonts/Roboto-Condensed.ttf"));
			}

		}

	}
}
