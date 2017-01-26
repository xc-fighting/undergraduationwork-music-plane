package com.game.bullet;



import android.graphics.Bitmap;

public class normalbullet extends bullet{

	public normalbullet(Bitmap b, float x, float y, float vx, float vy,
			int hurt) {
		super(b, x, y, vx, vy, hurt,0);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.bulletsp.update(bulletsp.vx,bulletsp.vy);
	}


	@Override
	public boolean isExist() {
		// TODO Auto-generated method stub
		if(this.checkOverBoundary()==true)return false;
		else return true;
	}

}
