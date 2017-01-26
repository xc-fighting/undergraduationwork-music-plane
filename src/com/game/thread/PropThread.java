package com.game.thread;

import com.game.prop.propManager;
import com.game.view.gameview;

public class PropThread extends Thread{

	propManager pm;
	public PropThread(propManager pM)
	{
		this.pm=pM;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				try {
					pm.update();
					sleep(1000/60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
