package com.game.bullet;

import java.util.ArrayList;
import java.util.List;

import com.game.battleplane.enemyManager;
import com.game.battleplane.enemy_4;
import com.game.battleplane.playerplane;
import com.game.effect.effectManager;

import android.graphics.Canvas;

public class bulletManager {

	public static List<bullet> enemy_bullet=new ArrayList<bullet>();
	public static List<bullet> player_bullet=new ArrayList<bullet>();
	playerplane pp;
	public bulletManager(playerplane p)
	{
		pp=p;
	}
	
	
	
	public void draw(Canvas cc)
	{
		for(int i=0;i<enemy_bullet.size();i++)
		{
			enemy_bullet.get(i).draw(cc);
		}
		for(int i=0;i<player_bullet.size();i++)
		{
			player_bullet.get(i).draw(cc);
		}
	}
	
	
	public void update()
	{
		for(int i=0;i<enemy_bullet.size();i++)
		{
			if(enemy_bullet.get(i).isExist()==false)
			{
				enemy_bullet.remove(i);
				i=i-1;
			}
			else
			{
				
				if(enemy_bullet.get(i).checkCollide(pp.sp)==true)
				{
					pp.getHurt(enemy_bullet.get(i).hurtValue);
					effectManager.CreateEffect(0,pp.sp.posX, pp.sp.posY);
					enemy_bullet.remove(i);
					i=i-1;
				}
				else
				{
					enemy_bullet.get(i).update();				
			    }
				
				
			}
		}
		
		for(int j=0;j<player_bullet.size();j++)
		{
			if(player_bullet.get(j).isExist()==false)
			{
				player_bullet.remove(j);
				j=j-1;
			}
			else
			{
				if(check(j))
				{
					
					j=j-1;
				}
				else
					player_bullet.get(j).update();
				
			}
		}
		
	}
	
	public void Destroy()
	{
		enemy_bullet.removeAll(enemy_bullet);
		player_bullet.removeAll(player_bullet);
	}
	
	public boolean check(int index)
	{
		for(int i=0;i<enemyManager.enemy_list.size();i++)
		{
			if(enemyManager.enemy_list.get(i).sp.checkCollision(player_bullet.get(index).bulletsp)==true)
			{
				enemyManager.enemy_list.get(i).getHurt(player_bullet.get(index).hurtValue);
				if(enemyManager.enemy_list.get(i).type==4)
					enemy_4.RageValue++;
				player_bullet.remove(index);
				return true;
			}
		}
		return false;
	
	}
	
}
