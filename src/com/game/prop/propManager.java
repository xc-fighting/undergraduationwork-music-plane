package com.game.prop;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

import com.game.battleplane.playerplane;
import com.game.core.GameInfo;
import com.game.effect.effectManager;

public class propManager {

	public static List<prop>PropList=new ArrayList<prop>();
	
	playerplane target;
	
	public  void CreateProp(int type,float x,float y,float vx,float vy)
	{
		prop temp=null;
		switch(type)
		{
			case 0:
			{
				temp=new scoreprop(x,y,vx,vy);
			
			}break;
			case 1:
			{
				temp=new lifeprop(x,y,vx,vy);
			}break;
			case 2:
			{
				temp=new bombprop(x,y,vx,vy);
			}break;
		}
		PropList.add(temp);
	}
	
	
	public propManager(playerplane pp)
	{
		this.target=pp;
	}
	
	
	public void update()
	{
		for(int i=0;i<PropList.size();i++)
		{
			if(PropList.get(i).IsOverBoundary()==true)
			{
				PropList.remove(i);
				i=i-1;
			}
			else
			{
				if(PropList.get(i).CheckCollide(target.sp))
				{
					switch(PropList.get(i).getType())
					{
						case 0:
						{
							GameInfo.score+=100;
							GameInfo.IS_SCORE_CHANGE=true;
							effectManager.CreateEffect(3,PropList.get(i).propSP.posX,PropList.get(i).propSP.posY);
						}break;
						case 1:
						{
							GameInfo.NUM_Life+=1;
							effectManager.CreateEffect(1,PropList.get(i).propSP.posX,PropList.get(i).propSP.posY);
						}break;
						case 2:
						{
							GameInfo.NUM_Bomb+=1;
							effectManager.CreateEffect(2,PropList.get(i).propSP.posX,PropList.get(i).propSP.posY);
						}break;
					}
					PropList.get(i).setTouchable(false);
					PropList.get(i).setAnimation();
					
				}
				PropList.get(i).update();
			}
		}
	}
	
	public void draw(Canvas cc)
	{
		for(int i=0;i<PropList.size();i++)
		{
			PropList.get(i).draw(cc);
		}
	}
	
	public void destroy()
	{
		PropList.removeAll(PropList);
	}
	
	
}
