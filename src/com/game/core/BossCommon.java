package com.game.core;

import com.game.battleplane.enemy_4;

public class BossCommon extends STATE{

	enemy_4 enemy;
	public BossCommon(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
		enemy=(enemy_4)this.obj;
		enemy.MoveRange=400;
		enemy.sp.vx=enemy.VXInit;
		enemy.sp.vy=enemy.VYInit;
	}

	@Override
	public STATE toNextState() {
		// TODO Auto-generated method stub
		if(enemy_4.RageValue>=30)
		{
			enemy_4.RageValue=0;
			return new BossRush(enemy);
		}
		else
		return this;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(Math.abs(enemy.sp.posX-enemy.XInit)>=enemy.MoveRange)
		{
			enemy.sp.vx=-enemy.sp.vx;
		}
		enemy.sp.update(enemy.sp.vx,enemy.sp.vy);
		enemy.UpdateLife();
		enemy.BossWeapon.fire();
	}

}
