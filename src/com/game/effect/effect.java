package com.game.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.game.core.sprite;

public abstract class effect {

	sprite sp;
	int curFrame;
	int totalFrame;
	int type;//0±¬Õ¨£¬1ÑªÆ¿£¬2Õ¨µ¯£¬3½ðÇ®
	
	public effect(Bitmap pic,float px,float py,int type)
	{
		sp=new sprite(pic,px,py);
		curFrame=0;
		this.type=type;
	}
	
	public abstract void update();
	public abstract void draw(Canvas c);
	
	public boolean isExist()
	{
		if(curFrame>=totalFrame)return false;
		else return true;
	}
	
	
	
}
