package com.game.battleplane;

import android.graphics.Bitmap;

public class enemy_3 extends enemy{

	playerplane pp;
	
	public enemy_3(Bitmap b, float x, float y, float vx, float vy, int hp,
			int cv,playerplane p) {
		super(b, x, y, vx, vy, hp, cv,3);
		// TODO Auto-generated constructor stub
		pp=p;
		this.collidedValue=this.HPInit;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.UpdateLife();
		float dx=pp.sp.posX-this.sp.posX;
		float dy=pp.sp.posY-this.sp.posY;
		float mod=(float)Math.sqrt(dx*dx+dy*dy);
		this.sp.vx=4*dx/mod;
		this.sp.vy=4*dy/mod;
		this.sp.update(this.sp.vx,this.sp.vy);
		
	}

}
