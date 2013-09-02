

import java.net.*;
import java.applet.AudioClip;

public class audioplaystart extends Thread {
AudioClip a;
int playa=1;
public void run(){
try{
URL u = new URL("file://./20th_century_fox.wav");
java.applet.Applet p = new java.applet.Applet();
a= p.newAudioClip(u);
//a.play();


}catch(Exception e){
}

}
}
