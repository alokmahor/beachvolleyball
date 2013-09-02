
public class Ball 
{
    
	// Creates a new instance of Ball

	public Ball(double x,double y,double vx,double vy)
	{
	
 	        xposball=x;yposball=y;xvelball=vx;yvelball=vy;iscollide=0;

	}
	

	int iscollide=0,collidewithuser=0;
	double xposball, yposball, xvelball, yvelball, rad=25;
	double xhitpos, yhitpos, xvelhit, yvelhit, mhit,hittime;

	void balltrajectory()
	{
	        xposball = xposball + xvelball;
	        yposball = yposball + yvelball + 0.005;
	        yvelball=yvelball + 0.01;
	}
    
	void iscollision(Wall[] w, int p, User[] u, int q)
	{

		for(int j=0;j<q;j++)
	        {
	         	if((Math.abs(xposball-u[j].xposuser) <= (u[j].r+rad)) && (yposball>=u[j].yposuser) && (yposball<=(u[j].yposuser+u[j].ht)))
	            	{
				System.out.println("bhai usr ke wall se collision hai");
               			mhit=Double.POSITIVE_INFINITY;
		               	xvelhit=u[j].xveluser; yvelhit=u[j].yveluser;
		 		if((xposball - (u[j].xposuser))*(xvelball)<0)
				{

					xvelball = (-xvelball) ;  
					iscollide=1;
				 	collidewithuser =1; 
					System.out.println("collide u1               "+iscollide+" is 75 dis "+(xposball-u[j].xposuser)+" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser);
	   
	  			}

            		}

     			else if((Math.abs(yposball-u[j].yposuser) <= (100+rad))&& (yposball > u[j].yposuser) && (xposball>(u[j].xposuser-75)) && (xposball<(u[j].xposuser+75)))
	        	{

                		mhit=0;
                		xvelhit=u[j].xveluser; yvelhit=u[j].yveluser;
	 			if((yposball-100 -u[j].yposuser)*(yvelball)<0)
				{
					yvelball = (-yvelball) ;   
	                		iscollide=1;collidewithuser =1;
	 				System.out.println("collide u2              "+iscollide+" is 125 dis "+(yposball-u[j].yposuser)+" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser );
   
  				}

			}

            		else if(Math.sqrt(Math.pow(xposball-u[j].xposuser, 2.0)+Math.pow(yposball-u[j].yposuser, 2.0)) <= (rad + u[j].r+5))
            		{

				System.out.println("  u3 collision");
				System.out.println(u[j].xposuser);
                		mhit=(yposball-u[j].yposuser)/(xposball-u[j].xposuser);
                		xvelhit = 0;yvelhit =0;
                		applycollision(mhit,u[j].xposuser,u[j].yposuser,xvelhit,yvelhit,u[j].rst);
	
            		}

         }
        
        for(int i=0;i<p;i++)
        {

		if(w[i].m==0)
		{

			double rii =Math.abs(w[i].y1 - yposball); 
			if(rii <= rad && (xposball<w[i].x2) && (xposball > w[i].x1))
			{

				System.out.println("collide u4               "+iscollide+" dis 25 is   "+rii +" ball at "+xposball +"  " + yposball);
				if(yvelball*(yposball-w[i].y1) <0)
				{

					yvelball=(-yvelball);
					 iscollide = 1; 

				}
             										
			}
		

		}


		else if(Math.abs(w[i].m)==Double.POSITIVE_INFINITY)
		{
			double rii2 =Math.abs(w[i].x1 - xposball); 
			if(rii2 <= rad && (yposball<w[i].y2) && (yposball > w[i].y1))
			{

				System.out.println("collide u5               "+iscollide+" dis 25 is "+rii2 +" ball at "+xposball+ "  " + yposball);

 				if(xvelball*(xposball-w[i].x1)<0)
				{

					xvelball=(-xvelball);
					 iscollide = 1; 

				}

			}		

		}

        }

}
    


void applycollision(double s,double xhit, double yhit, double vxhit, double vyhit, double rest)
{ 		
	if(s!=Double.POSITIVE_INFINITY && s!=Double.NEGATIVE_INFINITY  )
	{
		if(xhit-xposball < 0)
		{
			double p = - Math.atan(s); 
	       		double bun = -xvelball*Math.cos(p) + yvelball*Math.sin(p);
	       		double but = -yvelball*Math.cos(p) - xvelball*Math.sin(p);
       			double Uun = -vxhit*Math.cos(p) + vyhit*Math.sin(p);
    			double Uut = -vyhit*Math.cos(p) - vxhit*Math.sin(p);
    	                double rn =Math.sqrt(Math.pow(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)); 
	
	 		if(Uun - bun < 0)
			{                	

				iscollide=1;collidewithuser=1;  
				System.out.println("collide u3   1 slpoe!=inf           "+" rn "+rn+" user vel rel "+(Uun-bun)+" iscolid "+iscollide+" dis 75 is "+(Math.pow	(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)) +" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser);

				System.out.println("collide u3   2 slpoe!=inf           "+" rn "+rn+" user vel rel "+(Uun-bun)+" iscolid "+iscollide+" dis 75 is "+(Math.pow(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)) +" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser);

			
				xvelball =bun*Math.cos(p) - but*Math.sin(p);
				yvelball = -bun*Math.sin(p)+ but*Math.cos(p);
			}

                }


   		else if(xhit-xposball >0)
		{

			double p = Math.atan(s); 
	       		double bun = xvelball*Math.cos(p) + yvelball*Math.sin(p);
	       		double but = -yvelball*Math.cos(p) + xvelball*Math.sin(p);   		
			double Uun = vxhit*Math.cos(p) + vyhit*Math.sin(p);
    			double Uut = -vyhit*Math.cos(p) + vxhit*Math.sin(p);
		        double rn =Math.sqrt(Math.pow(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)); 

	 		if(Uun - bun < 0)
			{                	

				iscollide=1;collidewithuser=1;  
				System.out.println("collide u3   1 slpoe!=inf           "+" rn "+rn+" user vel rel "+(Uun-bun)+" iscolid "+iscollide+" dis 75 is "+(Math.pow	(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)) +" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser);
			
				System.out.println("collide u3   2 slpoe!=inf           "+" rn "+rn+" user vel rel "+(Uun-bun)+" iscolid "+iscollide+" dis 75 is "+(Math.pow(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)) +" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser);

			xvelball =-bun*Math.cos(p) + but*Math.sin(p);
			yvelball = -bun*Math.sin(p)- but*Math.cos(p);

			}
			
		}
	}


	else
	{
		if((yposball<yhit-50) && (yposball -(yhit-50))*(yvelball)<0)
		{

                 	iscollide=1;collidewithuser=1;  
			System.out.println("collide u3      slpoe = inf         "+iscollide+" dis 75 is "+(Math.pow(xposball-xhit, 2.0)+Math.pow(yposball-yhit, 2.0)) +" ball at "+xposball+ "  " + yposball+"  user collide "+collidewithuser);

			yvelball =-yvelball;

		} 

	 }

}


public void calculatehitpoint()
{
	if(xvelball>0)
	{
		xhitpos = xposball+hittime * xvelball+10;
	} 
	else
	{
		xhitpos = xposball+hittime * xvelball+25;
	}	
	yhitpos = 450;

}

public void calculatetime()
	{
		hittime =((Math.sqrt(yvelball*yvelball +2*(0.01)*(450-yposball) )  -yvelball )/0.01);
	}





}




