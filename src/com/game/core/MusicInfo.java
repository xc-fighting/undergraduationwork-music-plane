package com.game.core;

public class MusicInfo {

	String title;
	int Min;
	int Sec;
	String artist;
	String time;
	String addr;
	public MusicInfo(String t,int duration,String art,String addr)
	{
		this.title=t;
		this.artist=art;
		this.Min=duration/1000/60;
		this.Sec=duration/1000%60;
		time=Min+"·Ö"+Sec+"Ãë";
		this.addr=addr;
	}
	
	public String getTime()
	{
		return this.time;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getArtist()
	{
		return this.artist;
	}
	
	public String getAddr()
	{
		return this.addr;
	}
	
	
}
