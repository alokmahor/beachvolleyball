public class Wall{

	double x1,x2,y1,y2,m,b;
	public Wall(double a1,double b1,double a2,double b2){
        	x1=a1; x2=a2;
	        y1=b1; y2=b2; m = (y1-y2)/(x1-x2);
        	b = ((x2*y1)-(x1*y2))/(x1-x2); }

    	public int intv(String str){
	Integer f = new Integer(str);
	return f.intValue(); }

	
}

