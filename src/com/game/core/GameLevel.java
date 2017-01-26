package com.game.core;

import java.util.Random;

import com.game.battleplane.enemyManager;
import com.game.prop.propManager;
import com.game.scene.GameScene;
import com.game.view.gameview;

public class GameLevel extends Thread{

	GameScene gs;
	int totaltime;
	int internal;
	int index;
	int delta;
	
	
	public static float[][][] propWaves={
		//combine1
		{
			{0,330,50,0,4},
			{0,270,110,0,4},
			{0,210,170,0,4},
			{0,390,110,0,4},
			{0,450,170,0,4}
		},
		//combine2
		{
			{0,450,50,0,4},
			{0,210,50,0,4},
			{0,330,170,0,4},
			{0,270,110,0,4},
			{0,390,110,0,4}
		},
		//combine3
		{
			{0,330,50,0,4},
			{0,270,110,0,4},
			{0,210,170,0,4},
			{0,390,110,0,4},
			{0,450,170,0,4},
			{0,330,170,0,4},
			{0,270,230,0,4},
			{0,390,230,0,4},
			{0,330,290,0,4}
		},
		//combine4
		{
			{0,210,170,0,4},
			{0,390,110,0,4},
			{0,450,170,0,4}
		},
		//combine5
		{
			{0,210,170,0,4},
			{1,390,110,0,4},
			{2,450,170,0,4}
		},
		//combine6
		{
			{0,450,50,0,4},
			{0,210,50,0,4},
			{1,330,170,0,4},
			{2,270,110,0,4},
			{0,390,110,0,4}
		}
	};
	
	
	
	
	public static float[][][] waves={
		
		//wave1
		{
			{0,30,50,0,0.5f,20,50},{0,130,150,0,0.5f,20,50},{0,230,50,0,0.5f,20,50},{0,390,50,0,0.5f,20,50},
			{0,490,150,0,0.5f,20,50},{0,590,50,0,0.5f,20,50}
		},
		//wave2
		{
			{0,30,50,0,0.5f,20,30},{0,230,50,0,0.5f,20,30},{0,390,50,0,0.5f,20,30},{0,590,50,0,0.5f,20,30}
		},
		//wave3
		{
			{1,130,50,0,0.5f,20,30},{1,490,50,0,0.5f,20,30}
		},		
		//wave4
		{
			{2,30,50,0,0.5f,20,30},{2,130,150,0,0.5f,20,30},{2,230,50,0,0.5f,20,30},{2,390,50,0,0.5f,20,30},
			{2,490,150,0,0.5f,20,30},{2,590,50,0,0.5f,20,30}
			
		},
		//wave5
		{
			{2,30,50,0,0.5f,20,30},{2,230,50,0,0.5f,20,30},{2,390,50,0,0.5f,20,30},{2,590,50,0,0.5f,20,30}
		},
		//wave6
		{
			{3,30,50,0,0,20,30},{3,230,50,0,0,20,30},{3,390,50,0,0,20,30},{3,590,50,0,0,20,30}
		},
		//wave7
		{
			{5,130,50,0.5f,0.5f,20,30},{5,490,50,0.5f,0.5f,20,30}
		},
		//wave8
		{
			{0,30,50,0,0.5f,20,30},{0,130,150,0,0.5f,20,30},{0,230,50,0,0.5f,20,30},{2,390,50,0,0.5f,20,30},
			{2,490,150,0,0.5f,20,30},{2,590,50,0,0.5f,20,30}
		},
		//wave9
		{
			{2,30,50,0,0.5f,20,30},{2,230,50,0,0.5f,20,30},
			{0,390,50,0,0.5f,20,30},{0,590,50,0,0.5f,20,30}
		},
		//wave10
		{
			{3,30,50,0,1,20,30},{4,360,400,1,0,20,300},{3,590,50,0,1,20,30}
		},
		//wave11
		{
			{0,30,50,0,1,20,30},{4,360,400,1,0,20,300},{0,590,50,0,1,20,30}
		},
		//wave12
		{
			{1,30,50,0,0,20,30},{4,360,400,1,0,20,300},{1,590,50,0,0,20,30}
		},
		//wave13
		{
			{5,30,50,0.5f,1,20,30},{4,360,400,1,0,20,300},{5,590,50,-0.5f,1,20,30}
		},
		//wave14
		{
			{4,360,400,1,0,20,300}
		},
		//wave15
		{
			{0,30,50,0,0.5f,20,30},{0,130,150,0,0.5f,20,30},{0,230,50,0,0.5f,20,30}
		},
		//wave16
		{
			{5,30,50,0.5f,0.5f,20,30},{5,130,150,0.5f,0.5f,20,30},{5,230,50,0.5f,0.5f,20,30}
		},
		//wave17
		{
			{0,390,50,0,0.5f,20,30},
			{0,490,150,0,0.5f,20,30},{0,590,50,0,0.5f,20,30}
		},
		//wave18
		{
			{0,390,50,-0.5f,0.5f,20,30},
			{0,490,150,-0.5f,0.5f,20,30},{0,590,50,-0.5f,0.5f,20,30}
		}
	};
	
	
	public GameLevel(GameScene gs,int internal)
	{
		this.gs=gs;
		this.internal=internal;
		this.totaltime=gs.musicPlayer.getMusicTime();
		index=0;
		delta=totaltime/internal;
	}
	
	public void run()
	{
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				if(gs.musicPlayer.getCurTime()>=delta*index)
				{
					//添加游戏产生敌人逻辑
					Random seed=new Random();
					int wave=seed.nextInt(18);
					float[][] combine=waves[wave];
					for(int i=0;i<combine.length;i++)
					{
						gs.EM.CreateEnemy((int)combine[i][0],combine[i][1],combine[i][2],
								combine[i][3],combine[i][4],(int)combine[i][5],(int)combine[i][6]);
					}
					index++;
					
				}
				
				if(enemyManager.enemy_list.size()==0)
				{
					if(propManager.PropList.size()==0)
					{
						Random r=new Random();
						int k=r.nextInt(9);
						if(k==5)
						{
							Random s=new Random();
							int index=s.nextInt(6);
							float[][] cb=propWaves[index];
							for(int j=0;j<cb.length;j++)
							{
								gs.pM.CreateProp((int)cb[j][0],cb[j][1],cb[j][2],cb[j][3],cb[j][4]);
							}
						}
					}
				}
			}
		}
	}
	
	
}
