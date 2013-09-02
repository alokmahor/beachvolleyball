import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameclient implements Runnable
{
   controlc game;
  Socket socket;
  public static BufferedReader br;
  public static PrintWriter pw;

  public gameclient(String ip) throws IOException
  {
    socket = new Socket(ip,3456);
    initializeStreams();
    game = new controlc(pw);
    new Thread(this).start();

  }

  public void initializeStreams() throws IOException
  {
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
  }

  public void run()
  {
    // server game code, reads endlessly
    
    while(true)
    {
      try
       { socket.setSoTimeout(20000);
	 game.interpretCommand(br.readLine()); 
	 //game.runningfunction(game);        
         //System.out.println(br.readLine());
       }catch(IOException ioe){System.exit(0);}
    }
  }

  /*public void sendCommand(String commandName)
  {
    pw.println(commandName);
    pw.flush();
  }*/

  public static void main(String args[]) throws IOException
  {
//   gameclient a=  new gameclient();(a.game).runningfunction(a.game);
  }
}
