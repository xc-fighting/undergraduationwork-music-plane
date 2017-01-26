package com.game.battleplane;

import java.util.Random;

import android.graphics.Canvas;



import com.game.bullet.bullet;
import com.game.bullet.bulletManager;
import com.game.bullet.normalbullet;
import com.game.bullet.trackbullet;
import com.game.core.GameInfo;
import com.game.core.sprite;
import com.game.weapon.pMediumWeapon;
import com.game.weapon.pNormalWeapon;
import com.game.weapon.pPowerWeapon;
import com.game.weapon.weapon;

public class playerplane {

	public sprite sp;
	public weapon pweapon;
	public int hp;
	public int HPInit;
	boolean backToNormal;
	
	public playerplane(float x,float y,int HP)
	{
		sp=new sprite(GameInfo.player_normal,x,y);
		pweapon=new pNormalWeapon(sp,200);
		hp=HP;
		HPInit=hp;
		backToNormal=false;
	}
	
	public void draw(Canvas cc)
	{
		sp.draw(cc);
	}
	
	
	
	public void update(float dx,float dy)
	{
		sp.update(dx, dy);
	}
	
	public void BoundarySolve()
	{
		if(sp.posX<=0)
		{
			sp.posX=0;
			sp.centerX=sp.getImgWidth()/2;
		}
		if(sp.posX+sp.getImgWidth()>=GameInfo.SWidth)
		{
			sp.posX=GameInfo.SWidth-sp.getImgWidth();
			sp.centerX=GameInfo.SWidth-sp.getImgWidth()/2;
		}
		if(sp.posY<=0)
		{
			sp.posY=0;
			sp.centerY=0;
		}
		if(sp.posY+sp.getImgHeight()>=GameInfo.SHeight)
		{
			sp.posY=GameInfo.SHeight-sp.getImgHeight();
			sp.centerY=GameInfo.SHeight;
		}
		sp.matrix.setTranslate(sp.posX,sp.posY);
		sp.collisionBody.updateBox(sp.posX,sp.posY,sp.posX+sp.getImgWidth(),sp.posY+sp.getImgHeight());
	}
	
	public void getHurt(int hurtValue)
	{
		hp-=hurtValue;
	}
	
	public boolean isAlive()
	{
		if(hp>0)return true;
		else return false;
	}
	
	public void changeWeapon(int type)
	{
		switch(type)
		{
			case 0:
			{
				pweapon=new pNormalWeapon(sp,200);
			}break;
			case 5:
			{
				pweapon=new pMediumWeapon(sp,200);
			}break;
			case 6:
			{
				pweapon=new pPowerWeapon(sp,200);
			}break;
		}
	}
	
	public void fire1()
	{
		bullet b1=new normalbullet(GameInfo.bulletMain,sp.centerX-5,sp.posY,0,-10,2);
		bullet b2=new normalbullet(GameInfo.bulletSub,sp.centerX-10,sp.posY,0,-6,1);
		bullet b3=new normalbullet(GameInfo.bulletSub,sp.centerX+10,sp.posY,0,-6,1);			
		bulletManager.player_bullet.add(b1);
		bulletManager.player_bullet.add(b2);
		bulletManager.player_bullet.add(b3);
	}
	
	public void fire2()
	{
		bullet mb=new normalbullet(GameInfo.bulletMain,this.sp.centerX,this.sp.posY,0,-10,3);
		bullet sub1=new normalbullet(GameInfo.bulletSub,this.sp.centerX-10,this.sp.posY,0,-8,2);
		bullet sub2=new normalbullet(GameInfo.bulletSub,this.sp.centerX+14,this.sp.posY,0,-8,2);
		bullet sub3=new normalbullet(GameInfo.bulletSub,this.sp.centerX-20,this.sp.posY,0,-8,2);
		bullet sub4=new normalbullet(GameInfo.bulletSub,this.sp.centerX+24,this.sp.posY,0,-8,2);
		bullet sub5=new normalbullet(GameInfo.bulletSub,this.sp.centerX-30,this.sp.posY,0,-8,2);
		bullet sub6=new normalbullet(GameInfo.bulletSub,this.sp.centerX+34,this.sp.posY,0,-8,2);
		bullet sub7=new normalbullet(GameInfo.bulletSub,this.sp.centerX-30,this.sp.posY,-3,-8,2);
		bullet sub8=new normalbullet(GameInfo.bulletSub,this.sp.centerX+34,this.sp.posY,3,-8,2);
		bullet sub9=new normalbullet(GameInfo.bulletSub,this.sp.centerX-30,this.sp.posY,-6,-8,2);
		bullet sub10=new normalbullet(GameInfo.bulletSub,this.sp.centerX+34,this.sp.posY,6,-8,2);
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
		bulletManager.player_bullet.add(sub5);
		bulletManager.player_bullet.add(sub6);
		bulletManager.player_bullet.add(sub7);
		bulletManager.player_bullet.add(sub8);
		bulletManager.player_bullet.add(sub9);
		bulletManager.player_bullet.add(sub10);
	}
	

	
	
	
}
