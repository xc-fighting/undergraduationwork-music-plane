package com.game.effect;

import com.game.core.GameInfo;

import android.graphics.Canvas;

public class scoreget extends effect{

	public scoreget(float px, float py) {
		super(GameInfo.ScoreEffect[0], px, py,3);
		// TODO Auto-generated constructor stub
		this.totalFrame=5;
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
			sp.setImage(GameInfo.ScoreEffect[curFrame]);
			sp.draw(c);
		}
	}

}
