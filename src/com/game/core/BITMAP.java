package com.game.core;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class BITMAP {

	View g;
	public BITMAP(View gv)
	{
		this.g=gv;
	}
	public Bitmap CreateBitmap(int src,int width,int height)
	{
		Bitmap temp=BitmapFactory.decodeResource(g.getResources(),src);
		temp=Bitmap.createScaledBitmap(temp, width, height, true);
		return temp;
	}
	
	public Bitmap CreateBitmap(int src)
	{
		Bitmap temp=BitmapFactory.decodeResource(g.getResources(),src);
		temp=Bitmap.createBitmap(temp);
		return temp;
	}
}
