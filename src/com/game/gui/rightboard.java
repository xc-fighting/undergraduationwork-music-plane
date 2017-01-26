package com.game.gui;

import com.game.core.GameInfo;


import android.graphics.Canvas;
import android.graphics.Paint;

public class rightboard {

	gamebutton mediumW;
	gamebutton powerW;
	Paint p;
	public rightboard()
	{
		p=new Paint();
		p.setARGB(255, 255, 0, 0);
		p.setTextSize(25);
		mediumW=new gamebutton(GameInfo.MediumWBtn,
				GameInfo.SWidth-GameInfo.MediumWBtn.getWidth(),
				GameInfo.SHeight/2-GameInfo.MediumWBtn.getHeight()-10,3);
		powerW=new gamebutton(GameInfo.PowerWBtn,GameInfo.SWidth-GameInfo.MediumWBtn.getWidth(),
				GameInfo.SHeight/2+10,4);
	}
	
	public void draw(Canvas c)
	{
		c.drawText(GameInfo.NUM_MW+"",GameInfo.SWidth-GameInfo.MediumWBtn.getWidth(),
				GameInfo.SHeight/2-GameInfo.MediumWBtn.getHeight()-10,p);
		c.drawText(GameInfo.NUM_PW+"",GameInfo.SWidth-GameInfo.MediumWBtn.getWidth(),
				GameInfo.SHeight/2+10, p);
	}
	
	
}
