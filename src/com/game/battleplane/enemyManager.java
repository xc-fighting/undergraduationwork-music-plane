package com.game.battleplane;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

import com.game.core.GameInfo;
import com.game.effect.effectManager;

public class enemyManager {

	public static List<enemy> enemy_list=new ArrayList<enemy>();
	
	playerplane p;
	public enemyManager(playerplane p)
	{
		this.p=p;
	}
	
	public void CreateEnemy(int type,float px,float py,float vx,float vy,int cv,int hp)
	{
		enemy temp=null;
		switch(type)
		{
			case 0:
			{
				temp=new enemy_0(GameInfo.en_0,px,py,vx,vy,hp,cv);
				
			}break;
			case 1:
			{
				temp=new enemy_1(GameInfo.en_1,px,py,vx,vy,hp,cv);
			}break;
			case 2:
			{
				temp=new enemy_2(GameInfo.en_2,px,py,vx,vy,hp,cv,p);
			}break;
			case 3:
			{
				temp=new enemy_3(GameInfo.en_3,px,py,vx,vy,hp,cv,p);
			}break;
			case 4:
			{
				temp=new enemy_4(GameInfo.boss,px,py,vx,vy,hp,cv,p);
			}break;
			case 5:
			{
				temp=new enemy_5(GameInfo.en_5,px,py,vx,vy,hp,cv);
			}break;
			
		}
		enemy_list.add(temp);
	}
	
	
	public void update()
	{
		for(int i=0;i<enemy_list.size();i++)
		{
			if(enemy_list.get(i).isOverBoundary()==true)
			{
				enemy_list.remove(i);
				i=i-1;
			}
			else
			{
				if(enemy_list.get(i).isAlive()==false)
				{
					GameInfo.score+=100;
					GameInfo.IS_SCORE_CHANGE=true;
					effectManager.CreateEffect(0,enemy_list.get(i).sp.posX,enemy_list.get(i).sp.posY);
					enemy_list.remove(i);
					i=i-1;
				}
				else
				{
				
						if(enemyManager.enemy_list.get(i).sp.checkCollision(p.sp)==true)					
						{
							p.getHurt(enemyManager.enemy_list.get(i).collisionValue);
							enemyManager.enemy_list.get(i).beImpacted();
							
						}
						else
							enemy_list.get(i).update();
				}
			}
		}
	}
	
	public void draw(Canvas cc)
	{
		for(int i=0;i<enemy_list.size();i++)
		{
			enemy_list.get(i).draw(cc);
		}
	}
	
	public void destroy()
	{
		enemy_list.removeAll(enemy_list);
	}
	
	
}
