package com.game.battleplane;

import com.game.weapon.eTrackWeapon;
import com.game.weapon.weapon;

import android.graphics.Bitmap;

public class enemy_2 extends enemy{

	weapon enemy2W;
	public enemy_2(Bitmap b, float x, float y, float vx, float vy, int hp,
			int cv,playerplane p) {
		super(b, x, y, vx, vy, hp, cv,2);
		// TODO Auto-generated constructor stub
		this.collidedValue=this.HPInit;
		enemy2W=new eTrackWeapon(this.sp,200,p);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.sp.update(sp.vx, sp.vy);
		this.UpdateLife();
		enemy2W.fire();
		
	}

}
