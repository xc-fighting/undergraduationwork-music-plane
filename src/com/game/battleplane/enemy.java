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
	public int type;//0Ϊ��ͨ���ˣ�����һ���ӵ���ֱ��·����1Ϊ���ӵ����˾�����ͣ���ܣ������ܣ�3Ϊ��ʯ���ˣ�ײ��������2Ϊ��׷�ٵ����ˣ�4Ϊboss
	
	public int collisionValue;//�����ײ����ɵ��˺�ֵ
	int collidedValue;//�����ײ���˺�ֵ
	
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
