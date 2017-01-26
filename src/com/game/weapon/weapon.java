package com.game.weapon;



import com.game.core.sprite;

public abstract class weapon {

	sprite sp;
	long shootTime;
	long freq;
	int type;
	public weapon(sprite s,long f,int t)
	{
		this.sp=s;
		this.freq=f;
		type=t;
	}
	public sprite getSprite()
	{
		return this.sp;
	}
	
	public abstract void fire();
	public abstract void Init();
	
}
