package com.game.core;

public class AABB {

  public float xmin;
  public float xmax;
  public float ymin;
  public float ymax;
  
  
  public AABB(float xmin,float xmax,float ymin,float ymax)
  {
	 this.xmin=xmin;
	 this.ymin=ymin;
	 this.xmax=xmax;
	 this.ymax=ymax;
  }
  
  public void updateBox(float xmin,float ymin,float xmax,float ymax)
  {
	  this.xmin=xmin;
	 this.ymin=ymin;
	  this.xmax=xmax;
	  this.ymax=ymax;
  }
  
  public void updateBox(float dx,float dy)
  {
	  xmin+=dx;
	  xmax+=dx;
	  ymin+=dy;
	  ymax+=dy;
  }
  
  public float calOverOne(float amax,float amin,float bmax,float bmin)
  {
	  float minMax=0;
	  float maxMin=0;
	  if(amax<bmax)
	  {
		  minMax=amax;
		  maxMin=bmin;
	  }
	  else
	  {
		  minMax=bmax;
		  maxMin=amin;
	  }
	  if(minMax>maxMin)
	  {
		  return minMax-maxMin;
		  
	  }
	  else return 0;
  }
  
  
  public boolean check(AABB b)
  {
	  float xOver=this.calOverOne(xmax, xmin, b.xmax,b.xmin);
	  float yOver=this.calOverOne(ymax, ymin,b.ymax,b.ymin);
	  return xOver>GameInfo.V_UNIT&&yOver>GameInfo.V_UNIT;
  }
  
  
  
}
