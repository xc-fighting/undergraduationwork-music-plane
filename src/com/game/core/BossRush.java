package com.game.core;

import com.game.battleplane.enemy_4;

public class BossRush extends STATE{

	enemy_4 enemy;
	public BossRush(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
		enemy=(enemy_4)this.obj;
		enemy.sp.vx=0;
		enemy.sp.vy=10;
		
	}

	@Override
	public STATE toNextState() {
		// TODO Auto-generated method stub
		if(enemy.sp.posY-enemy.YInit>=300)
		{
			return new BossRollBack(enemy);
		}
		else return this;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		enemy_4.RageValue-=3;
		enemy.sp.update(enemy.sp.vx,enemy.sp.vy);
		enemy.UpdateLife();
	}

}
