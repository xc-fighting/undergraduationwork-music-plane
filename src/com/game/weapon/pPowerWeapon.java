package com.game.weapon;


import android.os.SystemClock;


import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;

public class pPowerWeapon extends weapon{

	public pPowerWeapon(sprite s, long f) {
		super(s, f,6);
		// TODO Auto-generated constructor stub
		this.Init();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(SystemClock.currentThreadTimeMillis()-shootTime>=this.freq)
		{
			shootTime=SystemClock.currentThreadTimeMillis();
			bullet mb=new normalbullet(GameInfo.bulletMain,this.sp.centerX,this.sp.posY,0,-14,5);
			bullet sub1=new normalbullet(GameInfo.bulletSub,this.sp.centerX-10,this.sp.posY,0,-10,3);
			bullet sub2=new normalbullet(GameInfo.bulletSub,this.sp.centerX+14,this.sp.posY,0,-10,3);
			bullet sub3=new normalbullet(GameInfo.bulletSub,this.sp.centerX-20,this.sp.posY,-4,-10,3);
			bullet sub4=new normalbullet(GameInfo.bulletSub,this.sp.centerX+24,this.sp.posY,4,-10,3);
			bullet sub5=new normalbullet(GameInfo.bulletSub,this.sp.centerX-20,this.sp.posY,0,-10,3);
			bullet sub6=new normalbullet(GameInfo.bulletSub,this.sp.centerX+24,this.sp.posY,0,-10,3);
			bulletManager.player_bullet.add(mb);
			bulletManager.player_bullet.add(sub1);
			bulletManager.player_bullet.add(sub2);
			bulletManager.player_bullet.add(sub3);
			bulletManager.player_bullet.add(sub4);
			bulletManager.player_bullet.add(sub5);
			bulletManager.player_bullet.add(sub6);
			
		}
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		this.shootTime=SystemClock.currentThreadTimeMillis();
	}

}
