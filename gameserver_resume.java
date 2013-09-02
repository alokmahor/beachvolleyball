import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameserver_resume implements Runnable
{
   controls_resume game;
  Socket socket;
  public static BufferedReader br;
  PrintWriter pw;

  public gameserver_resume() throws IOException
  {
    ServerSocket server = new ServerSocket(3456);
    socket = server.accept();
    initializeStreams();
   game = new controls_resume(pw);
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
      {socket.setSoTimeout(20000);
         game.interpretCommand(br.readLine());
	 //game.runningfunction(game);
         // system.out.println(br.readLine());
      }  catch(IOException ioe) {
	game.serverrunning =0;}
    }
  }

  // write
  /*public void sendCommand(String commandName)
  {
    pw.println(commandName);
    pw.flush();
  }*/

  public static void main(String args[]) throws IOException
  {
//  gameserver b=  new gameserver();
  //  new Thread(a).start();
//   (b.game).runningfunction(b.game);
 // loop (running function)
  }
}


