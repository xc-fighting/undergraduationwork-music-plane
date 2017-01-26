package com.game.core;

import com.game.battleplane.enemy_1;
import com.game.weapon.eNormalWeapon;

public class Enemy1Hover extends STATE{

	enemy_1 enemy;
	public Enemy1Hover(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
		enemy=(enemy_1)this.obj;
	}

	@Override
	public STATE toNextState() {
		// TODO Auto-generated method stub
		if(enemy.hp<=enemy.HPInit/10)
		{
			enemy.sp.vx=0;
			enemy.sp.vy=-5;
			return new Enemy1Retreat(enemy);
		}
		else
		{
			if(enemy.hoverFinished==true)
			{
				enemy.sp.vx=0;
				enemy.sp.vy=enemy.VYInit;
				enemy.wp=new eNormalWeapon(enemy.sp,300);
				return new Enemy1Common(enemy);
			}
			else return this;
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(enemy.hoverSteps<=300)
		{
			if(Math.abs(enemy.sp.posX-enemy.XInit)>=enemy.MoveRange)
			{
				enemy.sp.vx=-enemy.sp.vx;
			}
			enemy.hoverSteps++;
		}
		else
		{
			enemy.hoverFinished=true;
		}
		enemy.sp.update(enemy.sp.vx,enemy.sp.vy);
		enemy.UpdateLife();
		enemy.wp.fire();
	}

}
