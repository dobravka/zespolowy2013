package com.maciejpatro.ntrack.mech.optmenu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maciejpatro.ntrack.R;

public class OptMenuAdapter extends ArrayAdapter<Options> {
	private final Context context;
	private Options[] optList;

	public OptMenuAdapter(Context context, Options[] list) {
		super(context, R.layout.options_menu_item,list);
		this.context = context;
		this.optList = list;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();

		View rowView = inflater.inflate(R.layout.options_menu_item, parent,
				false);
		OptHolder.imgIcon = (ImageView) rowView.findViewById(R.id.photo);
		OptHolder.imgIcon.setBackgroundResource(optList[position].getImageRid());
		OptHolder.name = (TextView) rowView.findViewById(R.id.name);
		OptHolder.desc = (TextView) rowView.findViewById(R.id.desc);

		OptHolder.name.setText(optList[position].getName());
		OptHolder.desc.setText(optList[position].getDescription());
		return rowView;
	}
	
    static class OptHolder
    {
        static ImageView imgIcon;
        static TextView name;
        static TextView desc;
    }
}
