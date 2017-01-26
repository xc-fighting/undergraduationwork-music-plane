package com.game.core;

import com.game.activity.GameSumActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MyHandler extends Handler{

	Activity target;
	public MyHandler(Activity act)
	{
		this.target=act;
	}
	
	@Override
	public void handleMessage(Message msg)
	{
		switch(msg.what)
		{
			case 0:
			{
				Toast.makeText(target, "游戏失败", Toast.LENGTH_SHORT).show();
				GameSumActivity.flag=true;
			}break;
			case 1:
			{
				Toast.makeText(target, "游戏成功", Toast.LENGTH_SHORT).show();
				GameSumActivity.flag=false;
				
			}break;
			case 2:
			{
				Toast.makeText(target, "音乐模式关闭下无法使用",Toast.LENGTH_SHORT).show();
			}break;
		}
		Intent intent=new Intent();
		intent.setClass(target,GameSumActivity.class);
		target.startActivity(intent);
		target.finish();
	}
	
}
