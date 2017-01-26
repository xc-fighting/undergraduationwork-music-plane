package com.game.core;

import com.game.battleplane.enemy_1;
import com.game.weapon.eMediumWeapon;

public class Enemy1Common extends STATE{

	enemy_1 enemy1;
	public Enemy1Common(Object o) {
		super(o);
		// TODO Auto-generated constructor stub
		enemy1=(enemy_1)this.obj;
	}

	@Override
	public STATE toNextState() {
		// TODO Auto-generated method stub
		if(enemy1.hp<=enemy1.HPInit/10)
		{
			enemy1.sp.vx=0;
			enemy1.sp.vy=-5;
			return new Enemy1Retreat(enemy1);
		}
		else
		{
			if(enemy1.sp.posY>=GameInfo.SHeight/2&&enemy1.hoverFinished==false)
			{
				enemy1.sp.vx=2f;
				enemy1.sp.vy=0;
				enemy1.wp=new eMediumWeapon(enemy1.sp,200);
				return new Enemy1Hover(enemy1);
			}
			else return this;
		}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		enemy1.sp.update(enemy1.sp.vx,enemy1.sp.vy);
		enemy1.UpdateLife();
		enemy1.wp.fire();
	}

}
