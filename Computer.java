public class Computer{

	double reach , xposcomp, yposcomp,jump,xvelcomp,yvelcomp;int point=0,count=0,win=0,d,j;
	int flag=0;

	public Computer(double xpos1 , double ypos1,double vx,double vy)
	{	
		xposcomp = xpos1;
		yposcomp = ypos1;xvelcomp = vx;yvelcomp = vy;
	}

	public double mod(double a)
	{
		if(a<0)
		{
		return -a;
		}
		else
		{
		return a;
		}
	}

	public void pointi()
	{	point=point +1;
		System.out.println("                              comp class comp point "+point);
	}

	public void win()
	{	win = 1;
	}

	public void isreach(double a , double b , double n)			//DECIDES WHETHER HITPOINT OF BALL OUT OF REACH OR NOT
	{
		if((mod(a-xposcomp) )<= n) 
		{	
			reach = 1;
		}
		else 	
		{
			reach = 0;
		}

	}

	public void isjump(double xball, double yball,double xvelball)		//DECIDES WHEN COMPUTER JUMPS
	{
		if(dis(xball,yball,xposcomp,yposcomp) <= (175*175) && yball<yposcomp && ((xball-xposcomp)*(xvelball)<0))
	  	{
			jump = 1;
		}
		else 
		{
			jump = 0;
		}
	}


	public void compmove(double a , double b)				//FUNCTION DECIDING THE VELOCITY OF COMPUTER
	{
		if(flag==1)
		{
			
			if(yposcomp==450)
			{
				yvelcomp=0;
				flag=0;
				System.out.println(flag);
				System.out.println(yposcomp);
			}
			else
			{
				yvelcomp = yvelcomp + 0.15;
			}
			xvelcomp = dir(a,b);
		}
	
		else if(reach ==0)
	        {
			if(jump == 1)
			{
				yvelcomp = -5;
				xvelcomp = dir(a,b);j=1;
				flag=1;
			}
			else if(jump == 0) 
			{
				xvelcomp = dir(a,b);d=1;
			}
	  	}

	        if(reach == 1)
		{ xvelcomp = dir(a,b);}



	}

	public double dir(double x ,double y)					//FUNCTION TO DECIDE WHETHER COMPUTER MOVES RIGHT OR LEFT
	{
		double ans;
		if(((xposcomp+50)<=1200)&&((xposcomp-50)>=700))
		{
			if((x - xposcomp) > 0) {ans= 1;}
			else if ((x-xposcomp)==0){ans= 0;}
			else {ans= -1;}
		}
		else if(xposcomp+50>1200){ans=-1;} else{ans=1;}
		return ans;
	}


	public double  dis(double x1 , double y1, double x2 , double y2)	//FUNCTION TO CALCULATE DISTANCE B/W TWO POINTS
	{
		return ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}


	public void comptrajectory()						//FUNCTION THAT CHANGES THE COORDINATES OF THE COMPUTER
	{
		xposcomp = xposcomp+xvelcomp;
		yposcomp = Math.min(yposcomp+yvelcomp,450);
	}



}
