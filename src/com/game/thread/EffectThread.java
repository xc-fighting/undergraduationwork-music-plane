package com.game.thread;

import com.game.effect.effectManager;
import com.game.view.gameview;

public class EffectThread extends Thread{

	public effectManager eM;
	
	public EffectThread(effectManager e)
	{
		eM=e;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				try {
					eM.update();
					sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
