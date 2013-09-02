import java.awt.* ;
import javax.swing.* ;
import java.awt.*;
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
import java.lang.*;
import java.util.*;



public class controlc extends Frame implements KeyListener
{
    Image picback = null;
    Image pic1 =null;
    Image pic2 =null;
    Image picball =null;
    Image apic1 =null;  Label player1Label,player2Label, point1Label,point2Label;

    Image  iball= new ImageIcon("ball.png").getImage() ;	
    Image  iply1= new ImageIcon("tumleft.png").getImage() ;
    Image  iply2= new ImageIcon("humright.png").getImage() ;
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
      int chec = 0;
int hitsound=0; 
 	PrintWriter pw;
int saveflag=0;
filehandlerwr fh = new filehandlerwr();

     	Ball bl = new Ball(350,200,0,0);//.........HERE -2 IS INTIAL Y VEL OF BALL AND -VE AS DOWNWARD
 	User u1 = new User(350,450,0,0);
	User u2 = new User(950,450,0,0);
        Computer comp = new Computer(950,450,0,0);
	int downward1 = 0;int downward2 = 0;
	int serve=0;
	int playmode = 0;
        int playgame =0;
        int alpha = 1;
int re=0;

    int x1,y1,x2,y2,x3,y3,x4,y4,p1,p2;

public controlc(PrintWriter pw) {

		setTitle( "game window" ) ;
		setSize( 1301 , 800 ) ;
		setVisible( true ) ;
        	addWindowListener(new WindowEventHandler());
    		this.addKeyListener(this);
    		this.pw = pw;
   		this.setFocusable(true);

    }




	public void interpretCommand(String command) 
	{                     int i = 0;
              if(command == null)
		{
		}
	     else{	
                	StringTokenizer st = new StringTokenizer(command);
                 
               		try{
                		String ind = st.nextToken();
                		Integer it = new Integer(ind);
                		i = it.intValue();
                	}catch(NumberFormatException ne){}

            		try {switch(i)
           		{       case 0 : break;

            			case 1 :
                  			u1.xposuser = (new Integer(st.nextToken())).intValue();
                   			u1.yposuser = (new Integer(st.nextToken())).intValue();                 		       
					break;
                                
            			case 2 :
                  			u2.xposuser = (new Integer(st.nextToken())).intValue();
                   			u2.yposuser = (new Integer(st.nextToken())).intValue();                 		        
					break;
            			case 3 :
                  			bl.xposball = (new Integer(st.nextToken())).intValue();
                   			bl.yposball = (new Integer(st.nextToken())).intValue();
                 		        
					break;
            			case 4 :
                  			u1.point = (new Integer(st.nextToken())).intValue();
                 		        
					break;

            			case 5 :
                  			u2.point = (new Integer(st.nextToken())).intValue();
                 		        
					break;
            			case 6 :

                  			re =1;            
System.out.println("got re");		        
					break;


            			case 7 :
                  		        System.exit(0);
                 		        
					break;

                                case 8: hitsound=1; break;


                                case 9: hitsound=0; break;
				case 10 : playgame=1;

                  
           		} }catch(NumberFormatException ne){}

                 }  

  	}









        public void keyPressed(KeyEvent ke)
	{
		 int i = ke.getKeyCode();
                 if((i==KeyEvent.VK_ESCAPE)){
		pw.println("Escape");
		pw.flush();

              	 System.exit(0);
        }
		
	else if (i==KeyEvent.VK_UP)
	{
		u2ukey = 1;
		pw.println("UpPress");
		pw.flush();
	}

	else if (i==KeyEvent.VK_LEFT)
	{
		u2lkey = 1; 
      		pw.println("LeftPress");
      		pw.flush();
	}
	else if (i==KeyEvent.VK_RIGHT)
	{
		u2rkey = 1; 
		pw.println("RightPress");
		pw.flush();

	}

	}


        public void keyReleased(KeyEvent ke)
	{
		int i = ke.getKeyCode();

		if (i==KeyEvent.VK_UP)
		{
			u2ukey = 0;
    			pw.println("UpRelease");
      			pw.flush();
		}
		else if (i==KeyEvent.VK_LEFT)
		{
			u2lkey = 0; 
	      		pw.println("LeftRelease");
	      		pw.flush();
		}
		else if (i==KeyEvent.VK_RIGHT)
		{
			u2rkey = 0; 
	      		pw.println("RightRelease");
	      		pw.flush();
		}
	}

	public void keyTyped(KeyEvent ke)
	{
  
	}  




class WindowEventHandler extends WindowAdapter
		{
		public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
    }


Image offImage;
Graphics offGraphics;


public void update(Graphics g) {

	if (offGraphics == null){
	    offImage = createImage(getWidth(), getHeight());
	    offGraphics = offImage.getGraphics();
	}
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






public void runningfunction(controlc fra,String playername){
  
      boolean o=true;

		audioball1 asb1 = new audioball1();
		asb1.start();// start but do'nt play music
	try {
         asb1.sleep(200);
        } catch (InterruptedException ignored) {
        }





audioplaystart asp = new audioplaystart();

asp.start();

	try {
         asp.sleep(200);
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

	 playgame = 1;

         bl.xvelball = 0;bl.yvelball=0;
         u1.xposuser = 350;u1.yposuser=450;u1.xveluser=0;u1.yveluser=0;
         comp.xposcomp=950;comp.yposcomp = 450; comp.xvelcomp=0;comp.yvelcomp=0;
	 u2.xposuser =950;u2.yposuser=450; u2.xveluser=0;u2.yveluser=0;

	System.out.println("<<<<<       restart    >>>>>");
        System.out.println(" after restart " + bl.xposball);

       
if(bl.xposball <650){ 
  				fra.fun(iball,iply1,iply2,ibackservel,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(u2.xposuser-50),(int)(u2.yposuser-50),0,0,u1.point,u2.point)  ;
				fra.repaint();
	   }

else if(bl.xposball>=650){ 
  				fra.fun(iball,iply1,iply2,ibackserver,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(u2.xposuser-50),(int)(u2.yposuser-50),0,0,u1.point,u2.point)  ;
				fra.repaint();
	    }


	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }


			while(playgame==1){


if(hitsound==1){asb1.a.play();}


if(bl.xposball >= 650){
                       
  				fra.fun(iball,iply1,iply2,ibackseer,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(u2.xposuser-50),(int)(u2.yposuser-50),0,0,u1.point,u2.point)  ;
				fra.repaint();
}

else {
  				fra.fun(iball,iply1,iply2,ibackseel,(int)(bl.xposball-25),(int)(bl.yposball-25),(int)(u1.xposuser-50),(int)(u1.yposuser-50),(int)(u2.xposuser-50),(int)(u2.yposuser-50),0,0,u1.point,u2.point)  ;
				fra.repaint();
}


			if(re==1){playgame=0; re =0;}

	try {
         Thread.sleep(4);
        } catch (InterruptedException ignored) {
        }


//if(saveflag ==1){
//fh.write_to_file(playername+".txt","server",bl.xposball,bl.yposball,bl.xu1.xposuser,u1.yposuser,u1.point,u2.xposuser,u2.yposuser,u2.point);
//}



//System.out.println(" showing"+u1.point);
			}//while playgame
		if(u1.point ==5 || u2.point == 5)
{
  alpha = 0;
}
// write code for ending of game
			

		}//while alpha




asb1.stop();
audioend ase = new audioend();

ase.start();
	
System.out.println("alpha loop win");
if(u1.point ==5 )
{
		fra.fun(p1wins,p1wins,p1wins,p1wins,(0),(0),(0),(0),(0),(0),0,0,u1.point,u2.point)  ;
				fra.repaint();
}

else if(u2.point ==5){
		fra.fun(p2wins,p2wins,p2wins,p2wins,(0),(0),(0),(0),(0),(0),0,0,u1.point,u2.point)  ;
				fra.repaint();


}


	try {
         Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }

System.out.println("alpha loop cheers");
if(u1.point ==5 )
{
		fra.fun(cheers,cheers,cheers,cheers,(0),(0),(0),(0),(0),(0),0,0,u1.point,u2.point)  ;
				fra.repaint();
}

else if(u2.point ==5){
		fra.fun(cheers,cheers,cheers,cheers,(0),(0),(0),(0),(0),(0),0,0,u1.point,u2.point)  ;
				fra.repaint();


}

	try {
         ase.sleep(1000);
        } catch (InterruptedException ignored) {
        }



ase.a.play();





	}	


     }


