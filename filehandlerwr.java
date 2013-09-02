/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package game_record;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sony
 */
public class filehandlerwr {

   
    public static void main(String[] args) throws IOException {
    //File fc = new File("game_info.txt");
    Vector<record> rcv;
    rcv = write_from_file("game_info.txt");
    write_to_file1("game_info.txt",rcv.elementAt(0));
    
    }
    
public static Vector<record> write_from_file(String fstr) throws IOException
{  File f1 = new File(fstr);
  BufferedReader br=new BufferedReader(new FileReader(f1));
     String line = "";
     StringTokenizer st;
     String Xb="",Yb = "",X1 = "",Y1 = "",P1 = "",X2 = "",Y2 = "",P2 = "";
     String xv = "",yv ="",r="" , j="" , d1="" , j1="" , fl1="";
     String nam="";
     record rec;
     Vector<record> rc = new Vector();
line = br.readLine();
while(!(line == null)){ if(line.equals("BEGIN"))
   { System.out.println(line);
    line = br.readLine();                         
   }
   else if (line.equals("END")){System.out.println(line);
   line = br.readLine();
   }
     
   else { for(int i = 0 ; i < 4 ; i++){                                   
                                    st  = new StringTokenizer(line);System.out.println(st.countTokens());
                                    if(i == 0){nam = line; System.out.println(line);
                                               line = br.readLine();}
                                    else if(i == 1){ Xb = st.nextToken(); System.out.println(line); //System.out.println(Xb);
                                                Yb = st.nextToken();
                                                xv = st.nextToken();
                                                yv = st.nextToken();
                                                line = br.readLine();
                                               }
                                    else if(i == 2){             System.out.println(line);                                
                                             X1 = st.nextToken();
                                             Y1 = st.nextToken();
                                             P1 = st.nextToken();    
                                             line = br.readLine();
                                         }
                                    else if (i == 3){  System.out.println(line);
                                     X2 = st.nextToken();
                                     Y2 = st.nextToken();
                                     P2 = st.nextToken();  
                                     r = st.nextToken();
                                     j = st.nextToken();
                                     d1 = st.nextToken();
                                     j1 = st.nextToken();
                                     fl1 = st.nextToken();
                                     line = br.readLine();
                                    }
                                   }
   
   rec = new record(nam ,Xb,Yb,xv,yv,X1,Y1,P1,X2,Y2,P2,r,j,d1,j1,fl1);
   rc.add(rec);
          }}
     return rc;
}

public static void write_to_file1(String fname ,record p ) throws IOException{
    File f = new File(fname);
   // f.delete();
    f.createNewFile();     
    
    RandomAccessFile rf = new RandomAccessFile(f,"rw");
   
    //FileWriter bw=new FileWriter(f);
    rf.seek(f.length()); 
    rf.writeBytes("BEGIN" + "\n");
    rf.writeBytes(p.name+ "\n");
    rf.writeBytes(p.Xb + "\t");
    rf.writeBytes(p.Yb + "\t");
    rf.writeBytes(p.Xv + "\t");
    rf.writeBytes(p.Yv + "\n");
    rf.writeBytes(p.X1 + "\t");
    rf.writeBytes(p.Y1 + "\t");
    rf.writeBytes(p.P1 + "\n");
    rf.writeBytes(p.X2 + "\t");
    rf.writeBytes(p.Y2 + "\t");
    rf.writeBytes(p.P2 + "\t");
    rf.writeBytes(p.reach + "\t");
    rf.writeBytes(p.jump + "\t");
    rf.writeBytes(p.d + "\t");
    rf.writeBytes(p.j + "\t");
    rf.writeBytes(p.flagc + "\n");
    rf.writeBytes("END" + "\n");
    rf.close(); 
    }

public void write_to_file(String f_name, String n ,double xb,double yb,double xv1,double yv1, double x1,double y1,double p1,double x2,double y2,double p2, double r2, double ju2 , double d2 , double j2,double fl2)
{
        try {
            record r = new record(n +"",xb + "", yb + "",xv1 + "",yv1 + "", x1 + "", y1 + "", p1 + "", x2 + "", y2 + "", p2 + "", r2 +"",ju2+"",d2+"",j2+ "",fl2 +"");
            write_to_file1(f_name , r);
        } catch (IOException ex) { }
}
    
}

/*class record {
String Xb,Yb,Xv,Yv,X1,Y1,P1,X2,Y2,P2;
String name ,  reach ,jump ,d, j, flagc ;

public record(String n ,String xb,String yb,String xv,String yv,String x1,String y1,String p1,String x2,String y2,String p2,String r , String ju,String d1,String j1, String f1){    
Xb = xb;
Yb = yb;
Xv = xv;
Yv = yv;
name = n;
reach =r;
jump = ju;
d = d1;
j = j1;
flagc = f1;

X1 = x1;
Y1 = y1;
P1 = p1;
X2 = x2;
Y2 = y2;
P2 = p2;
}

double flt(String str){
    Float f = new Float(str);
    return f.doubleValue();
}
}*/

