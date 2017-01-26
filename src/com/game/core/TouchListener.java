package com.game.core;


import com.game.battleplane.enemyManager;
import com.game.effect.effectManager;
import com.game.gui.gamebutton;
import com.game.scene.GameScene;
import com.game.thread.WeaponFireThread;
import com.game.view.gameview;


import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class TouchListener implements OnTouchListener{

	
	GameScene scene;
	float Xprevious;
	float Yprevious;
	
	
	
	
	
	public void setScene(GameScene gs)
	{
		this.scene=gs;		
	}
	
	@Override
	public boolean onTouch(View view, MotionEvent motion) {
		// TODO Auto-generated method stub
	
		switch(motion.getAction())
		{
			case MotionEvent.ACTION_DOWN:
			{									
				Xprevious=scene.player.sp.posX;
				Yprevious=scene.player.sp.posY;
				float x=motion.getX();
				float y=motion.getY();
				for(int i=0;i<gamebutton.ButtonGroup.size();i++)
				{					
					if(gamebutton.ButtonGroup.get(i).isTouched(x, y))
					{
						switch(gamebutton.ButtonGroup.get(i).getType())
						{
						case 0:
							if(gamebutton.ButtonGroup.get(i).isPressed==false)
							{
								gameview.isGamePause=true;
								gamebutton.ButtonGroup.get(i).button.setImage(GameInfo.btnplay);
								gamebutton.ButtonGroup.get(i).isPressed=true;
								if(this.scene.musicPlayer!=null)
								this.scene.musicPlayer.pause();
							}
							else
							{
								gameview.isGamePause=false;
								gamebutton.ButtonGroup.get(i).button.setImage(GameInfo.btnpause);
								gamebutton.ButtonGroup.get(i).isPressed=false;
								if(this.scene.musicPlayer!=null)
								this.scene.musicPlayer.playMusic();
							}
							break;
						case 1:							
								if(GameInfo.NUM_Life>0)
								{
									scene.player.hp=scene.player.HPInit;								
									GameInfo.NUM_Life-=1;
								}								
							break;
						case 2:
						{							
								if(GameInfo.NUM_Bomb>0)
								{
									for(int j=0;j<enemyManager.enemy_list.size();j++)
									{
										enemyManager.enemy_list.get(j).getHurt(enemyManager.enemy_list.get(j).hp/2);
										effectManager.CreateEffect(0,enemyManager.enemy_list.get(j).sp.posX,
												enemyManager.enemy_list.get(j).sp.posY);
									}
									GameInfo.NUM_Bomb-=1;
								}							
						}break;
						case 3:
						{
							if(GameInfo.USE_WEAPON==true)
							{
								if(GameInfo.NUM_MW>0)
								{
									scene.player.changeWeapon(5);
									new WeaponFireThread(scene.player,10).start();
									GameInfo.NUM_MW-=1;
								}
							}
							
						}break;
						case 4:
						{
							if(GameInfo.USE_WEAPON==true)
							{
								if(GameInfo.NUM_PW>0)
								{
									scene.player.changeWeapon(6);
									new WeaponFireThread(scene.player,10).start();
									GameInfo.NUM_PW-=1;
								}
							}
							
						}break;
						
						}
					}
				}
				
			}break;
			case MotionEvent.ACTION_MOVE:
			{
				float dx=motion.getX()-Xprevious;
				float dy=motion.getY()-Yprevious;
				if(dx>0)scene.player.sp.setImage(GameInfo.player_right);
				else scene.player.sp.setImage(GameInfo.player_left);
				scene.player.update(dx, dy);
				
			}break;
			case MotionEvent.ACTION_UP:
			{
				scene.player.sp.setImage(GameInfo.player_normal);
			}break;
		}
					
				
		Xprevious=motion.getX();
		Yprevious=motion.getY();
		return true;
	}

}
