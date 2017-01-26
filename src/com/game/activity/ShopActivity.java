package com.game.activity;



import com.game.core.DBAdapter;
import com.game.core.GameInfo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import android.widget.TextView;

public class ShopActivity extends Activity{

	Dialog dlg;
	ListView shoplist;
	DBAdapter db;
	TextView moneyNum;
	TextView bloodCurNum;
	TextView bombCurNum;
	TextView mwCurNum;
	TextView pwCurNum;
	
	Button bloodbuybtn;
	Button bombbuybtn;
	Button MWbuybtn;
	Button PWbuybtn;
	Button back;
	
	Button confirmBuy;
	EditText numText;
	
	int[] price={1000,2000,5000,9000};
	int type;
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		db=new DBAdapter(this);
		db.createOrOpenDatabase();
		db.initAllItem();
		moneyNum=(TextView)this.findViewById(R.id.moneynum);
		bloodCurNum=(TextView)this.findViewById(R.id.bloodcurNum);
		bombCurNum=(TextView)this.findViewById(R.id.bombCurnum);
		mwCurNum=(TextView)this.findViewById(R.id.MWCurNum);
		pwCurNum=(TextView)this.findViewById(R.id.PWCurNum);
		
		moneyNum.setText("当前数量:"+GameInfo.score);
		bloodCurNum.setText("当前数量:"+GameInfo.NUM_Life);
		bombCurNum.setText("当前数量:"+GameInfo.NUM_Bomb);
		mwCurNum.setText("当前数量:"+GameInfo.NUM_MW);
		pwCurNum.setText("当前数量:"+GameInfo.NUM_PW);
		
		bloodbuybtn=(Button)this.findViewById(R.id.bloodbuybtn);
		bombbuybtn=(Button)this.findViewById(R.id.bombbuybtn);
		MWbuybtn=(Button)this.findViewById(R.id.MWBuyBtn);
		PWbuybtn=(Button)this.findViewById(R.id.pwbuybtn);
		back=(Button)this.findViewById(R.id.shopback);
		
		bloodbuybtn.setOnClickListener(new listener());
		bombbuybtn.setOnClickListener(new listener());
		MWbuybtn.setOnClickListener(new listener());
		PWbuybtn.setOnClickListener(new listener());
		back.setOnClickListener(new listener());
		
		dlg=new Dialog(this);
		dlg.setContentView(R.layout.buydialog);
		confirmBuy=(Button)dlg.findViewById(R.id.buyconfirm);
		confirmBuy.setOnClickListener(new listener());
		numText=(EditText)dlg.findViewById(R.id.numedit);
	}
	
	class listener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
				case R.id.bloodbuybtn:
				{
					type=0;
					dlg.show();
				}break;
				case R.id.bombbuybtn:
				{
					type=1;
					dlg.show();
				}break;
				case R.id.MWBuyBtn:
				{
					type=2;
					dlg.show();
				}break;
				case R.id.pwbuybtn:
				{
					type=3;
					dlg.show();
				}break;
				case R.id.buyconfirm:
				{
					int num=Integer.parseInt(numText.getText().toString());
					Toast.makeText(ShopActivity.this,num+":"+type,Toast.LENGTH_SHORT).show();
					int value=num*price[type];					
					if(value>GameInfo.score)
					Toast.makeText(ShopActivity.this,"金额不足，无法购买"+value,Toast.LENGTH_SHORT).show();
					else
					{
						GameInfo.score-=value;
						switch(type)
						{
							case 0:GameInfo.NUM_Life+=num;break;
							case 1:GameInfo.NUM_Bomb+=num;break;
							case 2:GameInfo.NUM_MW+=num;break;
							case 3:GameInfo.NUM_PW+=num;break;
						}
						moneyNum.setText("当前数量:"+GameInfo.score);
						bloodCurNum.setText("当前数量:"+GameInfo.NUM_Life);
						bombCurNum.setText("当前数量:"+GameInfo.NUM_Bomb);
						mwCurNum.setText("当前数量:"+GameInfo.NUM_MW);
						pwCurNum.setText("当前数量:"+GameInfo.NUM_PW);
						numText.setText("");
						
					}
					dlg.dismiss();
				}break;
				
				case R.id.shopback:
				{
					db.updateItem();
					db.close_db();
					Intent intent=new Intent();
					intent.setClass(ShopActivity.this,MenuActivity.class);
					ShopActivity.this.finish();
					ShopActivity.this.startActivity(intent);
					
				}break;
			
			}
			
		}
		
	}
	
	
}
