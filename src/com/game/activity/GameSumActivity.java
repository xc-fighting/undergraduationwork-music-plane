package com.game.activity;

import com.game.view.gameloseview;
import com.game.view.gamewinview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class GameSumActivity extends Activity{

	public static boolean flag=false;
	View v;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if(flag==false)
		{
			v=new gamewinview(this,this);
		}
		else
		{
			v=new gameloseview(this,this);
		}
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(v);
	}
}
