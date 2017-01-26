package com.game.view;
import com.game.core.TouchListener;
import com.game.thread.MainGameThread;
import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class gameview  extends SurfaceView implements SurfaceHolder.Callback{

	private SurfaceHolder holder;
	private MainGameThread thread;
	
	TouchListener listener;
	public static boolean isGameOn=true;
	public static boolean isGamePause=false;
	public String filepath;
    
	int value=0;
	
	public gameview(Context context,String path) {
		super(context);
		// TODO Auto-generated constructor stub
		filepath=path;
		holder=getHolder();
		holder.addCallback(this);
		setFocusableInTouchMode(true);
		listener=new TouchListener();
		this.setOnTouchListener(listener);		
	}
	
	
	public void update(byte[] model)
	{
		int sum=0;
		for(int i=0;i<9;i++)
		{
			
			sum+=(int)model[i];
		}
		int ave=sum/9;
		if(ave>20)
		{
			thread.scene.player.fire2();
		}
		else
		{
			thread.scene.player.fire1();
		}
	}
	

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub		
		thread=new MainGameThread(this,holder,listener,filepath);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub		
		thread=null;
		
	}

}
