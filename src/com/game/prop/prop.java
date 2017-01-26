package com.game.prop;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.game.core.GameInfo;
import com.game.core.sprite;

public abstract class prop {

	public sprite propSP; 
	int type;
	boolean isTouchable;
	
	public prop(Bitmap b,float x,float y,float vx,float vy,int type)
	{
		propSP=new sprite(b,x,y,vx,vy);
		this.type=type;
		isTouchable=true;
	}
	
	public void setTouchable(boolean flag)
	{
		this.isTouchable=flag;
	}
	
	public boolean isTouchable()
	{
		return this.isTouchable;
	}
	
	public void setType(int type)
	{
		this.type=type;
	}
	
	public int getType()
	{
		return this.type;
	}
	
	public void setTarget(float x,float y,float speed)
	{
		float dx=x-propSP.posX;
		float dy=y-propSP.posY;
		propSP.vx=dx/speed;
		propSP.vy=dy/speed;
	}
	
	public abstract void update();
	public abstract void draw(Canvas c);
	public abstract void setAnimation();
	
	public boolean IsOverBoundary()
	{
		if(propSP.posX<=0||propSP.posX>=GameInfo.SWidth
				||propSP.posY<=0||propSP.posY>=GameInfo.SHeight)
			return true;
		else return false;
	}
	
	public boolean CheckCollide(sprite sp)
	{
		return this.isTouchable&&propSP.checkCollision(sp);
	}
	
	
	
	
}
