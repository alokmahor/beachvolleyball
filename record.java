public class record {
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

public double flt(String str){
    Float f = new Float(str);
    return f.doubleValue();
}
public int intv(String str){
Integer f = new Integer(str);
return f.intValue();
}

}

