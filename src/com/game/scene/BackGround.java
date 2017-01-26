package com.game.scene;

import com.game.core.GameInfo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class BackGround {
  public Rect ScrRect_Y_Up;
  public Rect ScrRect_Y_DOWN;
  public Rect DetRect_Y_UP;
  public Rect DetRect_Y_DOWN;
  Bitmap image;
  public static float v;
  float y;
  float ry;
  
  
  Paint p;
  
  public BackGround(Bitmap bitmap,float vy)
  {
	  image=bitmap;
	  ScrRect_Y_Up=new Rect();
	  ScrRect_Y_DOWN=new Rect();
	  DetRect_Y_UP=new Rect();
	  DetRect_Y_DOWN=new Rect();
	  v=vy;
	  y=0;
	  p=new Paint();
  }
  
  public void update()
  {
	  GameInfo.miles+=v;
	  y=y+v;
	  ry=y%GameInfo.SHeight;
	  this.ScrRect_Y_Up.set(0, 0,GameInfo.SWidth,GameInfo.SHeight);
	  this.DetRect_Y_UP.set(0,(int)ry,GameInfo.SWidth,GameInfo.SHeight);
	  if(ry>0)
	  {
		  this.ScrRect_Y_DOWN.set(0,(int)(GameInfo.SHeight-ry),GameInfo.SWidth,GameInfo.SHeight);
		  this.DetRect_Y_DOWN.set(0,0,GameInfo.SWidth,(int)ry);		  
	  }
	  else
	  {
		  this.ScrRect_Y_DOWN.setEmpty();
		  this.DetRect_Y_DOWN.setEmpty();
	  }
  }
  
  public void draw(Canvas c)
  {
	  c.drawBitmap(image,this.ScrRect_Y_Up,this.DetRect_Y_UP, p);
	  c.drawBitmap(image,this.ScrRect_Y_DOWN,this.DetRect_Y_DOWN,p);

	  
  }
  
}
