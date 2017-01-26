package com.game.thread;


import android.os.Message;

import com.game.activity.GameActivity;
import com.game.battleplane.playerplane;
import com.game.core.GameInfo;
import com.game.view.gameview;


public class PlayerThread extends Thread{

	playerplane plane;
	public PlayerThread(playerplane pp)
	{
		plane=pp;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				plane.BoundarySolve();	
				if(GameInfo.USE_WEAPON==true)
				plane.pweapon.fire();
				if(plane.isAlive()==false)
				{
					gameview.isGamePause=true;
					gameview.isGameOn=false;
					Message msg=new Message();
					msg.what=0;
					GameActivity.handler.sendMessage(msg);
					break;
				}
				
				
			}
		}
	}
	
	
}
