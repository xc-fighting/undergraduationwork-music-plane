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

public class gameloseview extends View{

	GameSumActivity gsa;
	Paint p;
	sprite backbtn;
	DBAdapter db;
	
	public gameloseview(Context context,GameSumActivity gsa) {
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
		c.drawBitmap(GameInfo.Winviewbg,0,0,p);
		c.drawBitmap(GameInfo.Losetitle,GameInfo.SWidth/2-GameInfo.Losetitle.getWidth()/2,GameInfo.SHeight/4,p);
		backbtn.draw(c);
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
					db.close_db();
					Intent intent=new Intent();
					intent.setClass(this.gsa,WelcomeActivity.class);
					this.gsa.startActivity(intent);
					this.gsa.finish();
				}
			}break;
		
		}
		return true;
	}

}
