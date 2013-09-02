

import java.net.*;
import java.applet.AudioClip;

public class audioball2 extends Thread {
AudioClip a;
int playa=1;
public void run(){
try{

	URL u1 = new URL("file:///home/btech/cs1060182/Documents/Samurai Swords 2.wav");
	java.applet.Applet p1 = new java.applet.Applet();
	a= p1.newAudioClip(u1);
	//a.play();System.out.println("a p						lyed");




}catch(Exception e){
}

}
}
