package com.game.bullet;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.game.core.GameInfo;
import com.game.core.sprite;

public abstract class bullet {

	sprite bulletsp;
	int hurtValue;
	int type;
	
	public bullet(Bitmap b,float x,float y,float vx,float vy,int hurt,int type)
	{
		bulletsp=new sprite(b,x,y,vx,vy);
		hurtValue=hurt;
		this.type=type;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	
	public int getHurtValue()
	{
		return this.hurtValue;
	}
	
	public boolean checkOverBoundary()
	{
		if(bulletsp.posX<0||bulletsp.posX>=GameInfo.SWidth||bulletsp.posY<0||bulletsp.posY>GameInfo.SHeight)
			return true;
		else return false;
	}
	
	public abstract void  update();
	public abstract boolean isExist();
	
	public  boolean checkCollide(sprite sp)
	{
		return bulletsp.checkCollision(sp);
	}
	
	public void draw(Canvas c)
	{
		bulletsp.draw(c);
	}
	
	
	
	
}
