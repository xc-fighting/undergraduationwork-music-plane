package com.game.weapon;



import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;

//发射一个子弹
public class eNormalWeapon extends weapon{

	public eNormalWeapon(sprite s, long f) {
		super(s, f,1);
		// TODO Auto-generated constructor stub
		this.Init();
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(this.shootTime%this.freq==0)
		{
			bullet b=new normalbullet(GameInfo.bulletEneNor,sp.centerX,sp.posY+sp.getImgHeight(),0,8,3);
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
