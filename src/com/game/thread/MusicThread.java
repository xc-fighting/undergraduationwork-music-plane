package com.game.thread;

import android.os.Message;

import com.game.activity.GameActivity;
import com.game.core.GameInfo;
import com.game.core.MUSIC;

import com.game.view.gameview;

public class MusicThread extends Thread{

	MUSIC music;
	
	public MusicThread(MUSIC temp)
	{
		music=temp;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				GameInfo.min=music.getCurTime()/1000/60;
				GameInfo.sec=music.getCurTime()/1000%60;
				if(music.getCurTime()==music.getMusicTime())
				 {
					 gameview.isGamePause=true;
					 gameview.isGameOn=false;
					 Message msg=new Message();
					 msg.what=1;
					 GameActivity.handler.sendMessage(msg);
					 break;
				  }
			}
		}
		music.Release();
	}
	
}
