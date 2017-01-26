package com.game.core;




import java.util.Calendar;

import com.game.activity.MusicSelectionActivity;

import android.app.Activity;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.widget.Toast;

public class DBAdapter {

	Activity obj;
    public SQLiteDatabase database;    
    
	
	private final String grade_table="Grade_Info";
	private final String Item_table="Item_Info";	
	String dbCreate1="create table if not exists "+grade_table+"(MusicTitle text not null," +
			"time text not null,miles integer not null," +
			"grade integer not null)" ;
	String dbCreate2="create table if not exists "+Item_table+"(Itype text not null,Num integer not null)";
			
	
	public DBAdapter(Context context)
	{
		this.obj=(Activity)context;
	}
	
	
	
	public void createOrOpenDatabase()
	{
		try
		{
			
			database=SQLiteDatabase.openDatabase("/data/data/com.game.activity/user",null,
					SQLiteDatabase.OPEN_READWRITE|SQLiteDatabase.CREATE_IF_NECESSARY);
			Toast.makeText(obj,"数据库打开成功",Toast.LENGTH_SHORT).show();
			database.execSQL(dbCreate1);
			database.execSQL(dbCreate2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Toast.makeText(obj,"数据库错误"+e.toString(),Toast.LENGTH_SHORT).show();
		}
	}
	
	
	
	
	
	public void close_db()
	{
		if(database!=null)
		{
			try
			{
		      this.database.close();
		      Toast.makeText(obj, "数据库关闭成功",Toast.LENGTH_SHORT).show();
			}
			catch(Exception e)
			{
				Toast.makeText(obj,"数据库关闭错误"+e.toString(),Toast.LENGTH_SHORT).show();
			}
		  
		}
	}
	
	public boolean checkGradeNULL()
	{
		String sql="select count(*) from Grade_Info";
		Cursor cursor=this.database.rawQuery(sql, null);
		cursor.moveToFirst();
		if(cursor.getInt(0)==0)return true;
		else return false;
	}
	
	public boolean checkItemNULL()
	{
		String sql="select count(*) from Item_Info";
		Cursor cursor=this.database.rawQuery(sql, null);
		cursor.moveToFirst();
		if(cursor.getInt(0)==0)return true;
		else return false;
	}
	
	
	public void initDB()
	{
		String[] sql={"insert into Item_Info values('BOMB',1)",
				"insert into Item_Info values('LIFE',1)",
				"insert into Item_Info values('MWEAPON',1)",
				"insert into Item_Info values('PWEAPON',1)",
				"insert into Item_Info values('MONEY',200)"};
		for(int i=0;i<sql.length;i++)
		{
			this.database.execSQL(sql[i]);
		}
		
	}
	
	public void initAllItem()
	{
	   String sql="select * from Item_Info";	  
	   Cursor cursor=database.rawQuery(sql,null);
	   int []num=new int[5];
	   cursor.moveToFirst();
	   int count=cursor.getCount();
	   for(int i=0;i<count;i++)
	   {
		   num[i]=cursor.getInt(cursor.getColumnIndex("Num"));
		   cursor.moveToNext();
	   }
	   GameInfo.NUM_Bomb=num[0];
	   GameInfo.NUM_Life=num[1];
	   GameInfo.NUM_MW=num[2];
	   GameInfo.NUM_PW=num[3];
	   GameInfo.score=num[4];
	   
	}
	
	public void updateItem()
	{
		String str1="update Item_Info set Num="+GameInfo.NUM_Bomb+" where Itype='BOMB'";
		String str2="update Item_Info set Num="+GameInfo.NUM_Life+" where Itype='LIFE'";
		String str3="update Item_Info set Num="+GameInfo.NUM_MW+" where Itype='MWEAPON'";
		String str4="update Item_Info set Num="+GameInfo.NUM_PW+" where Itype='PWEAPON'";
		String str5="update Item_Info set Num="+GameInfo.score+" where Itype='MONEY'";
		database.execSQL(str1);
		database.execSQL(str2);
		database.execSQL(str3);
		database.execSQL(str4);
		database.execSQL(str5);
	    Toast.makeText(obj,"物品更新成功",Toast.LENGTH_SHORT).show();
	}
	
	public void InsertGrade()
	{
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int date=c.get(Calendar.DATE);
		int hour=c.get(Calendar.HOUR);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		String time=year+"年"+month+"月"+date+"日"+hour+":"+
		minute+":"+second;
		String str="insert into Grade_Info values('"
		+MusicSelectionActivity.title+
				"','"+time+"',"+GameInfo.miles/1000+","
				+GameInfo.score+")";

		database.execSQL(str);
		Toast.makeText(obj,str,Toast.LENGTH_SHORT).show();
	}
	
	
	public GradeInfo[] getGrades()
	{
		
		Cursor cursor=database.query(grade_table,
				new String[]{"MusicTitle","time","miles","grade"},
				null,null,null,null,null);
		int count=cursor.getCount();
		if(count==0) return null;
		GradeInfo[] gi=new GradeInfo[count];
		cursor.moveToFirst();
		for(int i=0;i<count;i++)
		{
			gi[i]=new GradeInfo();
			gi[i].title=cursor.getString(0);
			gi[i].time=cursor.getString(1);
			gi[i].miles=cursor.getInt(2);
			gi[i].score=cursor.getInt(3);
			cursor.moveToNext();
		}
		return gi;
	}
	
		
}
