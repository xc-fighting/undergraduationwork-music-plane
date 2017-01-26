package com.game.effect;

import com.game.core.GameInfo;


import android.graphics.Canvas;

public class lifeget extends effect{

	public lifeget(float px, float py) {
		super(GameInfo.lifeEffect[0], px, py, 1);
		// TODO Auto-generated constructor stub
		this.totalFrame=9;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(curFrame<totalFrame)
		{
			curFrame+=1;
		}
		
	}

	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		if(curFrame<totalFrame)
		{
			sp.setImage(GameInfo.lifeEffect[curFrame]);
			sp.draw(c);
		}
	}

}
