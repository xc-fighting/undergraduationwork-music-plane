package com.game.weapon;

import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;


//发射三发子弹
public class eMediumWeapon extends weapon{

	public eMediumWeapon(sprite s, long f) {
		super(s, f, 3);
		// TODO Auto-generated constructor stub
		this.Init();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(shootTime%freq==0)
		{
			bullet b1=new normalbullet(GameInfo.bulletEneNor,sp.centerX,sp.posY+sp.getImgHeight(),0,5,4);
			bullet b2=new normalbullet(GameInfo.bulletEneNor,sp.centerX,sp.posY+sp.getImgHeight(),3,5,4);
			bullet b3=new normalbullet(GameInfo.bulletEneNor,sp.centerX,sp.posY+sp.getImgHeight(),-3,5,4); 
			bulletManager.enemy_bullet.add(b1);
			bulletManager.enemy_bullet.add(b2);
			bulletManager.enemy_bullet.add(b3);
		}
		shootTime++;
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		this.shootTime=0;
	}

}
