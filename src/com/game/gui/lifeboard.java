package com.game.gui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.game.core.GameInfo;


public class lifeboard {

    float dx;    
    Paint p;
    Rect src;
    Rect dst;
	
	public lifeboard(int value)
	{
		
		dx=GameInfo.lifeBar.getWidth()/value;
		p=new Paint();
		src=new Rect();
		dst=new Rect();
		src.left=0;
		src.top=0;
		src.right=GameInfo.lifeBar.getWidth();
		src.bottom=GameInfo.lifeBar.getHeight();
		dst.left=(GameInfo.lifeBorder.getWidth()-GameInfo.lifeBar.getWidth())/2;
		dst.top=(GameInfo.lifeBorder.getHeight()-GameInfo.lifeBar.getHeight())/2;
		dst.right=dst.left+GameInfo.lifeBar.getWidth();
		dst.bottom=dst.top+GameInfo.lifeBar.getHeight();
	}
	
	public void draw(Canvas c)
	{
		c.drawBitmap(GameInfo.lifeBorder,0,0,p);
		c.drawBitmap(GameInfo.lifeBar,src, dst, p);
	}
	
	public void update(int value)
	{
		src.right=(int) (src.left+dx*value);
		dst.right=(int) (dst.left+dx*value);
	}
	
}
