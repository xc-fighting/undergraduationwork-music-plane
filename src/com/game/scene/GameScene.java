package com.game.scene;

import com.game.battleplane.enemyManager;
import com.game.battleplane.playerplane;
import com.game.bullet.bulletManager;
import com.game.core.GameInfo;
import com.game.core.MUSIC;
import com.game.effect.effectManager;
import com.game.gui.bottomboard;
import com.game.gui.gamebutton;
import com.game.gui.lifeboard;
import com.game.gui.rightboard;
import com.game.gui.scoreboard;
import com.game.prop.propManager;
import com.game.thread.BackGroundThread;
import com.game.thread.BulletThread;
import com.game.thread.EffectThread;
import com.game.thread.EnemyThread;
import com.game.thread.MusicThread;
import com.game.thread.PlayerThread;
import com.game.thread.PropThread;
import com.game.view.gameview;


import android.graphics.Canvas;
import android.graphics.Paint;




public class GameScene {

	
	
	
	gameview view;
	public MUSIC musicPlayer;
	public MusicThread MT;
	
	public BackGround backGround;
	BackGroundThread bthread;
	
	public playerplane player;
	PlayerThread pt;
	
	public bulletManager bManager;
	BulletThread bt;
	
	public enemyManager EM;
	EnemyThread ET;
	
	public effectManager eM;
	EffectThread et;
	
	public propManager pM;
	PropThread PT;
	
	bottomboard bmenu;
	lifeboard lb;
	scoreboard sboard;
	rightboard weaponBoard;
	
	Paint p;
	
   public GameScene(gameview g)
   {
	   view=g;
	  
	   p=new Paint();
	   p.setARGB(255, 255,255, 0);
   }
	
	public void InitScene()
	{
		
		musicPlayer=new MUSIC(view);
		musicPlayer.playMusic();
		MT=new MusicThread(musicPlayer);
		MT.start();
		
		if(GameInfo.USE_WEAPON==true)
		weaponBoard=new rightboard();
		
		//背景类及其线程
		backGround=new BackGround(GameInfo.backGround,3);
		bthread=new BackGroundThread(backGround);
		bthread.start();
		
		//玩家类及其线程
		player=new playerplane(400,600,100);
		pt=new PlayerThread(player);
		pt.start();
		
		//子弹管理器及其线程
		bManager=new bulletManager(player);
		bt=new BulletThread(bManager);
		bt.start();
		
		//道具管理器及其线程
		pM=new propManager(player);
		PT=new PropThread(pM);
		PT.start();
		
		//敌机管理器及其线程
		EM=new enemyManager(player);
		ET=new EnemyThread(EM);
		ET.start();
		
		//效果管理器及其线程
		eM=new effectManager();
		et=new EffectThread(eM);
		et.start();
		//底部菜单类
		bmenu=new bottomboard();
		//生命栏类
		lb=new lifeboard(player.hp);
		//分数栏类
		sboard=new scoreboard();
	}
	
	public void draw(Canvas c)
	{
		//画背景
		backGround.draw(c);		
		//画音乐时间和飞行距离	
		p.setTextSize(35);
		c.drawText(GameInfo.min+"min:"+GameInfo.sec+"sec", 0,80, p);
		p.setTextSize(25);
		c.drawText((int)(GameInfo.miles/1000)+"miles",0, 100, p);
		//画玩家
		player.draw(c);
		//画子弹
		bManager.draw(c);
		//画敌人
		EM.draw(c);
		//画特效
		eM.draw(c);
		//画道具
		pM.draw(c);
		//画底部菜单
		bmenu.update();
		bmenu.draw(c);
		//画生命菜单
		lb.update(player.hp);
		lb.draw(c);
		//画分数板
		sboard.update();
		sboard.draw(c);
		
		if(GameInfo.USE_WEAPON==true)
		weaponBoard.draw(c);
		
		//画按钮
		for(int i=0;i<gamebutton.ButtonGroup.size();i++)
		{
			gamebutton.ButtonGroup.get(i).draw(c);
		}
	}
	
	public void destroy()
	{
		try {
			bthread.join();
			pt.join();
			bt.join();
			ET.join();
			et.join();
			PT.join();
			MT.join();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{			
			bManager.Destroy();
			pM.destroy();
			EM.destroy();
			eM.destroy();
		/*	GameInfo.NUM_Bomb=0;
			GameInfo.NUM_Life=0;
			GameInfo.NUM_MW=0;
			GameInfo.NUM_PW=0;
			GameInfo.miles=0;*/
			gamebutton.ButtonGroup.removeAll(gamebutton.ButtonGroup);
			MT=null;
			bthread=null;
			pt=null;
			bt=null;
			ET=null;
			et=null;
			PT=null;
		}
	}
	
}
