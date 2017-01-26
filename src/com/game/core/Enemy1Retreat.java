package com.game.core;

import com.game.battleplane.enemy_1;

public class Enemy1Retreat extends STATE{

	enemy_1 enemy;
	public Enemy1Retreat(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
		enemy=(enemy_1)this.obj;
	}

	@Override
	public STATE toNextState() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		enemy.sp.update(enemy.sp.vx,enemy.sp.vy);
		enemy.UpdateLife();
	}

}
