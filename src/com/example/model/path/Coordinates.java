package com.example.model.path;

import java.util.HashMap;


import android.util.Log;

// This class represents a coordinate in one of the system supported.
// It can convert a coordinate value from one system to another by the native library Proj4. 
// This library is compiled for all actual android architecture (ARM, MIPS,x86) with the Android NDK
// Every coordinate has a X and a Y value and which reference system belongs

public class Coordinates {
	public static final String WGS84="+proj=latlong +datum=WGS84 +no_defs";
	//public static final String GB_EST="+proj=tmerc +lat_0=0 +lon_0=15 +k=0.9996 +x_0=2520000 +y_0=0 +ellps=intl +units=m +towgs84=-104.1,-49.1,-9.9,0.971,-2.917,0.714,-11.68 +no_defs";
	public static final String GB_EST="+proj=tmerc +lat_0=0 +lon_0=15 +k=0.9996 +x_0=2520000 +y_0=0 +ellps=intl +units=m +no_defs";
	
	/*
	private static final HashMap<String, Proj4> pMap=new HashMap<String, Proj4>(){ {
			put(Coordinates.WGS84+Coordinates.GB_EST,new Proj4(Coordinates.WGS84,Coordinates.GB_EST));
			put(Coordinates.GB_EST+Coordinates.WGS84,new Proj4(Coordinates.GB_EST,Coordinates.WGS84));
	}
	};
	*/
	private double mX,mY;
	private String mSref;
	
	public static Coordinates createWGS84(double lat,double lng) {
		return new Coordinates(lng, lat, Coordinates.WGS84);
	}

	public Coordinates(double x,double y,String sref) {
		mX = x;
		mY = y;
		mSref = sref;
	}
	
	public double getX() {
		return mX;
	}
	public void setX(double X) {
		this.mX = X;
	}
	public double getY() {
		return mY;
	}
	public void setY(double Y) {
		this.mY = Y;
	}
	public String getSref() {
		return mSref;
	}
	public void setSref(String sref) {
		this.mSref = sref;
	}
	
	public Coordinates transform(String sref) {
		if (sref.equals(mSref)) {
			return new Coordinates(mX, mY, mSref);
		}
		double x = mX;
		double y = mY;
		if (mSref==Coordinates.GB_EST && sref==Coordinates.WGS84){
			x-=16;
			y+=78;
		}
		/*
		Proj4 projConvert =pMap.get(mSref+sref);
		ProjectionData pData=new ProjectionData(new double[][] { {x , y} },new double[] { 0 });
		projConvert.transform(pData, 1, 0);
		x = pData.x[0];
		y = pData.y[0];
		if (mSref==Coordinates.WGS84 && sref==Coordinates.GB_EST){
			x+=16;
			y-=78;
		}
		*/		
		return new Coordinates(x,y, sref);
	}
}

