import java.awt.* ;
import javax.swing.* ;
import java.awt.*;
import java.applet.AudioClip;
import java.net.URL;
import java.net.MalformedURLException;
import java.applet.Applet;


import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.io.*;
/*
 *changed to include sound`
 * */

public class controlsingleplayer extends Frame implements KeyListener , ActionListener
{
    Image picback = null;
    Image pic1 =null;
    Image pic2 =null;
    Image picball =null;
    Image apic1 =null;  Label player1Label,player2Label, point1Label,point2Label;


    Image  iball= new ImageIcon("ball.png").getImage() ;	
    Image  iply1= new ImageIcon("tumleft.png").getImage() ;
    Image  iply2= new ImageIcon("humright.png").getImage() ;
    Image  iply3= new ImageIcon("tumright.png").getImage() ;
	Image  iply4= new ImageIcon("humleft.png").getImage() ;
    Image  ibackservel= new ImageIcon("b_serveleft.jpg").getImage() ;
    Image  ibackserver= new ImageIcon("b_serveright.jpg").getImage() ;
    Image  ibackseel= new ImageIcon("b_lookleft.jpg").getImage() ;
    Image  ibackseer= new ImageIcon("b_lookright.jpg").getImage() ;
    Image  ibackpointl= new ImageIcon("field4.jpg").getImage() ;
    Image  ibackpointr= new ImageIcon("field4.jpg").getImage() ;
    Image  ibackwin= new ImageIcon("field4.jpg").getImage() ;
    Image  ibackgamestarting0= new ImageIcon("start0.jpg").getImage() ;
    Image  ibackgamestarting1= new ImageIcon("start1.jpg").getImage() ;
    Image  ibackgamestarting2= new ImageIcon("start2.jpg").getImage() ;
    Image  ibackgamestarting3= new ImageIcon("start3.jpg").getImage() ;
    Image  p1wins= new ImageIcon("p1wins.jpg").getImage() ;
    Image  p2wins= new ImageIcon("p2wins.jpg").getImage() ;
   Image  cheers= new ImageIcon("cheers.jpg").getImage() ;   
      int u1lkey;
      int u1rkey;
      int u1ukey;
      int u2lkey;
      int u2rkey;
      int u2ukey;
 


filehandlerwr fh = new filehandlerwr();
Frame f;Button savegame,exitgame;
int saveflag=0;
int showescape=0;
int action =1;
int ext=0;

     	Ball bl = new Ball(350,200,0,0);//.........HERE -2 IS INTIAL Y VEL OF BALL AND -VE AS DOWNWARD
 	User u1 = new User(350,450,0,0);
	User u2 = new User(950,450,0,0);
        Computer comp = new Computer(950,450,0,0);
	int downward1 = 0;int downward2 = 0;
	int serve=0;
	int playmode = 1;
        int playgame =1;
        int alpha = 1;


    int x1,y1,x2,y2,x3,y3,x4,y4,p1,p2;

public controlsingleplayer(int player) {

		if(player==1)
		{
			iply1=iply4;
			iply2=iply3;
		}
		
		setTitle( "game window" ) ;
		setSize( 1301 , 800 ) ;
		setVisible( true ) ;
        	addWindowListener(new WindowEventHandler());
    		this.addKeyListener(this);
   		this.setFocusable(true);

f = new Frame("escape options");
f.setSize( 500 , 150 ) ;
f.setLayout(new FlowLayout()); 
f.addWindowListener(new WindowEventHandler());
savegame=new Button("SAVE GAME");
savegame.setBounds(20,480,200,90);
 exitgame = new Button("EXIT GAME");
savegame.setBounds(100,480,200,90);

f.setVisible(false);

f.add(savegame);
f.add(exitgame);
 savegame.addActionListener(this);   

 exitgame.addActionListener(this);   
    }



  	public void actionPerformed(ActionEvent evt) {
//	if(showescape ==1){
//	f.setVisible(true);
//		try {
//	       Thread.sleep(500);
//	    } catch (InterruptedException ignored) {
//	  }

//	if(action == 0){ System.exit(0);}
//	else {saveflag =1; playgame=0; alpha =0; System.out.println("GAME SAVED................");}

//	fra.f.setVisible(false);
//	}
 
  	if(evt.getSource() == savegame) {  
		   saveflag =1;	showescape =1; 
 	            }

 	else if(evt.getSource() ==exitgame ) {  
             System.exit(0);
          
        	    }
            
    
    }  








        public void keyPressed(KeyEvent ke)
	{
		 int i = ke.getKeyCode();
                if((i==KeyEvent.VK_ESCAPE)){
//		showescape =1; 
f.setVisible(true);

playgame=0; alpha =0;
              //	 System.exit(0);
        }
		
	else if (i==KeyEvent.VK_UP)
	{
		u1ukey = 1;
	}

	else if (i==KeyEvent.VK_LEFT)
	{
		u1lkey = 1; 
	}
	else if (i==KeyEvent.VK_RIGHT)
	{
		u1rkey = 1; 

	}

						}


        public void keyReleased(KeyEvent ke)
	{
		int i = ke.getKeyCode();

		if (i==KeyEvent.VK_UP)
		{
			u1ukey = 0;
		}
		else if (i==KeyEvent.VK_LEFT)
		{
			u1lkey = 0; 
		}
		else if (i==KeyEvent.VK_RIGHT)
		{
			u1rkey = 0; 
		}
	}

	public void keyTyped(KeyEvent ke)
	{
  
	}  







class WindowEventHandler extends WindowAdapter
		{
		public void windowClosing(WindowEvent e)
			{
			//	System.exit(0);
			if(ext==1)
				{
					System.exit(0);
				}
			
			f.setVisible(true);

playgame=0; alpha =0;
			}
    }


Image offImage;
Graphics offGraphics;


public void update(Graphics g) {

	// Create the offscreen graphics context
	if (offGraphics == null){
	    offImage = createImage(getWidth(), getHeight());
	    offGraphics = offImage.getGraphics();
	}

	// Paint the frame into the image
        paint(offGraphics);

	// Paint the image onto the screen
	 g.drawImage(offImage, 0, 0, null);
    }
	



public void paint( Graphics g ) {
	g.drawImage(picback,x4,y4,this);
	g.drawImage(pic1,x2,y2,this);
	g.drawImage(pic2,x3,y3,this);
	//		drawBackground( g ) ;
	g.drawImage(picball,x1,y1,this);
	g.setColor(Color.black);
	g.setFont(new Font("TimesRoman", Font.BOLD, 18));
//	g.drawString("PLAYER 1ST ",200,720);
//	g.drawString("PLAYER 2nd ",900,720);
	g.drawString(p1+"",300,780);	
	g.drawString(p2+"",950,780);
	super.paint( g ) ;
		
    }
		
public void fun( Image ball,Image ply1,Image ply2 ,Image back,int x11,int y11,int x22,int y22,int x33,int y33,int x44,int y44,int p11, int p22){
			
		pic1 = ply1;
		pic2=ply2;
                picball = ball;
		picback = back;
		x1=x11;
		x2=x22;x3 = x33;x4 = x44;
		y1 = y11;
		y2 = y22;y3 = y33;y4 = y44;p1=p11;p2=p22;
	
    }






public void runningfunction(controlsingleplayer fra,String playername)throws IOException
{
  
      //GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //   GraphicsDevice myDevice = graphicsEnvironment.getDefaultScreenDevice();
  //     DisplayMode oldDisplayMode = myDevice.getDisplayMode();
          
//DisplayMode newDisplayMode = new DisplayMode(1301,800,32,0);


//try {
   // myDevice.setFullScreenWindow(this);
  //  myDevice.setDisplayMode(newDisplayMode);

//} finally {
    //myDevice.setDisplayMode(oldDisplayMode);
  //  myDevice.setFullScreenWindow(null);
//}



      boolean o=true;







//		audio1 as1 = new audio1();
//		as1.start();// start but do'nt play music
//	try {
//         as1.sleep(100);
//        } catch (InterruptedException ignored) {
//        }



		audioball1 asb1 = new audioball1();
		asb1.start();// start but do'nt play music
	try {
         asb1.sleep(100);
        } catch (InterruptedException ignored) {
        }





audioplaystart asp = new audioplaystart();

asp.start();

	try {
         asp.sleep(100);
        } catch (InterruptedException ignored) {
        }
asp.a.play();


 fra.fun(ibackgamestarting3,ibackgamestarting3,ibackgamestarting3,ibackgamestarting3,0,0,0,0,0,0,0,0,0,0)  ;
 fra.repaint();

	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }


 fra.fun(ibackgamestarting2,ibackgamestarting2,ibackgamestarting2,ibackgamestarting2,0,0,0,0,0,0,0,0,0,0)  ;
 fra.repaint();

	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

 fra.fun(ibackgamestarting1,ibackgamestarting1,ibackgamestarting1,ibackgamestarting1,0,0,0,0,0,0,0,0,0,0)  ;
 fra.repaint();

	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

 fra.fun(ibackgamestarting0,ibackgamestarting0,ibackgamestarting0,ibackgamestarting0,0,0,0,0,0,0,0,0,0,0)  ;
 fra.repaint();

	try {
         Thread.sleep(6800);
        } catch (InterruptedException ignored) {
        }




		asp.a.stop();

	try {	
	asp.sleep(1000);
        } catch (InterruptedException ignored) {
        }

asp.stop();






while(alpha==1){



// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$sould have a imge here

	 playgame = 1;

if(serve ==0){
  	 bl.xposball = 350;}
else if(serve ==1){bl.xposball = 950;}

	 bl.yposball = 200;
         bl.xvelball = 0;bl.yvelball=0;
         u1.xposuser = 350;u1.yposuser=450;u1.xveluser=0;u1.yveluser=0;
         comp.xposcomp=950;comp.yposcomp = 450; comp.xvelcomp=0;comp.yvelcomp=0;
	 u2.xposuser =950;u2.yposuser=450; u2.xveluser=0;u2.yveluser=0;

	System.out.println("<<<<<       restart    >>>>>");


       
if(serve==0){ 
  				fra.fun(iball,iply1,iply2,ibackservel,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(u2.xposuser-50),(int)(u2.yposuser-50),0,0,u1.point,comp.point)  ;
				fra.repaint();
	   }
else if(serve==1){ 
  				fra.fun(iball,iply1,iply2,ibackserver,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(u2.xposuser-50),(int)(u2.yposuser-50),0,0,u1.point,comp.point)  ;
				fra.repaint();
	    }



	

//	try {
  //       as1.sleep(100);
    //    } catch (InterruptedException ignored) {
      //  }



	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }



System.out.println(" stsrting 0 as1/n/n/n/n");

//as1.a.loop();
System.out.println(" stsrting as1/n/n/n/n");








	switch(playmode){










/*
 * palyer vs COMP mode
 */   

		case 1: 









			while(playgame==1){



Wall w1 = new Wall(100,50,100,550);
Wall w2 = new Wall(100,550,600,550);
Wall w3 = new Wall(600,350,600,550);
Wall w4 = new Wall(600,350,700,350);
Wall w5 = new Wall(700,350,700,550);
Wall w6 = new Wall(700,550,1200,550);
Wall w7 = new Wall(1200,50,1200,550);
Wall w8 = new Wall(100,50,1200,50);
Wall walls[] ={w1,w2,w3,w4,w5,w6,w7,w8};
User dr = new User(comp.xposcomp,comp.yposcomp,comp.xvelcomp,comp.yvelcomp);
User users[]= {u1,dr};

bl.iscollide =0;bl.collidewithuser=0;
	 if(bl.xposball<=600 && bl.xposball>=100){comp.count =0;}  
    else if(bl.xposball<=1200 && bl.xposball>= 700){u1.count =0;} 

			bl.iscollision(walls,8,users,2);

			if(bl.iscollide==0){
  				bl.balltrajectory();
/*
 * from here motion of server player is detected and decided.
 *
 *
 * */



			 	if(downward1 == 1)
				{
				     if((u1.yposuser+100+2)<=550)
					{
						u1.yposuser=u1.yposuser+2;u1.yveluser=2;
					 	if(u1lkey == 1)
				   		{// decrease x co-ordiante
							if((u1.xposuser-50-2)<100){u1.xveluser=0;}
							else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   		}

			     	 		else if(u1rkey==1)
				   		{//increase x co-ordianate
							if((u1.xposuser+50+2)>600){u1.xveluser=0;}
							else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   		}	
                                     
					}

			           	else if((u1.yposuser+100+2)>550)
					{
						u1.yveluser=0;
						downward1 = 0;
						if(u1lkey == 1)
				   		{// decrease x co-ordiante
							if((u1.xposuser-50-2)<100){u1.xveluser=0;}
							else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   		}

			     	 		else if(u1rkey==1)
				   		{//increase x co-ordianate
							if((u1.xposuser+50+2)>600){u1.xveluser=0;}
							else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   		}	

					}
				} 














				else if(downward1==0)
				{///
					if(u1ukey==1)
					{
						if((u1.yposuser-50-2)>=300)
						{
							u1.yposuser=u1.yposuser-2;u1.yveluser =(-2);
					 		if(u1lkey == 1)
				   			{// decrease x co-ordiante
								if((u1.xposuser-50-2)<100){u1.xveluser=0;}
								else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   			}

			     	 			else if(u1rkey==1)
				   			{//increase x co-ordianate
								if((u1.xposuser+50+2)>600){u1.xveluser =0;}
								else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   			}	
							  	
										
	
						}

						else if((u1.yposuser-50-2)<300)
						{
							u1.yveluser = (0);downward1=1;
						 	if(u1lkey == 1)
				   			{// decrease x co-ordiante
								if((u1.xposuser-50-2)<100){u1.xveluser=0;}
								else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   			}

			     	 			else if(u1rkey==1)
				   			{//increase x co-ordianate
								if((u1.xposuser+50+2)>600){u1.xveluser=0;}
								else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   			}	

						}
					}




					else if(u1ukey==0)
					{
                                         	if((u1.yposuser+100+2)>550){   u1.yveluser=0;
					 					if(u1lkey == 1)
				   						{// decrease x co-ordiante
											if((u1.xposuser-50-2)<100){u1.xveluser=0;}
											else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   						}

			     	 						else if(u1rkey==1)
				   						{//increase x co-ordianate
											if((u1.xposuser+50+2)>600){u1.xveluser=0;}
											else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   						}	
									  }

					else if((u1.yposuser+100+2)<=550){
										u1.yposuser=u1.yposuser+2;u1.yveluser=2;
					 					if(u1lkey == 1)
				   						{// decrease x co-ordiante
											if((u1.xposuser-50-2)<100){u1.xveluser=0;}
											else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   						}

			     	 						else if(u1rkey==1)
				   						{//increase x co-ordianate
											if((u1.xposuser+50+2)>600){u1.xveluser=0;}
											else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   						}	
		


									}


					}
				}























/*
 * till here motion on collision
 * update computer co-ordinate
 *
 * */
	//	if(((bl.xposball)<=1200)&&((bl.xposball)>=700)){
		bl.calculatetime();	bl.calculatehitpoint();
			
		comp.isreach(bl.xhitpos,bl.yhitpos,bl.hittime);
		comp.isjump(bl.xposball,bl.yposball,bl.xvelball);
		comp.compmove(bl.xhitpos,bl.yhitpos);
//		System.out.println("comp1     xpos     "+comp.xposcomp);
//		System.out.println("comp1  xvel       "+comp.xvelcomp);

		comp.comptrajectory();
	//	}else{if(comp.yposcomp+100 <550){comp.yvelcomp=5;comp.xvelcomp=0;comp.comptrajectory();}}


// HERE ALSO CHOOSE PROPER BACK
if(bl.xposball >=650){

  				fra.fun(iball,iply1,iply2,ibackseer,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(comp.xposcomp-50),(int)(comp.yposcomp-50),0,0,u1.point,comp.point)  ;
				fra.repaint();
	            }	
else if(bl.xposball <650){

  				fra.fun(iball,iply1,iply2,ibackseel,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(comp.xposcomp-50),(int)(comp.yposcomp-50),0,0,u1.point,comp.point)  ;
				fra.repaint();
	            }		
		

		}  
/*
 *from here to 
 * */
			   else if(bl.iscollide==1)
				{   


asb1.a.play();



					 // System.out.println("***++++----------------------------------collide with user" +bl.collidewithuser ); 
					 if( bl.collidewithuser == 1){ if(bl.xposball<=600 && bl.xposball>=100){u1.count =u1.count +1;}  
								else if(bl.xposball<=1200 && bl.xposball>= 700){comp.count =comp.count + 1;} else{}}

				   //bl.applycollision();
			 	   bl.balltrajectory(); 

			 	if(downward1 == 1)
				{
				     if((u1.yposuser+100+2)<=550)
					{
						u1.yposuser=u1.yposuser+2;u1.yveluser=2;
					 	if(u1lkey == 1)
				   		{// decrease x co-ordiante
							if((u1.xposuser-50-2)<100){u1.xveluser=0;}
							else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   		}

			     	 		else if(u1rkey==1)
				   		{//increase x co-ordianate
							if((u1.xposuser+50+2)>600){u1.xveluser=0;}
							else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   		}	
                                     
					}

			           	else if((u1.yposuser+100+2)>550)
					{
						u1.yveluser=0;
						downward1 = 0;
						if(u1lkey == 1)
				   		{// decrease x co-ordiante
							if((u1.xposuser-50-2)<100){u1.xveluser=0;}
							else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   		}

			     	 		else if(u1rkey==1)
				   		{//increase x co-ordianate
							if((u1.xposuser+50+2)>600){u1.xveluser=0;}
							else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   		}	

					}
				} 














				else if(downward1==0)
				{///
					if(u1ukey==1)
					{
						if((u1.yposuser-50-2)>=300)
						{
							u1.yposuser=u1.yposuser-2;u1.yveluser =(-2);
					 		if(u1lkey == 1)
				   			{// decrease x co-ordiante
								if((u1.xposuser-50-2)<100){u1.xveluser=0;}
								else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   			}

			     	 			else if(u1rkey==1)
				   			{//increase x co-ordianate
								if((u1.xposuser+50+2)>600){u1.xveluser =0;}
								else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   			}	
							  	
										
	
						}

						else if((u1.yposuser-50-2)<300)
						{
							u1.yveluser = (0);downward1=1;
						 	if(u1lkey == 1)
				   			{// decrease x co-ordiante
								if((u1.xposuser-50-2)<100){u1.xveluser=0;}
								else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   			}

			     	 			else if(u1rkey==1)
				   			{//increase x co-ordianate
								if((u1.xposuser+50+2)>600){u1.xveluser=0;}
								else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   			}	

						}
					}




					else if(u1ukey==0)
					{
                                         	if((u1.yposuser+100+2)>550){   u1.yveluser=0;
					 					if(u1lkey == 1)
				   						{// decrease x co-ordiante
											if((u1.xposuser-50-2)<100){u1.xveluser=0;}
											else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   						}

			     	 						else if(u1rkey==1)
				   						{//increase x co-ordianate
											if((u1.xposuser+50+2)>600){u1.xveluser=0;}
											else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   						}	
									  }

					else if((u1.yposuser+100+2)<=550){
										u1.yposuser=u1.yposuser+2;u1.yveluser=2;
					 					if(u1lkey == 1)
				   						{// decrease x co-ordiante
											if((u1.xposuser-50-2)<100){u1.xveluser=0;}
											else if((u1.xposuser-50-2)>=100){u1.xposuser= u1.xposuser-2;u1.xveluser =(-2);}
				   						}

			     	 						else if(u1rkey==1)
				   						{//increase x co-ordianate
											if((u1.xposuser+50+2)>600){u1.xveluser=0;}
											else if((u1.xposuser+50+2)<=600) {u1.xposuser= u1.xposuser+2;u1.xveluser =2;}

				   						}	
		


									}


					}
				}
















/*
 * till here motion on collision.
 * same thing here update computer co-ordinate
 * */

//		if(((bl.xposball+50)<1200)&&((bl.xposball-50)>=700)){
		bl.calculatetime();	bl.calculatehitpoint();
			
		comp.isreach(bl.xhitpos,bl.yhitpos,bl.hittime);
		comp.isjump(bl.xposball,bl.yposball,bl.xvelball);
		comp.compmove(bl.xhitpos,bl.yhitpos);//System.out.println("comp2  xpos        "+comp.xposcomp);System.out.println("comp2   xvel       "+comp.xvelcomp);

		comp.comptrajectory();
//		}else{if(comp.yposcomp+100 <550){comp.yvelcomp=5;comp.xvelcomp=0;comp.comptrajectory();}}


// HERE CHOOSE WRITE BACK 

if(bl.xposball>=650){
  				fra.fun(iball,iply1,iply2,ibackseer,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(comp.xposcomp-50),(int)(comp.yposcomp-50),0,0,u1.point,comp.point)  ;
				fra.repaint();
 		    }

else if(bl.xposball<650){
  				fra.fun(iball,iply1,iply2,ibackseel,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(comp.xposcomp-50),(int)(comp.yposcomp-50),0,0,u1.point,comp.point)  ;
				fra.repaint();
 		    }

				} 


       try {
          Thread.sleep(4);
        } catch (InterruptedException ignored) {
        }





                   
if((bl.yposball > 520) && (bl.xposball >= 725) ){u1.pointi();serve=0;playgame=0;comp.count=0;u1.count=0;}
else if((bl.yposball) > 520 && (bl.xposball <= 575 )){comp.pointi();serve=1;playgame=0;comp.count=0;u1.count=0;}

if((u1.count == 4) || comp.count == 4){
  if(u1.count == 4) {comp.pointi();playgame =0;comp.count=0;u1.count=0;serve=1;}
  else if (comp.count == 4){ u1.pointi();playgame=0;comp.count=0;u1.count=0;serve=0;}
}

if(u1.point == 5){ u1.win();alpha = 0;comp.count=0;u1.count=0;System.out.println("YEEEEEEEEEEEEEE..PLAYER 1 WINS....");}
 else if (comp.point == 5 ){comp.win();alpha=0;comp.count=0;u1.count=0;System.out.println("YEEEEEEEEEEEEEE..PLAYER 2 WINS....");}

//asb1.a.stop();stop actually delays



/*if(saveflag ==1){
fh.write_to_file(playername+".txt","single",bl.xposball,bl.yposball,bl.xvelball,bl.yvelball,u1.xposuser,u1.yposuser,u1.point,comp.xposcomp,comp.yposcomp,comp.point,comp.reach,comp.jump,comp.d,comp.j,comp.flag);
}
*/




			}
		
//as1.a.stop();

//       try {
  //        asb1.sleep(4);
    //    } catch (InterruptedException ignored) {
      //  }


				break;


		}



	}	








asb1.stop();
audioend ase = new audioend();

ase.start();


System.out.println("alpha loop win");
if(u1.point ==5 )
{	ext=1;
		fra.fun(p1wins,p1wins,p1wins,p1wins,(0),(0),(0),(0),(0),(0),0,0,u1.point,comp.point)  ;
				fra.repaint();
}

else if(comp.point ==5){
		ext=1;
		fra.fun(p2wins,p2wins,p2wins,p2wins,(0),(0),(0),(0),(0),(0),0,0,u1.point,comp.point)  ;
				fra.repaint();


}


	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

System.out.println("alpha loop cheers");
if(u1.point ==5 )
{
		fra.fun(cheers,cheers,cheers,cheers,(0),(0),(0),(0),(0),(0),0,0,u1.point,comp.point)  ;
				fra.repaint();
}

else if(comp.point ==5){
		fra.fun(cheers,cheers,cheers,cheers,(0),(0),(0),(0),(0),(0),0,0,u1.point,comp.point)  ;
				fra.repaint();


}

	try {
         ase.sleep(1000);
        } catch (InterruptedException ignored) {
        }



ase.a.play();

while(showescape!=1 ){System.out.println("d");}

if(saveflag ==1){
fh.write_to_file(playername+".txt","single",bl.xposball,bl.yposball,bl.xvelball,bl.yvelball,u1.xposuser,u1.yposuser,u1.point,comp.xposcomp,comp.yposcomp,comp.point,comp.reach,comp.jump,comp.d,comp.j,comp.flag);
 System.out.println("GAME SAVED................");

}




System.out.println("e");
if(showescape ==1){ System.exit(0);}
System.out.println("f");

     }


}
