package com.game.effect;

import com.game.core.GameInfo;


import android.graphics.Canvas;

public class bombget extends effect{

	public bombget(float px, float py) {
		super(GameInfo.bombEffect[0], px, py,2);
		// TODO Auto-generated constructor stub
		this.totalFrame=9;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.curFrame<totalFrame)
		{
			this.curFrame+=1;
		}
	}

	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		if(curFrame<totalFrame)
		{
			sp.setImage(GameInfo.bombEffect[curFrame]);
			sp.draw(c);
		}
	}

}
