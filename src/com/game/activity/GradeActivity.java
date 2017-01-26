package com.game.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.game.core.DBAdapter;
import com.game.core.GradeInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class GradeActivity extends Activity{
	
	
	DBAdapter db;
	ListView lv;
	SimpleAdapter adapter;
	ArrayList<HashMap<String, Object>>listItem = new ArrayList<HashMap<String,Object>>();
	GradeInfo[] group;
	
	Button backbtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grade);
		lv=(ListView)this.findViewById(R.id.GradeList);
		db=new DBAdapter(this);
		db.createOrOpenDatabase();
		if(db.checkGradeNULL()==false)
		{	
			group=db.getGrades();
			for(int i=0;i<group.length;i++)
			{
	            HashMap<String,Object>item=new HashMap<String,Object>();			
				item.put("title",group[i].title);
				item.put("time",group[i].time);
				item.put("score",group[i].score);
				item.put("mile",group[i].miles);
				listItem.add(item);
			}
			adapter= new SimpleAdapter(this,listItem,R.layout.gradelaylout,
					 new String[]{"title","time","score","mile"},
					 new int[]{R.id.Title,R.id.Time,R.id.Score,R.id.Mile});
			lv.setAdapter(adapter);
		}
		backbtn=(Button)this.findViewById(R.id.gradeback);
		backbtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(GradeActivity.this,MenuActivity.class);
				GradeActivity.this.finish();
				GradeActivity.this.startActivity(intent);
			}
			
		});
	}
	
	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		db.close_db();
	}

}
