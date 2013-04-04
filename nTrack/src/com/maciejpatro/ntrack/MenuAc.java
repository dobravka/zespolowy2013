package com.maciejpatro.ntrack;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.maciejpatro.ntrack.mech.optmenu.OptMenuAdapter;
import com.maciejpatro.ntrack.mech.optmenu.Options;

public class MenuAc extends Activity {

	private ListView menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		menu = (ListView) findViewById(R.id.menuview);
		
		setTypeFaceForViewGroup((ViewGroup) menu.getRootView());

		Options[] opt = new Options[] {
				new Options(R.drawable.plus, "Dodaj Produkt",
						"Mozna dodac do bazy danych nowy produkt zywieniowy!"),
				new Options(R.drawable.weight, "Kontrola Wagi",
						"Umozliwia sledzenie zmian w Twojej wadze!") };
		OptMenuAdapter adapt = new OptMenuAdapter(this, opt);
		menu.setAdapter(adapt);

		menu.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i;
				switch (arg2) {
				case 0:
					i = new Intent(getApplicationContext(),
							AddProduct.class);
					startActivity(i);
					break;
				case 1:
					i = new Intent(getApplicationContext(),
							WeigtControl.class);
					startActivity(i);
					break;
				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
