package com.game.thread;



import com.game.core.GameLevel;
import com.game.core.TouchListener;
import com.game.scene.GameScene;
import com.game.view.gameview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MainGameThread extends Thread{

	SurfaceHolder holder;
	Canvas canvas;
	public GameScene scene;
	
	GameLevel gameLevel;
	
	Paint p;
	TouchListener tl;
	gameview gview;
	
	
	
	public MainGameThread(gameview view,SurfaceHolder holder,TouchListener tl,String path)
	{
		
		gview=view;
		this.holder=holder;
		p=new Paint();
		this.tl=tl;
		scene=new GameScene(gview);
		scene.InitScene();
		tl.setScene(scene);
		gameLevel=new GameLevel(scene,10);
		gameLevel.start();
		
		
	}
	
	public void run()
	{
		
		while(gameview.isGameOn)
		{
			if(gameview.isGamePause==false)
			{
				if(holder!=null)
				{
					try
					{
						synchronized(holder)
						{
						canvas=holder.lockCanvas();						
						scene.draw(canvas);	
						sleep(1000/60);
						}
	
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(canvas!=null)
							holder.unlockCanvasAndPost(canvas);
					}
					
				
				}
			}
		}
		scene.destroy();
	}
	
	public void Destroy()
	{
		gameview.isGameOn=false;
		try {
			this.join();
			scene.destroy();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
