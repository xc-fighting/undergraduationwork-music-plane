package com.game.battleplane;

import com.game.core.Enemy1Common;
import com.game.core.STATE;
import com.game.weapon.eNormalWeapon;
import com.game.weapon.weapon;

import android.graphics.Bitmap;

public class enemy_1 extends enemy{

	STATE enemyState;
	public float XInit;
	public float VYInit;
	public float 	MoveRange;
    public boolean hoverFinished;
	public int hoverSteps;
	public weapon wp;
	
	public enemy_1(Bitmap b, float x, float y, float vx, float vy, int hp,
			int cv) {
		super(b, x, y, vx, vy, hp, cv,1);
		// TODO Auto-generated constructor stub
		this.collidedValue=this.HPInit;
		XInit=this.sp.posX;
		VYInit=this.sp.vy;
		MoveRange=60;
		HPInit=hp;
		hoverFinished=false;
		hoverSteps=0;
		wp=new eNormalWeapon(this.sp,300);
		enemyState=new Enemy1Common(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		enemyState.execute();
		enemyState=enemyState.toNextState();
	}

}
