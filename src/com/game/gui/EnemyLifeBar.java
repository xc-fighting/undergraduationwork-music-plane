package com.game.gui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class EnemyLifeBar {

	Rect lifeBar;
	float dx;
	Paint p;
	public EnemyLifeBar(float x,float y,float width,float value)
	{
		lifeBar=new Rect();
		lifeBar.left=(int) x;
		lifeBar.top=(int)y;
		lifeBar.right=(int)(x+width);
		lifeBar.bottom=(int)(y+10);
		this.dx=width/value;
		p=new Paint();
		p.setARGB(255,255,0,0);
	}
	
	public void Update(int value,float x,float y)
	{
		lifeBar.left=(int) x;
		lifeBar.top=(int)y;
		lifeBar.right=(int) (lifeBar.left+dx*value);
		lifeBar.bottom=lifeBar.top+10;
	}
	
	public void draw(Canvas c)
	{
		c.drawRect(lifeBar, p);
	}
	
	
}
