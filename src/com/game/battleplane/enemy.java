package com.game.battleplane;

import android.graphics.Bitmap;
import android.graphics.Canvas;



import com.game.core.GameInfo;
import com.game.core.sprite;
import com.game.gui.EnemyLifeBar;

public abstract class enemy {

	public sprite sp;
	public int HPInit;
	public int hp;
	EnemyLifeBar elb;
	public int type;//0为普通敌人，发射一个子弹且直线路径，1为带子弹敌人具有悬停功能，会逃跑，3为陨石敌人，撞击攻击，2为带追踪弹敌人，4为boss
	
	public int collisionValue;//对玩家撞击造成的伤害值
	int collidedValue;//被玩家撞击伤害值
	
	public enemy(Bitmap b,float x,float y,float vx,float vy,int hp,int cv,int type)
	{
		sp=new sprite(b,x,y,vx,vy);
		HPInit=hp;
		this.hp=hp;
		this.type=type;
		this.collisionValue=cv;
		elb=new EnemyLifeBar(sp.posX,sp.posY+sp.getImgHeight(),sp.getImgWidth(),HPInit);
	
	}
	
	public void getHurt(int hurtValue)
	{
		this.hp-=hurtValue;
	}
	
	public boolean isOverBoundary()
	{
		if(type==4)return false;
		else
		{
			if(sp.posX<=0||sp.posX>=GameInfo.SWidth||sp.posY<=0||sp.posY>GameInfo.SHeight)return true;
			else return false;
		}
	}
	
		
	public void beImpacted()
	{
		this.hp-=this.collidedValue;
	}
	
	
	public void UpdateLife()
	{
		elb.Update(hp, sp.posX,sp.posY+sp.getImgHeight());
	}
	
	public void draw(Canvas c)
	{
		sp.draw(c);
		elb.draw(c);
	}
	
	public abstract void update();
	
	public boolean isAlive()
	{
		if(this.hp<=0)return false;
		else return true;
	}
	
	
	
}
