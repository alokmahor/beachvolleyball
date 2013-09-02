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
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class run  extends Frame implements KeyListener, ActionListener

 {




    int x1,y1;


    Image  i1= new ImageIcon("start.jpg").getImage() ;	
    Image  i2= new ImageIcon("select.jpg").getImage() ;
    Image  i3= new ImageIcon("about.jpg").getImage() ;
    Image  i4= new ImageIcon("keys.jpg").getImage() ;
    Image  i5= new ImageIcon("exit.jpg").getImage() ;
    Image  i6= new ImageIcon("1pcomp.jpg").getImage() ;
    Image  i7= new ImageIcon("1p2p.jpg").getImage() ;
    Image  i8= new ImageIcon("mtypeback.jpg").getImage() ;
    Image  i9= new ImageIcon("1pload.jpg").getImage() ;
    Image  i10= new ImageIcon("1pstart.jpg").getImage() ;
    Image  i11= new ImageIcon("1pstartback.jpg").getImage() ;
    Image  i12= new ImageIcon("connectload.jpg").getImage() ;
    Image  i13= new ImageIcon("createserver.jpg").getImage() ;
    Image  i14= new ImageIcon("joinserver.jpg").getImage() ;
    Image  i15= new ImageIcon("connectback.jpg").getImage() ;
    Image  i16= new ImageIcon("hum.jpg").getImage() ;
    Image  i17= new ImageIcon("tum.jpg").getImage() ;
    Image  i18= new ImageIcon("playerback.jpg").getImage() ;
    Image  i19= new ImageIcon("abtback.jpg").getImage() ;
    Image  i20= new ImageIcon("control.jpg").getImage() ;
   Image  cheers= new ImageIcon("cheers.jpg").getImage() ;   

  int ukey=0, dkey=0, enter=0;
  public static int flag=1;
public static int check=0;
 public static int playstyle=0;
 public static  int player=1;
 public static String playername="p1";
 public static String ip="10.160.1.232";
 public static  String loadfilename="p1.txt";
 public static run intialframe=new run();
	

  Image picback = i1;

Frame f1,f2,f3;Button savename,savefilename,saveip;TextField entername,enterfilename,enterip;


public run() {

		setTitle( "intial window" ) ;
		setSize( 1301 , 800 ) ;
		setVisible( true ) ;
        	addWindowListener(new WindowEventHandler());
    		this.addKeyListener(this);
   		this.setFocusable(true);

 f1 = new Frame("PLAYER NAME");
 f2 = new Frame("FILE NAME");
 f3 = new Frame("JOIN SERVER");
f1.setSize( 500 , 150 ) ;
f1.setLayout(new FlowLayout()); 
f1.addWindowListener(new WindowEventHandler());

f2.setSize( 500 , 150 ) ;
f2.setLayout(new FlowLayout()); 
f2.addWindowListener(new WindowEventHandler());

f3.setSize( 500 , 150 ) ;
f3.setLayout(new FlowLayout()); 
f3.addWindowListener(new WindowEventHandler());

savename=new Button("SAVE NAME");
savename.setBounds(20,480,200,90);

savefilename=new Button("SAVE FILE NAME");
savefilename.setBounds(20,480,200,90);

saveip=new Button("SAVE IP");
saveip.setBounds(20,480,200,90);

entername = new TextField("ENTER YOUR NAME HERE(without spaces)",50);
enterfilename = new TextField("ENTER NAME OF GAME, WHICH YOU WANT TO RESUME",50);
enterip = new TextField("ENTER THE IP ADDRESS OF SERVER",50);

f1.setVisible(false);
f2.setVisible(false);
f3.setVisible(false);

f1.add(entername);
f1.add(savename);
f2.add(savefilename);
f2.add(enterfilename);
f3.add(enterip);
f3.add(saveip);

 savename.addActionListener(this);   
 savefilename.addActionListener(this);
 saveip.addActionListener(this);   
    }







  	public void actionPerformed(ActionEvent evt) {
 
  	if(evt.getSource() == savename) {  
  playername = entername.getText();
   this.setEnabled(true);
   f1.setVisible(false);check=1;
 	}

  	if(evt.getSource() == savefilename) {  
  loadfilename = enterfilename.getText();
    f2.setVisible(false);	check=1;            
    this.setVisible(false);
    }

 	if(evt.getSource() == saveip) {  
  ip = enterip.getText();
// this.setEnabled(true);
   f3.setVisible(false);
   this.setVisible(false);
   check=1;
    }


        }





        public void keyPressed(KeyEvent ke)
	{
		 int i = ke.getKeyCode();
                 if((i==KeyEvent.VK_ESCAPE)){

              	 System.exit(0);
        }
		

	else if (i==KeyEvent.VK_UP)
	{
		ukey = 1;
		
		
		switch(flag)
		{
			case 1: break;
			
			case 2: fun(i1);  flag=1; break;
			
			case 3: fun(i2);  flag=2; break;
			
			case 4: fun(i3);  flag=3; break;
			
			case 5: fun(i4);  flag=4; break;
			
			case 6: break;
			
			case 7: fun(i6);  flag=6; break;
							
			case 8: fun(i7);  flag=7; break;	
			
			case 9: break;
			
			case 10: fun(i9);  flag=9; break;
			
			case 11: fun(i10);  flag=10; break;
			
			case 12: break;
			
			case 13:  fun(i12);  flag=12; break;
			
			case 14:  fun(i13);  flag=13; break;
			
			case 15:  fun(i14);  flag=14; break;
			
			case 16: break;
			
			case 17:  fun(i16);  flag=16;break;
		
			case 18:  fun(i17);  flag=17; break;

			case 19: break;

			case 20: break;
			default: break;
		}
		repaint();
		try {
        	 	Thread.sleep(40);
    		  	  } catch (InterruptedException ignored) {
  	     		 }
		
		 
	}
	else if (i==KeyEvent.VK_DOWN)
	{
		dkey = 1; 

		switch(flag)
		{
			case 1: fun(i2);  flag=2; break;
			
			case 2: fun(i3);  flag=3; break;
			
			case 3: fun(i4);  flag=4; break;
			
			case 4: fun(i5);  flag=5; break;
			
			case 5:	break;
			
			case 6: fun(i7);  flag=7; break;
			
			case 7: fun(i8);  flag=8; break;
			
			case 8:	break;	
			
			case 9: fun(i10);  flag=10; break;
			
			case 10: fun(i11);  flag=11; break;
			
			case 11: break;
			
			case 12: fun(i13);  flag=13; break;
			
			case 13: fun(i14);  flag=14; break;
			
			case 14: fun(i15);  flag=15; break;
			
			case 15: break;
			
			case 16:  fun(i17);  flag=17; break;
		
			case 17:  fun(i18);  flag=18; break;
		
			case 18: break;

			case 19: break;

			case 20: break;
			default: break;
		}
		repaint();
		try {
        	 	Thread.sleep(40);
    		  	  } catch (InterruptedException ignored) {
  	     		 }

	}

	else if (i==KeyEvent.VK_ENTER)
	{
		enter = 1; 

		switch(flag)
		{
			case 1: fun(i6); flag=6;break;
			
			case 2: fun(i16);  flag=16; break;
			
			case 3: fun(i19);  flag=19; break;
			
			case 4: fun(i20);  flag=20; break;
			
			case 5: System.exit(0);	break;
			
			case 6: fun(i9);  flag=9; break;
			
			case 7: fun(i12);  flag=12; break;
			
			case 8: fun(i1);  flag=1; break;	
			
			case 9: playstyle=4;f2.setVisible(true);
	//			try{Thread.sleep(10000);}catch(InterruptedException e){}
				this.setEnabled(false);
				break;
			
			case 10: playstyle=3;
				this.setVisible(false);



				 break;
			
			case 11: fun(i6);  flag=6; break;
			
			case 12: playstyle=5;f2.setVisible(true);
		//		try{Thread.sleep(10000);}catch(InterruptedException e){}
				this.setEnabled(false);
				break;
			
			case 13: playstyle=1; this.setVisible(false); break;
			
			case 14: playstyle=2; f3.setVisible(true); this.setEnabled(false); break;
			
			case 15: fun(i6);  flag=6; break;
			
			case 16: fun(i1);  flag=1; player=1; f1.setVisible(true); this.setEnabled(false); break;
		
			case 17: fun(i1);  flag=1; player=2;f1.setVisible(true); this.setEnabled(false); break;
		
			case 18: fun(i1);  flag=1; break;

			case 19: fun(i1);  flag=1; break;

			case 20: fun(i1);  flag=1; break;
			default: break;
		}
		repaint();System.out.println(playstyle);
		try {
        	 	Thread.sleep(40);
    		  	  } catch (InterruptedException ignored) {
  	     		 }

	}

	}


        public void keyReleased(KeyEvent ke)
	{
		int i = ke.getKeyCode();

		if (i==KeyEvent.VK_UP)
		{
			ukey = 0;
		}
		else if (i==KeyEvent.VK_DOWN)
		{
			dkey = 0; 
		}
		else if (i==KeyEvent.VK_ENTER)
		{
			enter = 0; 
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
	g.drawImage(picback,0,0,this);
	super.paint( g ) ;
		
    }
		
public void fun( Image back){
			
		picback = back;
	}






public static void main( String args[] )throws IOException
{

int ao=1;


//try{Thread.sleep(1000);}catch(InterruptedException e){}
//if(r.playstyle!= 0){r.setVisible(false);}
//while(true){System.out.println("k");}
while(ao ==1){
System.out.println("inside while "+ao+"  ps "+playstyle);

if(playstyle!=0){
System.out.println("inside if "+ao+"  ps "+playstyle);
ao=0;

filehandlerwr fh  = new filehandlerwr();
switch(playstyle){


case 1://play as server

  gameserver b=  new gameserver();
   (b.game).runningfunction(b.game,playername);
break;


case 2://play as client
int oa5=1;
System.out.println("inside case ");
while(oa5==1){
	System.out.println("inside while ");
	  if(check ==1){ 
	  System.out.println("inside if ");
	  oa5=0;  
  		 gameclient a=  new gameclient(ip);
  		 (a.game).runningfunction(a.game,playername);

		check =0;
}}
break;

case 3://play single player
controlsingleplayer g = new controlsingleplayer(player);
g.runningfunction(g,playername);

break;



case 4: /// replay single player's saved game
int oa2=1;
while(oa2==1){
System.out.println("  c4 "+ check);
if(check ==1){
oa2=0;
controlsingleplayer_resume gr = new controlsingleplayer_resume(player);
Vector<record>  vrec = new Vector();
vrec =  fh.write_from_file(loadfilename);
record rec = vrec.lastElement();



gr.runningfunction(gr,playername, rec.flt(rec.Xb),    rec.flt(rec.Yb),    rec.flt(rec.Xv),    rec.flt(rec.Yv),    rec.flt(rec.X1),    rec.flt(rec.Y1),    (int)rec.flt(rec.P1),     rec.flt(rec.X2),    rec.flt(rec.Y2),    (int)rec.flt(rec.P2),   rec.flt(rec.reach),    rec.flt(rec.jump),   (int)rec.flt(rec.d),   (int)rec.flt(rec.j),   (int)rec.flt(rec.flagc));
check =0;
}}

break;

case 5://replay server's saved game
int oa3=1;
while(oa3==1){
oa3=0;
  if(check ==1){gameserver_resume br=  new gameserver_resume();
Vector<record>  vrecs = new Vector();
vrecs =  fh.write_from_file(loadfilename);
record recs = vrecs.lastElement();


 (br.game).runningfunction(br.game,playername, recs.flt(recs.Xb),    recs.flt(recs.Yb),    recs.flt(recs.Xv),    recs.flt(recs.Yv),    recs.flt(recs.X1),    recs.flt(recs.Y1),    (int)recs.flt(recs.P1),     recs.flt(recs.X2),    recs.flt(recs.Y2),    (int)recs.flt(recs.P2));
check=0;
}
}
break;

}}}


}
}

