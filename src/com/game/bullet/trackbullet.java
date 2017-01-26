package com.game.bullet;

import com.game.core.sprite;
import com.game.effect.effectManager;

import android.graphics.Bitmap;

public class trackbullet extends bullet{

	sprite target;
	int TimeLeft;
	int curTime;
	int curDegree;
	public trackbullet(Bitmap b, float x, float y, float vx, float vy,
			int hurt,sprite sp,int time) {
		super(b, x, y, vx, vy, hurt,1);
		// TODO Auto-generated constructor stub
		target=sp;
		TimeLeft=time;
		curTime=0;
		curDegree=0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub		
		float dx=target.posX-this.bulletsp.posX;
		float dy=target.posY-this.bulletsp.posY;
		float mod=(float)Math.sqrt(dx*dx+dy*dy);
		this.bulletsp.vx=5*dx/mod;
		this.bulletsp.vy=5*dy/mod;
		bulletsp.update(bulletsp.vx,bulletsp.vy);
		curDegree+=20;
		bulletsp.matrix.postRotate(curDegree,bulletsp.centerX,bulletsp.centerY);
		curTime+=1;
	}

	@Override
	public boolean isExist() 
	{
		if(this.checkOverBoundary()==true)
		{
			return false;
		}
		else
		{
			if(this.curTime>=TimeLeft)
			{
				effectManager.CreateEffect(0,this.bulletsp.posX,this.bulletsp.posY);
				return false;
			}
		}
		return true;
		
		
	}
	
	

}
