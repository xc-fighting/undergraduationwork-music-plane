package com.game.weapon;

import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;

//É¢µ¯Ç¹
public class ePowerWeapon extends weapon{

	int number;
	float degree;
	float degreeRange;
	float dl;
	float dr;
	float dEach;
	float vx;
	float vy;
	
	public ePowerWeapon(sprite s, long f,float degree,float degreeRange,int number) {
		super(s, f, 4);
		// TODO Auto-generated constructor stub
		this.Init();
		this.number=number;
		this.degree=degree;
		this.degreeRange=degreeRange;
		dl=degree-degreeRange;
		dr=degree+degreeRange;
		dEach=(dr-dl)/number;
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		if(shootTime%freq==0)
		{
			for(int i=0;i<number;i++)
			{
				vx=(float) (Math.sin(Math.toRadians(dl+i*dEach))*10);
				vy=(float) (Math.cos(Math.toRadians(dl+i*dEach))*10);
				bullet b=new normalbullet(GameInfo.bulletEneNor,sp.centerX,sp.posY+sp.getImgHeight(),vx,vy,5);
				bulletManager.enemy_bullet.add(b);
			}
		}
		shootTime++;
		
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		this.shootTime=0;
	}

	
	
}
