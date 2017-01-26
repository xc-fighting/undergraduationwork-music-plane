package com.game.thread;

import com.game.battleplane.enemyManager;
import com.game.view.gameview;

public class EnemyThread extends Thread{

	enemyManager em;
	public EnemyThread(enemyManager e)
	{
		this.em=e;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				try {
					em.update();
					sleep(1000/60);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
