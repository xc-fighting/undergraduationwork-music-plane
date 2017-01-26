package com.game.view;

import java.util.ArrayList;
import java.util.List;

import com.game.activity.MenuActivity;
import com.game.core.GameInfo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class menuview extends SurfaceView implements SurfaceHolder.Callback{

	MenuActivity menu;
	MenuAnmiThread thread;
	List<Bitmap> buttonlist=new ArrayList<Bitmap>();
	
	
	int currentIndex=0;				//��ǰѡ�еĲ˵����	
	float mPreviousX;				//�ϴδ��ص�X����
	float mPreviousY;				//�ϴδ��ص�Y����	
	float changePercent=0;			//�������еİٷֱ�
	int anmiState=0;				//0-û�ж���  1-������  2-������
	
	float currentSelectWidth;			//��ǰ�˵�����
	float currentSelectHeight;		//��ǰ�˵���߶�
	float currentSelectX;			//��ǰ�˵���Xλ��
	float currentSelectY;			//��ǰ�˵���Yλ��	
			
	float leftWidth;				//���ڵ�ǰ�˵������˵���Ŀ��		
	float leftHeight;				//���ڵ�ǰ�˵������˵���ĸ߶�	
	float tempxLeft;				//���ڵ�ǰ�˵������˵����X����
	float tempyLeft;				//���ڵ�ǰ�˵������˵����Y����	
	
	float rightWidth;				//���ڵ�ǰ�˵����Ҳ�˵���Ŀ��	
	float rightHeight;				//���ڵ�ǰ�˵����Ҳ�˵���ĸ߶�	
	float tempxRight;				//���ڵ�ǰ�˵����Ҳ�˵����X����
	float tempyRight;				//���ڵ�ǰ�˵����Ҳ�˵����Y����	
	
	
	
	    public boolean repeat=true;
	
		static float bigWidth;		//ѡ�в˵���Ŀ��
		static float bigHeight;		//ѡ�в˵���ĸ߶�
		static float smallWidth;		//δѡ�в˵���Ŀ��
		static float smallHeight;//δѡ�в˵���ĸ߶�
	    
		static float selectX;//ѡ�в˵����������Ļ�ϵ�Xλ��
		static float selectY;		//ѡ�в˵����ϲ�����Ļ�ϵ�Yλ��
	
	
	
		static int span=10;							//�˵���֮��ļ��
		static int slideSpan=30;					//������ֵ
		
		static int totalSteps=10;					//�������ܲ���
		static float percentStep=1.0f/totalSteps;	//ÿһ���Ķ����ٷֱ�
		static int timeSpan=20;						//ÿһ�������ļ��ʱ��
	
	
	public menuview(Context menu) {
		super(menu);
		// TODO Auto-generated constructor stub
		this.menu=(MenuActivity)menu;
		this.getHolder().addCallback(this);
		setFocusableInTouchMode(true);
		GameInfo.InitImageResource(this);
	
		
		buttonlist.add(GameInfo.play1);
		buttonlist.add(GameInfo.gradeboard);
		buttonlist.add(GameInfo.shop);
		buttonlist.add(GameInfo.back);
		
		this.init();
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		this.repaint();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void repaint()
	{
		SurfaceHolder holder=this.getHolder();		//SurfaceHolder
		Canvas canvas = holder.lockCanvas();		//��ȡ����
		try{
			synchronized(holder){
				Draw(canvas);						//����
			}			
		}
		catch(Exception e){e.printStackTrace();}
		finally
		{
			if(canvas != null){
				holder.unlockCanvasAndPost(canvas);
			}
		}
	}
	
	
	
	
	public boolean onTouchEvent(MotionEvent e)
	{

    	if(anmiState!=0)
    	{//�������������򴥿���Ч
    		return true;
    	}
    	//��ȡ��ǰ���ص��XY����
        float x = e.getX();
        float y = e.getY();
        //���ݴ��صĲ�ͬ����ִ�в�ͬ��ҵ���߼�
        switch (e.getAction())  
        {
        	case MotionEvent.ACTION_MOVE:
        		break;
        	case MotionEvent.ACTION_DOWN:
        	{
        	  //������Ϊ���´��ر����¼XYλ��
        	  mPreviousX=x;//��¼���ر�Xλ��
        	  mPreviousY=y;//��¼���ر�Yλ��
        	  
        	}
            break;
            case MotionEvent.ACTION_UP:
            {
              //������Ϊ̧�������Xλ�ƵĲ�ִͬ���󻬡��һ���ѡ�в˵����ҵ���߼�	
              float dx=x- mPreviousX; //����Xλ��
              if(dx<-slideSpan)
              {//��Xλ��С����ֵ�����󻬶�
            	  if(currentIndex<buttonlist.size()-1)
            	  {//����ǰ�˵�������һ���˵��������󻬶�
            		  //���㻬����ɺ�ĵ�ǰ�˵�����
            		  int afterCurrentIndex=currentIndex+1;
            		  //����״ֵ̬����Ϊ2-������
            		  anmiState=2;
            		  //�����̲߳��Ŷ���������״ֵ̬
            		  thread=new MenuAnmiThread();
            		  thread.set_after(afterCurrentIndex);
            		  thread.start();
            	  } 
              }
              else if(dx>slideSpan)
              {//��Xλ�ƴ�����ֵ�����һ���
            	  if(currentIndex>0)
            	  {//����ǰ�˵���ǵ�һ���˵��������󻬶�
            		  //���㻬����ɺ�ĵ�ǰ�˵�����
            		  int afterCurrentIndex=currentIndex-1;
            		  //����״ֵ̬����Ϊ2-������
            		  anmiState=1;
            		  //�����̲߳��Ŷ���������״ֵ̬
            		  thread=new MenuAnmiThread();
            		  thread.set_after(afterCurrentIndex);
            		  thread.start();
            	  }            	  
              }
              else
              {
            	  if(			//��Xλ������ֵ�����ж��з�ѡ��ĳ�˵���
                     mPreviousX>selectX&&mPreviousX<selectX+bigWidth&&
                     mPreviousY>selectY&&
                     mPreviousY<selectY+buttonlist.get(currentIndex).getHeight()&&
                     x>selectX&&x<selectX+bigWidth&&
                     y>selectY&&y<selectY+buttonlist.get(currentIndex).getHeight()
            	  )
            	  {
            		menu.handler.sendEmptyMessage(currentIndex);
            	  }
              }                
            }              
            break;            
        }   
        return true;        
                
        
	}
	
	
	
	
	//�˵������߳�
		public class MenuAnmiThread extends Thread{
			
			int afterCurrentIndex;				//����������ɺ�ĵ�ǰ�˵����
			menuview mv;
			
			public MenuAnmiThread()
			{
				mv=menuview.this;
			}
			
			public void set_after(int index)
			{
				this.afterCurrentIndex=index;
			}
			
			public void run()
			{
					
				for(int i=0;i<=totalSteps;i++)
				{		//ѭ��ָ���Ĵ�����ɶ���
					mv.changePercent=percentStep*i;	//����˲��İٷֱ�
					mv.init();					//��ʼ������λ��ֵ			
					if(menuview.this.anmiState==1)
					{	//���ҵĶ���
						//���ݰٷֱȼ��㵱ǰ�˵���λ�á���С
						mv.currentSelectX=menuview.this.currentSelectX+(bigWidth+span)*mv.changePercent;
						mv.currentSelectY=mv.currentSelectY+(bigHeight-smallHeight)*mv.changePercent;
						mv.currentSelectWidth=(int)(smallWidth+(bigWidth-smallWidth)*(1-mv.changePercent));
						mv.currentSelectHeight=(int)(smallHeight+(bigHeight-smallHeight)*(1-mv.changePercent));
						//���ڶ������ң����˵��������˼������˵����С
						mv.leftWidth=(int)(smallWidth+(bigWidth-smallWidth)*mv.changePercent);
						mv.leftHeight=(int)(smallHeight+(bigHeight-smallHeight)*mv.changePercent);				
					}
					else if(mv.anmiState==2)
					{	//����Ķ���
						//���ݰٷֱȼ��㵱ǰ�˵���λ�á���С
						mv.currentSelectX=mv.currentSelectX-(smallWidth+span)*mv.changePercent;
						mv.currentSelectY=mv.currentSelectY+(bigHeight-smallHeight)*mv.changePercent;
						mv.currentSelectWidth=(int)(smallWidth+(bigWidth-smallWidth)*(1-mv.changePercent));
						mv.currentSelectHeight=(int)(smallHeight+(bigHeight-smallHeight)*(1-mv.changePercent));
						//���ڶ��������Ҳ�˵��������˼����Ҳ�˵����С
						mv.rightWidth=(int)(smallWidth+(bigWidth-smallWidth)*mv.changePercent);
						mv.rightHeight=(int)(smallHeight+(bigHeight-smallHeight)*mv.changePercent);					
					}
					
					//������������Ĳ˵���λ��
					mv.tempxLeft=mv.currentSelectX-(span+mv.leftWidth);			
					mv.tempyLeft=mv.currentSelectY+(mv.currentSelectHeight-mv.leftHeight);	
					//����������Ҳ�Ĳ˵���λ��
					mv.tempxRight=mv.currentSelectX+(span+mv.currentSelectWidth);
					mv.tempyRight=mv.currentSelectY+(mv.currentSelectHeight-mv.rightHeight);
				
					mv.repaint();				//�ػ滭��
					try{
						Thread.sleep(timeSpan);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						}
				}
				
				mv.anmiState=0;						//������ɺ����ö���״̬Ϊ0-�޶���		
				mv.currentIndex=afterCurrentIndex; 	//������ɺ���µ�ǰ�Ĳ˵�����
				mv.init();							//��ʼ������λ��ֵ
				mv.repaint();						//�ػ滭��
			}
			
		}
	
	
	
		public void init()
		{
			
			
			bigWidth=200;
			bigHeight=200;;
			smallWidth=100;
			smallHeight=100;
			selectX=GameInfo.SWidth/2-bigWidth/2;
			selectY=GameInfo.SHeight*3/4-bigHeight/2;
			
			
			this.currentSelectWidth=bigWidth;		//��ǰѡ�в˵����
			this.currentSelectHeight=bigHeight;		//��ǰѡ�в˵��߶�
			this.currentSelectX=selectX;				//��ǰѡ�в˵�Xλ��
			this.currentSelectY=selectY;				//��ǰѡ�в˵�Yλ��	
			this.rightWidth=smallWidth;				//�����Ҳ�Ŀ��		
			this.leftWidth=smallWidth;				//�������Ŀ��		
			this.leftHeight=smallHeight;				//�������ĸ߶�	
			this.rightHeight=smallHeight;			//�����Ҳ�ĸ߶�
			this.tempxLeft=currentSelectX-(span+leftWidth);					//��������X
			this.tempyLeft=currentSelectY+(currentSelectHeight-leftHeight);	//��������Y����	
			this.tempxRight=currentSelectX+(span+currentSelectWidth);		//�����Ҳ��X	
			this.tempyRight=currentSelectY+(currentSelectHeight-rightHeight);//�����Ҳ��Y����
			
		
			
			
			
			
		}
	
		public void Draw(Canvas canvas)
		{
			//������
			canvas.drawBitmap(GameInfo.menubg, 0,0,null);
			
			//��ȡ��ǰͼƬ
			Bitmap selectBM=this.buttonlist.get(currentIndex);
			//���ݲ�����������ڻ��Ƶ�ǰ�˵����ͼƬ
					selectBM=Bitmap.createScaledBitmap(
							selectBM, 
							(int)currentSelectWidth, 
							(int)currentSelectHeight, 
							true
					);
						
					//���Ƶ�ǰ�Ĳ˵���
					canvas.drawBitmap(selectBM, currentSelectX, currentSelectY,null);
			//����ǰ�˵���ǵ�һ������ƽ��ڵ�ǰ�˵������Ĳ˵���
					if(currentIndex>0){	
						//���ų�������ͼƬ
						Bitmap left=Bitmap.createScaledBitmap
						(
								this.buttonlist.get(currentIndex-1), 
								(int)leftWidth, 
								(int)leftHeight, 
								true
						);		
						//����ͼƬ
						canvas.drawBitmap(left, tempxLeft, tempyLeft,null);
					}	
					
					//����ǰ�˵�������һ������ƽ��ڵ�ǰ�˵����Ҳ�Ĳ˵���
					if(currentIndex<buttonlist.size()-1)
					{
						Bitmap right=Bitmap.createScaledBitmap	//���ų�������ͼƬ
						(
								buttonlist.get(currentIndex+1), 
								(int)rightWidth, 
								(int)rightHeight, 
								false
						);	
						canvas.drawBitmap(right, tempxRight, tempyRight, null);//����ͼƬ
					}
					
					
					

					//�����������δѡ�еĲ˵�
					for(int i=currentIndex-2;i>=0;i--){	
						float tempx=tempxLeft-(span+smallWidth)*(currentIndex-1-i);//����Xֵ
						if(tempx<-smallWidth){								//�����Ƴ���������Ļ�����û�����
							break;
						}
						int tempy=(int)(selectY+(bigHeight-smallHeight));			//����Yֵ
						Bitmap tempbm=Bitmap.createScaledBitmap				//���ų�������ͼƬ
						(
								buttonlist.get(i), 
								(int)smallWidth, 
								(int)smallHeight, 
								true
						);
						canvas.drawBitmap(tempbm, tempx, tempy,null);	//����ͼƬ
					}
					
					for(int i=currentIndex+2;i<buttonlist.size();i++)			//���һ�������δѡ�еĲ˵�
					{	
						//����Xֵ
			            float tempx=tempxRight+rightWidth+span+(span+smallWidth)*(i-(currentIndex+1)-1);			
						if(tempx>GameInfo.SWidth)
						{//�����Ƴ���������Ļ�����û�����
							break;
						}			
						
						int tempy=(int)(selectY+(bigHeight-smallHeight));		//����Yֵ	
						Bitmap tempbm=Bitmap.createScaledBitmap			//���ų�������ͼƬ
						(
								buttonlist.get(i), 
								(int)smallWidth, 
								(int)smallHeight, 
								true
						);	
						//����ͼƬ
						canvas.drawBitmap(tempbm, tempx, tempy,null);		
					}
					
									
					
			
									
					
					
		}
	
	

}
