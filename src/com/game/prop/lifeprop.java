package com.game.prop;

import com.game.core.GameInfo;


import android.graphics.Canvas;

public class lifeprop extends prop{

	public lifeprop(float x, float y, float vx, float vy) {
		super(GameInfo.btnLife, x, y, vx, vy,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.propSP.update(propSP.vx,propSP.vy);
	}

	@Override
	public void draw(Canvas c) {
		// TODO Auto-generated method stub
		propSP.draw(c);
	}

	@Override
	public void setAnimation() {
		// TODO Auto-generated method stub
		this.setTarget(GameInfo.SWidth/4,GameInfo.SHeight,20);
	}

}
