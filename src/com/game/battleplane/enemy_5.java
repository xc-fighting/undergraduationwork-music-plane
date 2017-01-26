package com.game.battleplane;

import com.game.weapon.eNormalWeapon;
import com.game.weapon.weapon;

import android.graphics.Bitmap;

public class enemy_5 extends enemy{

	float xinit;
	float range;
    weapon w;
	
	public enemy_5(Bitmap b, float x, float y, float vx, float vy, int hp,
			int cv) {
		super(b, x, y, vx, vy, hp, cv, 5);
		// TODO Auto-generated constructor stub
		this.collidedValue=this.HPInit;
		range=120;
		xinit=x;
        w=new eNormalWeapon(this.sp,200);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(Math.abs(this.sp.posX-xinit)>=range)
		{
			this.sp.vx=-this.sp.vx;
		}
		this.UpdateLife();
		this.sp.update(sp.vx,sp.vy);
		w.fire();
	}

}
