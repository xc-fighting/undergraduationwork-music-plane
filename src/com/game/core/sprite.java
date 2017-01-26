package com.game.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class sprite {

	public float posX;
	public float posY;
	public float centerX;
	public float centerY;
	public float vx;
	public float vy;
	public AABB collisionBody;
	Bitmap image;
	float width;
	float height;
	public Matrix matrix;
	Paint p;
	
	public sprite(Bitmap b)
	{
		this.image=b;
		this.width=image.getWidth();
		this.height=image.getHeight();
		p=new Paint();
		matrix=new Matrix();
	}
	
	
	public sprite(Bitmap img,float x,float y,float vx,float vy)
	{
		image=img;
		posX=x;
		posY=y;
		this.vx=vx;
		this.vy=vy;
		width=img.getWidth();
		height=img.getHeight();
		centerX=posX+width/2;
		centerY=posY+height/2;
		matrix=new Matrix();
		matrix.setTranslate(posX,posY);	
		collisionBody=new AABB(posX,posX+width,posY,posY+height);
		p=new Paint();
	}
	
	public sprite(Bitmap img,float x,float y)
	{
		image=img;
		posX=x;
		posY=y;
		vx=0;
		vy=0;
		width=image.getWidth();
		height=image.getHeight();
		centerX=posX+width/2;
		centerY=posY+height/2;
		matrix=new Matrix();
		matrix.setTranslate(x, y);
		collisionBody=new AABB(posX,posX+width,posY,posY+height);
		p=new Paint();
	}
	
	
    public Bitmap getImage()
    {
    	return this.image;
    }
    
    public void setImage(Bitmap b)
    {
    	this.image=b;
    	this.width=image.getWidth();
    	this.height=image.getHeight();
    	
    }
    
    public void resetImage(float width,float height,boolean flag)
    {
    	this.width=width;
    	this.height=height;
    	this.image=Bitmap.createScaledBitmap(this.image,(int)width,(int)height,flag);
    }
    
    public float getImgWidth()
    {
    	return this.width;
    }
    
    public float getImgHeight()
    {
    	return this.height;
    }
    
 
    
    public void draw(Canvas cc)
    {
    	cc.drawBitmap(image,matrix,p);
    }
    
	
    public boolean checkCollision(sprite sp)
    {
    	return this.collisionBody.check(sp.collisionBody);
    }
    
    public boolean checkTouch(float x,float y)
    {
    	if(x<=posX+width&&x>posX&&y>posY&&y<posY+height)
    		return true;
    	else return false;
    }
    
    public void update(float dx,float dy)
    {
    	this.posX+=dx;
    	this.posY+=dy;
    	this.matrix.setTranslate(posX,posY);
    	this.collisionBody.updateBox(dx, dy);
    	this.centerX+=dx;
    	this.centerY+=dy;
    	
    }
	
   
    
    
	
}
