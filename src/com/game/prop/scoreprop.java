package com.game.prop;

import com.game.core.GameInfo;


import android.graphics.Canvas;

public class scoreprop extends prop{

	int times;
	int totalFrame;
	int curFrame;
	public scoreprop(float x, float y, float vx, float vy) {
		super(GameInfo.ScoreProp[0], x, y, vx, vy,0);
		// TODO Auto-generated constructor stub
		totalFrame=GameInfo.ScoreProp.length;
		curFrame=0;
		times=0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.propSP.update(propSP.vx,propSP.vy);
		if(times%12==0)
		{
			curFrame=curFrame%totalFrame;
			curFrame+=1;
		}
		times++;
		
	}

	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		this.propSP.setImage(GameInfo.ScoreProp[curFrame%totalFrame]);
		this.propSP.draw(c);
	}

	@Override
	public void setAnimation() {
		// TODO Auto-generated method stub
		this.setTarget(GameInfo.SWidth,0,20);
		
	}

}
