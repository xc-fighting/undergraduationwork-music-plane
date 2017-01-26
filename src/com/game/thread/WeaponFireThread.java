package com.game.thread;

import com.game.battleplane.playerplane;


public class WeaponFireThread extends Thread{

	playerplane target;
	int step;
	int times;
	
	public WeaponFireThread(playerplane p,int times)
	{
		target=p;
		step=0;
		this.times=times;
	}
	
	public void setTimes(int t)
	{
		this.times=t;
		this.step=0;
	}
	
	public void run()
	{
		while(step<=times)
		{
			step+=1;
			try 
			{
				sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		target.changeWeapon(0);
		
	}
	
}
