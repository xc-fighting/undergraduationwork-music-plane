package com.game.activity;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.game.core.GameInfo;
import com.game.core.MusicInfo;

import android.app.Activity;
import android.app.Dialog;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.provider.MediaStore;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;



public class MusicSelectionActivity extends Activity{

	private Cursor cursor;
	Context ctx;
	ContentResolver resolver;
	ListView musicList;
	String content="";
	
	List<MusicInfo> musiclist=new ArrayList<MusicInfo>();
	ArrayList<HashMap<String, Object>>listItem = new ArrayList<HashMap<String,Object>>();
	
	SimpleAdapter adapter;
	
	Dialog dlg;
	Button confirmbtn;
	Button cancelbtn;
	int index;
	
	Dialog dlg1;
	Button okbtn;
	Button nobtn;
	Button musicback;
	
	public static String title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.musicsel);
		musicList=(ListView)this.findViewById(R.id.musiclist);
	    ctx=MusicSelectionActivity.this;
		resolver=ctx.getContentResolver();
		cursor=resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,
				null,null,MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
		cursor.moveToFirst();
		for(int i=0;i<cursor.getCount();i++)
		{
			
			int d= cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
			String title=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
			String artist=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
			String addr=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
		
			MusicInfo MI=new MusicInfo(title,d,artist,addr);
			
			HashMap<String,Object>item=new HashMap<String,Object>();
			
			item.put("title",MI.getTitle());
			item.put("artist",MI.getArtist());
			item.put("time",MI.getTime());
			listItem.add(item);
			
			musiclist.add(MI);
			cursor.moveToNext();
		}
		cursor.close();
		
		adapter= new SimpleAdapter(this,listItem,R.layout.listlayout,
				 new String[]{"title","artist","time"},
				 new int[]{R.id.title,R.id.artist,R.id.time});
		
		musicList.setAdapter(adapter);
		musicList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			   dlg.show();
			   index=arg2;
				
			}
			
		});
		
		dlg=new Dialog(MusicSelectionActivity.this,R.style.MyDialog);
		dlg.setContentView(R.layout.dialog);
		confirmbtn=(Button) dlg.findViewById(R.id.dialog_button_ok);
		cancelbtn=(Button)dlg.findViewById(R.id.dialog_button_cancel);
		confirmbtn.setOnClickListener(new MyListener());
		cancelbtn.setOnClickListener(new MyListener());
		
		dlg1=new Dialog(MusicSelectionActivity.this,R.style.MyDialog);
		dlg1.setContentView(R.layout.dialog1);
		okbtn=(Button)dlg1.findViewById(R.id.dialog_ok);
		nobtn=(Button)dlg1.findViewById(R.id.dialog_cancel);
		okbtn.setOnClickListener(new MyListener());
		nobtn.setOnClickListener(new MyListener());
		
		musicback=(Button)this.findViewById(R.id.musicback);
		musicback.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MusicSelectionActivity.this,MenuActivity.class);
				MusicSelectionActivity.this.startActivity(intent);
				MusicSelectionActivity.this.finish();
			}
			
		});
		
	}
	
	class MyListener implements OnClickListener{

		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
			case R.id.dialog_button_ok:
			{
				confirmbtn.setBackgroundResource(R.drawable.btnokpressed);
				dlg.dismiss();
				dlg1.show();

			}break;
			case R.id.dialog_button_cancel:
			{
				cancelbtn.setBackgroundResource(R.drawable.btncancelpressed);
				dlg.dismiss();
			}break;
			case R.id.dialog_cancel:
			{
				GameInfo.USE_WEAPON=true;
				cancelbtn.setBackgroundResource(R.drawable.btncancelpressed);
				Intent intent=new Intent();
				intent.setClass(MusicSelectionActivity.this,GameActivity.class);
				Bundle bundle=new Bundle();
				bundle.putString("PATH",musiclist.get(index).getAddr());
				title=musiclist.get(index).getTitle();
				intent.putExtras(bundle);
				MusicSelectionActivity.this.startActivity(intent);
				MusicSelectionActivity.this.finish();
				dlg1.dismiss();
				
			}break;
			case R.id.dialog_ok:
			{
				GameInfo.USE_WEAPON=false;
				confirmbtn.setBackgroundResource(R.drawable.btnokpressed);
				Intent intent=new Intent();
				intent.setClass(MusicSelectionActivity.this,GameActivity.class);
				Bundle bundle=new Bundle();
				bundle.putString("PATH",musiclist.get(index).getAddr());
				title=musiclist.get(index).getTitle();
				intent.putExtras(bundle);
				MusicSelectionActivity.this.startActivity(intent);
				MusicSelectionActivity.this.finish();
				dlg1.dismiss();
				
			}break;
			
			}
			
		}
		
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		dlg.dismiss();
		
	}
	
	

	
	
	
	
}
