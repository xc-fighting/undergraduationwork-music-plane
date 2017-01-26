package com.game.core;


import java.io.IOException;


import com.game.view.gameview;


import android.annotation.TargetApi;

import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.media.audiofx.Visualizer;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class MUSIC {

	MediaPlayer player;
	gameview view;
	Visualizer visualizer;
	Equalizer equalizer;
	

	public MUSIC(gameview v)
	{
		player=new MediaPlayer();

		this.view=v;	
		//player=MediaPlayer.create(view.getContext(),R.raw.menumusic);
		try {
			player.setDataSource(v.filepath);
			player.prepare();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(GameInfo.USE_WEAPON==false)
		setUp();
		
		
		
	}
	
	
	public void setUp()
	{
		
		final int maxCR=Visualizer.getMaxCaptureRate();
		visualizer=new Visualizer(player.getAudioSessionId());
		visualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[0]);
		visualizer.setDataCaptureListener(
				// 这个回调应该采集的是波形数据
						new Visualizer.OnDataCaptureListener() {
							public void onWaveFormDataCapture(Visualizer visualizer,
									byte[] bytes, int samplingRate) {
								
							}

							// 这个回调应该采集的是快速傅里叶变换有关的数据
							public void onFftDataCapture(Visualizer visualizer,
									byte[] fft, int samplingRate) {
								
								byte[] model = new byte[fft.length / 2 + 1];  
					            model[0] = (byte) Math.abs(fft[1]);  
					            int j = 1;  
					  
					            for (int i = 2; i < 18;) {  
					                model[j] = (byte) Math.hypot(fft[i], fft[i + 1]);  
					                i += 2;  
					                j++;  
					            }
					            view.update(model);
								
							}
						}, maxCR/10, false, true);
		visualizer.setEnabled(true);
		equalizer=new Equalizer(0,player.getAudioSessionId());
		equalizer.setEnabled(true);
		/*player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onCompletion(MediaPlayer player) {
				// TODO Auto-generated method stub
				visualizer.setEnabled(false);
				visualizer.release();
				equalizer.setEnabled(false);
				equalizer.release();
				visualizer=null;
				equalizer=null;
			}
		});*/
	}
	
	
	
	
	public void playMusic()
	{
		try
		{			
			
			player.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void pause()
	{
       player.pause();
	}
	
	
	
	public void Release()
	{
		if(player!=null)
		{
			player.release();
			player=null;
			if(GameInfo.USE_WEAPON==false)
			{
				visualizer.setEnabled(false);
				visualizer.release();
				equalizer.setEnabled(false);
				equalizer.release();
				visualizer=null;
				equalizer=null;
			}
		}
	}
	
	public int getMusicTime()
	{
		return player.getDuration();
	}
	
	public int getCurTime()
	{
		return player.getCurrentPosition();
	}
	
	
	
}
