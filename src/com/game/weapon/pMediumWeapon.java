package com.game.weapon;

import java.util.Random;

import android.os.SystemClock;

import com.game.battleplane.enemyManager;
import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.bullet.trackbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;

public class pMediumWeapon extends weapon{

	public pMediumWeapon(sprite s, long f) {
		super(s, f, 5);
		// TODO Auto-generated constructor stub
		this.Init();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(SystemClock.currentThreadTimeMillis()-shootTime>=this.freq)
		{
			shootTime=SystemClock.currentThreadTimeMillis();
			bullet mb=new normalbullet(GameInfo.bulletMain,this.sp.centerX,this.sp.posY,0,-10,3);
			bullet sub1=new normalbullet(GameInfo.bulletSub,this.sp.centerX-10,this.sp.posY,0,-8,2);
			bullet sub2=new normalbullet(GameInfo.bulletSub,this.sp.centerX+14,this.sp.posY,0,-8,2);
			bullet sub3=new normalbullet(GameInfo.bulletSub,this.sp.centerX-20,this.sp.posY,0,-8,2);
			bullet sub4=new normalbullet(GameInfo.bulletSub,this.sp.centerX+24,this.sp.posY,0,-8,2);
			int len=enemyManager.enemy_list.size();
			if(len>0)
			{
				Random seed=new Random();
				int index=seed.nextInt(len);
				bullet track=new trackbullet(GameInfo.bulletTrack,this.sp.centerX,this.sp.centerY,
						0,0,5,enemyManager.enemy_list.get(index).sp,200);
				bulletManager.player_bullet.add(track);
			}
			bulletManager.player_bullet.add(mb);
			bulletManager.player_bullet.add(sub1);
			bulletManager.player_bullet.add(sub2);
			bulletManager.player_bullet.add(sub3);
			bulletManager.player_bullet.add(sub4);
			
		}
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		this.shootTime=SystemClock.currentThreadTimeMillis();
	}

}
