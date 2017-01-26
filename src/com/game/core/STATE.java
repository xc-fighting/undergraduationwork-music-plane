package com.game.core;

public abstract class STATE {

	Object obj;
	public STATE(Object o)
	{
		this.obj=o;
	}
	public abstract STATE toNextState();
	public abstract void execute();
}
