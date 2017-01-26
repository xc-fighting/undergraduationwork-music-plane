package com.game.battleplane;

import com.game.weapon.eNormalWeapon;
import com.game.weapon.weapon;

import android.graphics.Bitmap;


public class enemy_0 extends enemy{

	weapon ene_weapon;
	public enemy_0(Bitmap b, float x, float y, float vx, float vy, int hp,int cv) 
	{
		super(b, x, y, vx, vy, hp,cv,0);
		// TODO Auto-generated constructor stub
		ene_weapon=new eNormalWeapon(this.sp,200);
		this.collidedValue=this.HPInit;
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.sp.update(sp.vx,sp.vy);
		this.UpdateLife();
		ene_weapon.fire();
	}


	

}
