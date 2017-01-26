package com.game.view;


import com.game.activity.GameSumActivity;
import com.game.activity.WelcomeActivity;
import com.game.core.DBAdapter;
import com.game.core.GameInfo;
import com.game.core.sprite;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class gamewinview extends View{

	Paint p;
	sprite backbtn;
	GameSumActivity gsa;
	DBAdapter db;
	
	public gamewinview(Context context,GameSumActivity gsa) {
		super(context);
		// TODO Auto-generated constructor stub
		this.gsa=gsa;
		p=new Paint();
		backbtn=new sprite(GameInfo.backBtn,GameInfo.SWidth/2-GameInfo.backBtn.getWidth()/2
				,GameInfo.SHeight-300);
		db=new DBAdapter(gsa);
		db.createOrOpenDatabase();
	}
	
	@Override
	public void onDraw(Canvas c)
	{
		super.onDraw(c);
		c.drawBitmap(GameInfo.Winviewbg,0,0,p);
		c.drawBitmap(GameInfo.Wintitle,GameInfo.SWidth/2-GameInfo.Wintitle.getWidth()/2,
				GameInfo.SHeight/4, p);
		backbtn.draw(c);
		p.setARGB(255,255,255,0);
		p.setTextSize(35);
		c.drawText("玩家分数:"+GameInfo.score,GameInfo.SWidth/2-100,GameInfo.SHeight/2,p);
		c.drawText("飞行距离:"+(int)(GameInfo.miles/1000),GameInfo.SWidth/2-100,GameInfo.SHeight/2+50,p);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		float x=event.getX();
		float y=event.getY();
		switch(event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
			{
				if(backbtn.checkTouch(x, y))
				{
					db.updateItem();
					db.InsertGrade();
					db.close_db();
					Intent intent=new Intent();
					intent.setClass(gsa,WelcomeActivity.class);
					gsa.startActivity(intent);
					gsa.finish();
				}
			}break;
		}
		invalidate();
		return true;
	}

}
