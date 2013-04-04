package com.maciejpatro.ntrack;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class AddProduct extends Activity {
	private ImageView upload;
	private Bitmap yourSelectedImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_product);

		EditText prod_name = (EditText) findViewById(R.id.prod_name);

		Spinner add_spin = (Spinner) findViewById(R.id.prod_in);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.add_spin_opt,
				R.layout.spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		add_spin.setAdapter(adapter);

		upload = (ImageView) findViewById(R.id.prod_img);
		upload.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("image/*");
				startActivityForResult(intent, 0);
			}
		});
		
		Button addButton = (Button) findViewById(R.id.prod_add_button);
		addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), MenuAc.class);
				startActivity(i);
			}
		});
		setTypeFaceForViewGroup((ViewGroup) prod_name.getRootView());
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode,Intent resultdata) {
		super.onActivityResult(requestCode, resultCode, resultdata);
		switch (requestCode) {
		case 0:
			if (resultCode == RESULT_OK) {
				Uri selectedImage = resultdata.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };
				Cursor cursor = getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				cursor.moveToFirst();
				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String filePath = cursor.getString(columnIndex);
				cursor.close();
				// Convert file path into bitmap image using below line.
				yourSelectedImage = BitmapFactory.decodeFile(filePath);
				upload.setImageBitmap(yourSelectedImage);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_product, menu);
		return true;
	}

	private void setTypeFaceForViewGroup(ViewGroup vg) {

		for (int i = 0; i < vg.getChildCount(); i++) {

			if (vg.getChildAt(i) instanceof ViewGroup) {
				setTypeFaceForViewGroup((ViewGroup) vg.getChildAt(i));
			} else if (vg.getChildAt(i) instanceof TextView) {
				((TextView) vg.getChildAt(i)).setTypeface(Typeface
						.createFromAsset(getAssets(),
								"fonts/Roboto-Condensed.ttf"));
			}

		}

	}

}
