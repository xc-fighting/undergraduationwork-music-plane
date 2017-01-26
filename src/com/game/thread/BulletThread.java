package com.game.thread;

import com.game.bullet.bulletManager;
import com.game.view.gameview;

public class BulletThread extends Thread{

	bulletManager bM;
	public BulletThread(bulletManager bm)
	{
		bM=bm;
	}
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				try
				{
				bM.update();
				sleep(1000/60);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
}
