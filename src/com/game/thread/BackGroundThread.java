package com.game.thread;

import com.game.scene.BackGround;
import com.game.view.gameview;

public class BackGroundThread extends Thread{

	BackGround bg;
	public BackGroundThread(BackGround bg)
	{
		this.bg=bg;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				try
				{
					bg.update();
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
