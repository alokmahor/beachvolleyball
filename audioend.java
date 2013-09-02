

import java.net.*;
import java.applet.AudioClip;

public class audioend extends Thread {
AudioClip a;
int playa=1;
public void run(){
try{

	URL u1 = new URL("file:///home/btech/cs1060182/Documents/cheer1.wav");
	java.applet.Applet p1 = new java.applet.Applet();
	a= p1.newAudioClip(u1);
	//a.play();
	System.out.println("ase p						lyed");




}catch(Exception e){System.out.println("gdfgdfgd");
}

}
public static void main(String args[]){audioend p = new audioend();
 p.start();
	try {
        p.sleep(1000);
        } catch (InterruptedException ignored) {System.out.println("gdfgdfgd");
       }
	try {
         Thread.sleep(1000);
        } catch (InterruptedException ignored) {System.out.println("gdfgdfgd");
        }

p.a.play();}

}
