package com.game.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeActivity extends Activity {

	 private ViewPager viewpager = null;
	 private List<View> list = null;
	 private ImageView[] img = null;
	 
	 Button btn;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);	
		setContentView(R.layout.activity_welcome);
        viewpager=(ViewPager)this.findViewById(R.id.viewpager);
		list=new ArrayList<View>();
		list.add(this.getLayoutInflater().inflate(R.layout.tab1,null));
		list.add(this.getLayoutInflater().inflate(R.layout.tab2,null));
		list.add(this.getLayoutInflater().inflate(R.layout.tab3,null));
		list.add(this.getLayoutInflater().inflate(R.layout.tab4,null));
		list.add(this.getLayoutInflater().inflate(R.layout.tab5,null));
		list.add(this.getLayoutInflater().inflate(R.layout.tab6,null));
		img=new ImageView[list.size()];
		 LinearLayout layout = (LinearLayout) findViewById(R.id.viewGroup);
	        for (int i = 0; i < list.size(); i++) {
	            img[i] = new ImageView(WelcomeActivity.this);
	            if (0 == i) {
	                img[i].setBackgroundResource(R.drawable.page_indicator_focused);
	            } else {
	                img[i].setBackgroundResource(R.drawable.page_indicator);
	            }
	            img[i].setPadding(0, 0, 20, 0);
	            layout.addView(img[i]);
	        }
	        viewpager.setAdapter(new ViewPagerAdapter(list));
	        viewpager.setOnPageChangeListener(new ViewPagerPageChangeListener());
		   btn=(Button)list.get(5).findViewById(R.id.welcomeend);
		   btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(WelcomeActivity.this,MenuActivity.class);
				WelcomeActivity.this.startActivity(intent);
				WelcomeActivity.this.finish();
			}
			   
		   });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_welcome, menu);
		return true;
	}
	
	
	class ViewPagerPageChangeListener implements OnPageChangeListener {
		 
        /*
         * state������ͨ��˵����1��ʱ���ʾ���ڻ�����2��ʱ���ʾ��������ˣ�0��ʱ���ʾʲô��û��������ͣ���ǣ�
         * �ҵ���Ϊ��1�ǰ���ʱ��0���ɿ���2�����µı�ǩҳ���Ƿ񻬶���
         * (���磺��ǰҳ�ǵ�һҳ����������һ������ӡ��2���������ֱ�������˵ڶ�ҳ����ô�ͻ��ӡ��2��)��
         * ������Ϊһ��������ǲ�����д���������
         */
        @Override
        public void onPageScrollStateChanged(int state) {
        }
 
        /*
         * page�������ƾͿ��ó�����ǰҳ�� positionOffset��λ��ƫ��������Χ[0,1]��
         * positionoffsetPixels��λ�����أ���Χ[0,��Ļ���)�� ������Ϊһ��������ǲ�����д���������
         */
        @Override
        public void onPageScrolled(int page, float positionOffset,
                int positionOffsetPixels) {
        }
 
        @Override
        public void onPageSelected(int page) {
            //����ͼ��
            for (int i = 0; i < list.size(); i++) {
                if (page == i) {
                    img[i].setBackgroundResource(R.drawable.page_indicator_focused);
                } else {
                    img[i].setBackgroundResource(R.drawable.page_indicator);
                }
            }
        }
    }
	
	
	
	class ViewPagerAdapter extends PagerAdapter {
		 
        private List<View> list = null;
 
        public ViewPagerAdapter(List<View> list) {
            this.list = list;
        }
 
        @Override
        public int getCount() {
            return list.size();
        }
 
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }
 
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
 
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
 
    }

}
