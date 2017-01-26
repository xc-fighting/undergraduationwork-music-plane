package com.game.weapon;

import android.os.SystemClock;

import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;


//Íæ¼ÒÕý³£ÎäÆ÷
public class pNormalWeapon extends weapon{

	public pNormalWeapon(sprite s, long f) {
		super(s, f,0);
		// TODO Auto-generated constructor stub
		this.Init();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(SystemClock.currentThreadTimeMillis()-shootTime>=freq)
		{
			shootTime=SystemClock.currentThreadTimeMillis();
			bullet b1=new normalbullet(GameInfo.bulletMain,sp.centerX-5,sp.posY,0,-10,2);
			bullet b2=new normalbullet(GameInfo.bulletSub,sp.centerX-10,sp.posY,0,-6,1);
			bullet b3=new normalbullet(GameInfo.bulletSub,sp.centerX+10,sp.posY,0,-6,1);			
			bulletManager.player_bullet.add(b1);
			bulletManager.player_bullet.add(b2);
			bulletManager.player_bullet.add(b3);
		}
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		this.shootTime=SystemClock.currentThreadTimeMillis();
	}



}
