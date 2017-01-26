package com.game.weapon;

import com.game.battleplane.playerplane;
import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.trackbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;


//µÐ»ú×·×Ùµ¯
public class eTrackWeapon extends weapon{

	playerplane target;
	public eTrackWeapon(sprite s, long f,playerplane target) {
		super(s, f,2);
		// TODO Auto-generated constructor stub
		this.Init();
		this.target=target;
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(shootTime%this.freq==0)
		{
			bullet b=new trackbullet(GameInfo.bulletTrack,sp.centerX,sp.posY+sp.getImgHeight(),0,0,5,target.sp,100);
			bulletManager.enemy_bullet.add(b);
		}
		shootTime++;
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		this.shootTime=0;
	}

}
