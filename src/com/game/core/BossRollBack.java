package com.game.core;

import com.game.battleplane.enemy_4;

public class BossRollBack extends STATE{

	enemy_4 enemy;
	public BossRollBack(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
		enemy=(enemy_4)this.obj;
	    enemy.XInit=enemy.sp.posX;
	    enemy.sp.vy=-10;
	}

	@Override
	public STATE toNextState() {
		// TODO Auto-generated method stub
		if(enemy.sp.posY<=enemy.YInit)
		{
			return new BossCommon(enemy);
		}
		else
			 return this;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		enemy.sp.update(enemy.sp.vx,enemy.sp.vy);
		enemy.UpdateLife();
	}

}
