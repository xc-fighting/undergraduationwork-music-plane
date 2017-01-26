package com.game.gui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

import com.game.core.GameInfo;
import com.game.core.sprite;

public class scoreboard {

	public List<sprite> Score=new ArrayList<sprite>();
	String scoreValue;
	sprite temp;
	int index;
	public scoreboard()
	{
		Score.removeAll(Score);
		scoreValue=Integer.toString(GameInfo.score);
		for(int i=0;i<scoreValue.length();i++)
		{
			index=scoreValue.charAt(i)-'0';
			temp=new sprite(GameInfo.numbers[index],
					GameInfo.SWidth-(scoreValue.length()-i)*GameInfo.numbers[i].getWidth(),0);
			Score.add(temp);
		}
	}
	
	public void draw(Canvas c)
	{
		for(int i=0;i<Score.size();i++)
		{
			Score.get(i).draw(c);
		}
	}
	
	public void update()
	{
		if(GameInfo.IS_SCORE_CHANGE==true)
		{
			Score.removeAll(Score);
			scoreValue=Integer.toString(GameInfo.score);
			for(int i=0;i<scoreValue.length();i++)
			{
				index=scoreValue.charAt(i)-'0';
				temp=new sprite(GameInfo.numbers[index],
						GameInfo.SWidth-(scoreValue.length()-i)*GameInfo.numbers[i].getWidth(),0);
				Score.add(temp);
			}
			GameInfo.IS_SCORE_CHANGE=false;
		}
	}
	
	
}
