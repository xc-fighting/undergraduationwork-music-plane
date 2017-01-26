package com.game.gui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.game.core.sprite;

public class gamebutton {

	public static List<gamebutton> ButtonGroup=new ArrayList<gamebutton>();
	public sprite button;
	int type;
	public boolean isPressed;
	
	public gamebutton(Bitmap btnImg,float x,float y,int type)
	{
		button=new sprite(btnImg,x,y);
		this.type=type;
		isPressed=false;
		ButtonGroup.add(this);
		
	}
	
	public void draw(Canvas c)
	{
		button.draw(c);
	}
	
	
	
	public boolean isTouched(float x,float y)
	{
		return button.checkTouch(x, y);
	}
	
	public int getType()
	{
		return this.type;
	}
	
	
}
