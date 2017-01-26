package com.game.core;

import com.game.activity.R;


import android.app.Activity;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class GameInfo {

	public static float V_UNIT=0.01f;
	public static int SWidth;
	public static int SHeight;
	
	public static boolean IS_SCORE_CHANGE=false;
	public static int score;
	public static int NUM_Bomb=0;
	public static int NUM_Life=0;
	public static float miles;
	public static int min;
	public static int sec;
	public static int NUM_MW=1;
	public static int NUM_PW=1;
    public static boolean USE_WEAPON=false;
	
	public static Bitmap play1;
	public static Bitmap shop;
	public static Bitmap gradeboard;
	public static Bitmap back;
	
	
	public static Bitmap menubg;
	public static Bitmap backGround;
	public static Bitmap player_normal;
	public static Bitmap player_left;
	public static Bitmap player_right;
	public static Bitmap bulletMain;
	public static Bitmap bulletSub;
	public static Bitmap bulletEneNor;
	public static Bitmap bulletTrack;
	public static Bitmap en_0;
	public static Bitmap[] explosion;
	public static Bitmap[] numbers;
	public static Bitmap[] bombEffect;
	public static Bitmap[] lifeEffect;
	public static Bitmap[] ScoreProp;
	public static Bitmap[] ScoreEffect;
	public static Bitmap leftBoard;
	public static Bitmap centerBoard;
	public static Bitmap rightBoard;
	public static Bitmap btnNormal;
	public static Bitmap btnBomb;
	public static Bitmap btnLife;
	public static Bitmap lifeBar;
	public static Bitmap lifeBorder;
	public static Bitmap btnpause;
	public static Bitmap btnplay;
	public static int[] id_bomb={
		R.drawable.bombget1,R.drawable.bombget2,R.drawable.bombget3,
		R.drawable.bombget4,R.drawable.bombget5,R.drawable.bombget6,
		R.drawable.bombget7,R.drawable.bombget8,R.drawable.bombget9
	};	
	public static int[] id_life={
		R.drawable.lifeget1,R.drawable.lifeget2,R.drawable.lifeget3,
		R.drawable.lifeget4,R.drawable.lifeget5,R.drawable.lifeget6,
		R.drawable.lifeget7,R.drawable.lifeget8,R.drawable.lifeget9
	};
	
	public static int[] id_score={
		R.drawable.money1,R.drawable.money2,R.drawable.money3,
		R.drawable.money4,R.drawable.money5,R.drawable.money6,
		R.drawable.money7,R.drawable.money8
	};
	
	
	public static int[] id_num={
		R.drawable.zero,R.drawable.one,R.drawable.two,R.drawable.three,
		R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven,
		R.drawable.eight,R.drawable.nine
	};
	public static int[] id_e={
		
		R.drawable.blaste_11,R.drawable.blaste_12,R.drawable.blaste_13,R.drawable.blaste_14,
		R.drawable.blaste_15,R.drawable.blaste_16,R.drawable.blaste_17,R.drawable.blaste_18,
		R.drawable.blaste_19,R.drawable.blaste_20
	};
	
	public static int[] id_m={
		R.drawable.scoreget1,R.drawable.scoreget2,R.drawable.scoreget3,
		R.drawable.scoreget4,R.drawable.scoreget5
	};
	
	public static Bitmap en_3;
	public static Bitmap en_2;
	public static Bitmap en_1;
	public static Bitmap boss;
	public static Bitmap en_5;
	

	public static Bitmap MediumWBtn;
	public static Bitmap PowerWBtn;
	
	public static Bitmap Winviewbg;
	public static Bitmap Wintitle;
	public static Bitmap backBtn;
	public static Bitmap Losetitle;
	
	public static void getScreenInfo(Activity a)
	{
		WindowManager manager=a.getWindowManager();
		Display display=manager.getDefaultDisplay();
		DisplayMetrics metrics=new DisplayMetrics();
		display.getMetrics(metrics);
		SWidth=metrics.widthPixels;
		SHeight=metrics.heightPixels;
	}
	
	public static void InitImageResource(View gv)
	{
		BITMAP BM=new BITMAP(gv);
		backGround=BM.CreateBitmap(R.drawable.c_bg,SWidth,SHeight);
		player_normal=BM.CreateBitmap(R.drawable.boat,60,60);
		player_left=BM.CreateBitmap(R.drawable.boatl,60,60);
		player_right=BM.CreateBitmap(R.drawable.boatr, 60, 60);
		bulletMain=BM.CreateBitmap(R.drawable.bulte_main, 10, 42);
		bulletSub=BM.CreateBitmap(R.drawable.bulte_sub, 6, 21);
		bulletEneNor=BM.CreateBitmap(R.drawable.bulte_normal,24,23);
		en_0=BM.CreateBitmap(R.drawable.en0,100,100);
		explosion=new Bitmap[10];
		numbers=new Bitmap[10];
		bombEffect=new Bitmap[9];
		lifeEffect=new Bitmap[9];
		ScoreProp=new Bitmap[8];
		ScoreEffect=new Bitmap[5];
		for(int i=0;i<5;i++)
		{
			ScoreEffect[i]=BM.CreateBitmap(id_m[i],80,80);
		}
		for(int i=0;i<10;i++)
		{
			explosion[i]=BM.CreateBitmap(id_e[i],80,80);
		}
		for(int i=0;i<10;i++)
		{
			numbers[i]=BM.CreateBitmap(id_num[i],25,50);
		}
		for(int i=0;i<9;i++)
		{
			bombEffect[i]=BM.CreateBitmap(id_bomb[i],80,80);
		}
		for(int i=0;i<9;i++)
		{
			lifeEffect[i]=BM.CreateBitmap(id_life[i],80,80);
		}
		for(int i=0;i<8;i++)
		{
			ScoreProp[i]=BM.CreateBitmap(id_score[i],60,60);
		}
		en_1=BM.CreateBitmap(R.drawable.en1, 80, 80);
		en_3=BM.CreateBitmap(R.drawable.rock_mini,60,60);
		bulletTrack=BM.CreateBitmap(R.drawable.trackblt, 8,16);
		en_2=BM.CreateBitmap(R.drawable.en2,80,80);
		leftBoard=BM.CreateBitmap(R.drawable.leftborder,SWidth/4,110);
		rightBoard=BM.CreateBitmap(R.drawable.rightborder,SWidth/4,110);
		centerBoard=BM.CreateBitmap(R.drawable.bottomborder,SWidth/2,80);
		btnNormal=BM.CreateBitmap(R.drawable.btnnormal, 100, 100);
		btnBomb=BM.CreateBitmap(R.drawable.btnbomb,100,100);
		btnLife=BM.CreateBitmap(R.drawable.btnlife,100,100);
		lifeBar=BM.CreateBitmap(R.drawable.lifebar, 210, 39);
		lifeBorder=BM.CreateBitmap(R.drawable.lifeborder, 217,54);
		btnpause=BM.CreateBitmap(R.drawable.btnpause,100,100);
		btnplay=BM.CreateBitmap(R.drawable.btnplay,100,100);
		boss=BM.CreateBitmap(R.drawable.boss1,152,92);
		en_5=BM.CreateBitmap(R.drawable.enemy5,70,70);
		Winviewbg=BM.CreateBitmap(R.drawable.winviewbg,GameInfo.SWidth,GameInfo.SHeight);
		MediumWBtn=BM.CreateBitmap(R.drawable.mediumbtn,100,100);
		PowerWBtn=BM.CreateBitmap(R.drawable.powerbtn,100,100);
		Wintitle=BM.CreateBitmap(R.drawable.wintitle,300,200);
		backBtn=BM.CreateBitmap(R.drawable.backbtn,120, 70);
		Losetitle=BM.CreateBitmap(R.drawable.losetitle,300,200);
		
		play1=BM.CreateBitmap(R.drawable.play1);
		shop=BM.CreateBitmap(R.drawable.shop);
		gradeboard=BM.CreateBitmap(R.drawable.paihang);
		back=BM.CreateBitmap(R.drawable.back);
		
		menubg=BM.CreateBitmap(R.drawable.menubg,GameInfo.SWidth,GameInfo.SHeight);
	}
	
}
