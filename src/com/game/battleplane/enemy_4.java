package com.game.battleplane;

import com.game.core.BossCommon;

import com.game.core.STATE;
import com.game.weapon.ePowerWeapon;
import com.game.weapon.weapon;

import android.graphics.Bitmap;

public class enemy_4 extends enemy{

	
	public float MoveRange;
	public weapon BossWeapon;
	public static int RageValue;
	STATE state;
	public playerplane pp;
	
    public float XInit;
    public float YInit;
    
    public float VXInit;
    public float VYInit;
    

	
	public enemy_4(Bitmap b, float x, float y, float vx, float vy, int hp,
			int cv,playerplane t) {
		super(b, x, y, vx, vy, hp, cv, 4);
		// TODO Auto-generated constructor stub	
		RageValue=0;
		pp=t;
		BossWeapon=new ePowerWeapon(this.sp,300,0,60,6);
		XInit=x;
		YInit=y;
		VXInit=vx;
		VYInit=vy;
		state=new BossCommon(this);
		
	}
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		state.execute();
		state=state.toNextState();
	}

}
