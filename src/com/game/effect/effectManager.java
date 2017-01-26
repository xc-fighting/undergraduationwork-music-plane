package com.game.effect;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class effectManager {

	public static List<effect> effect_list=new ArrayList<effect>();
	
	public static void CreateEffect(int type,float px,float py)
	{
		effect temp=null;
		switch(type)
		{
			case 0:
			{
				temp=new explosion(px,py);
			}break;
			case 1:
			{
				temp=new lifeget(px,py);
			}break;
			case 2:
			{
				temp=new bombget(px,py);
			}break;
			case 3:
			{
				temp=new scoreget(px,py);
			}break;
		}
		effect_list.add(temp);
	}
	
	public void draw(Canvas cc)
	{
		for(int i=0;i<effect_list.size();i++)
		{
			effect_list.get(i).draw(cc);
		}
	}
	
	public void update()
	{
		for(int i=0;i<effect_list.size();i++)
		{
			if(effect_list.get(i).isExist()==false)
			{
				effect_list.remove(i);
				i=i-1;
			}
			else
			{
				effect_list.get(i).update();
			}
		}
	}
	
	public void destroy()
	{
		effect_list.removeAll(effect_list);
	}
	
	
}
