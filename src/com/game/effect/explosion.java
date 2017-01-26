package com.game.effect;

import com.game.core.GameInfo;

import android.graphics.Canvas;

public class explosion extends effect{

	public explosion(float px, float py) {
		super(GameInfo.explosion[0], px, py,0);
		// TODO Auto-generated constructor stub
		this.totalFrame=10;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(curFrame<totalFrame)
		{
			curFrame++;
			
		}
		
	}

	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		if(curFrame<totalFrame)
		{
			sp.setImage(GameInfo.explosion[curFrame]);
			sp.draw(c);
		}
		
	}

}
