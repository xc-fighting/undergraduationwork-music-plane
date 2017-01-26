package com.game.gui;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.core.GameInfo;
import com.game.core.sprite;

public class bottomboard {

	sprite leftboard;
	sprite rightboard;
	sprite centerboard;
	gamebutton playbtn;
	gamebutton lifebtn;
	gamebutton bombbtn;
	Paint p;
	
	public bottomboard()
	{
		leftboard=new sprite(GameInfo.leftBoard,0,GameInfo.SHeight-GameInfo.leftBoard.getHeight());
		centerboard=new sprite(GameInfo.centerBoard,GameInfo.SWidth/4,GameInfo.SHeight-GameInfo.centerBoard.getHeight());
		rightboard=new sprite(GameInfo.rightBoard,3*GameInfo.SWidth/4,GameInfo.SHeight-GameInfo.rightBoard.getHeight());
		playbtn=new gamebutton(GameInfo.btnpause,(GameInfo.SWidth-GameInfo.btnpause.getWidth())/2,
				GameInfo.SHeight-GameInfo.btnpause.getHeight()-10,0);
		if(GameInfo.NUM_Life>0)
		{
			lifebtn=new gamebutton(GameInfo.btnLife,GameInfo.SWidth/4,
					GameInfo.SHeight-GameInfo.btnLife.getHeight()-10,1);
		}
		else
		{
			lifebtn=new gamebutton(GameInfo.btnNormal,GameInfo.SWidth/4,
					GameInfo.SHeight-GameInfo.btnNormal.getHeight()-10,1);
		}
		if(GameInfo.NUM_Bomb>0)
		{
			bombbtn=new gamebutton(GameInfo.btnBomb,GameInfo.SWidth*3/4-GameInfo.btnBomb.getWidth(),
					GameInfo.SHeight-GameInfo.btnBomb.getHeight()-10,2);
		}
		else
		{
			bombbtn=new gamebutton(GameInfo.btnNormal,GameInfo.SWidth*3/4-GameInfo.btnNormal.getWidth(),
					GameInfo.SHeight-GameInfo.btnNormal.getHeight()-10,2);
		}
		p=new Paint();
		p.setARGB(255,255,0,0);
		p.setTextSize(25);
	}
	
	public void draw(Canvas c)
	{
		leftboard.draw(c);
		centerboard.draw(c);
		rightboard.draw(c);
		if(GameInfo.NUM_Life>0)
		c.drawText(""+GameInfo.NUM_Life,lifebtn.button.posX+lifebtn.button.getImgWidth(),
				lifebtn.button.posY, p);
		if(GameInfo.NUM_Bomb>0)
			c.drawText(""+GameInfo.NUM_Bomb, bombbtn.button.posX+bombbtn.button.getImgWidth(),
					bombbtn.button.posY, p);
	}
	
	public void update()
	{
		if(GameInfo.NUM_Bomb>0)
		{
			bombbtn.button.setImage(GameInfo.btnBomb);
		}
		else
		{
			bombbtn.button.setImage(GameInfo.btnNormal);
		}
		if(GameInfo.NUM_Life>0)
		{
			lifebtn.button.setImage(GameInfo.btnLife);
		}
		else
		{
			lifebtn.button.setImage(GameInfo.btnNormal);
		}
	}
	
	
	
}
