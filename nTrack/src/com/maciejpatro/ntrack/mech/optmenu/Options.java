package com.maciejpatro.ntrack.mech.optmenu;

public class Options {
	int imageRid;
	String name;
	
	public Options(int imageRid, String name, String description) {
		super();
		this.imageRid = imageRid;
		this.name = name;
		this.description = description;
	}
	public int getImageRid() {
		return imageRid;
	}
	public void setImageRid(int imageRid) {
		this.imageRid = imageRid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	String description;
}