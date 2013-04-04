package com.maciejpatro.ntrack;

import java.util.Arrays;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

public class WeigtControl extends Activity {

	private XYPlot mySimpleXYPlot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weigt_control);

		// initialize our XYPlot reference:

		mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
		// Create a couple arrays of y-values to plot:
		Number[] series1Numbers = { 1, 8, 5, 2, 7, 4 };
		Number[] series2Numbers = { 4, 6, 3, 8, 2, 10 };
		// Turn the above arrays into XYSeries':
		XYSeries series1 = new SimpleXYSeries(Arrays.asList(series1Numbers),
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use
														// the element index as
														// the x value
				"Series1"); // Set the display title of the series
		// same as above
		XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers),
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series2");
		// Create a formatter to use for drawing a series using
		// LineAndPointRenderer:
		LineAndPointFormatter series1Format = new LineAndPointFormatter(
				Color.rgb(0, 200, 0), // line color
				Color.rgb(0, 100, 0), // point color
				null, // fill color (none)
				new PointLabelFormatter(Color.WHITE)); // text color
		// add a new series' to the xyplot:
		mySimpleXYPlot.addSeries(series1, series1Format);
		// same as above:
		mySimpleXYPlot.addSeries(
				series2,
				new LineAndPointFormatter(Color.rgb(0, 0, 200), Color.rgb(0, 0,
						100), null, new PointLabelFormatter(Color.WHITE)));
		// reduce the number of range labels
		mySimpleXYPlot.setTicksPerRangeLabel(3);

		setTypeFaceForViewGroup((ViewGroup) mySimpleXYPlot.getRootView());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weigt_control, menu);
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
