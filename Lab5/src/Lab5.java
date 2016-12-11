
public class Lab5 {


//	public static void main(String[] args){
	//	X x = new X();
	//	Y y = new Y();
	//	y=(Y)x;

//		X[] xa=new X[5];
//		X[] ya=new Y[2];
//		xa[0]=new X(1);
//		ya[0]=new Y(10);
//		ya[1]=new Y(100);
//		System.out.println("BEFORE SWAPPING");
//		System.out.println("xa[0]"+xa[0].getX());
//		System.out.println("ya[0]="+ya[0].getX());
//		System.out.println("ya[1]="+ya[0].getX());
//		xa=ya;
//		System.out.println("AFTER SWAPPING");
//		System.out.println("xa[0]"+xa[0].getX());
//		System.out.println("ya[0]="+ya[0].getX());
//		System.out.println("ya[1]="+ya[0].getX());
//		ya=xa;
		public static void main(String[] args){
//			X y1 = new Y();
//			System.out.println(y1.con);
			X y2 = new Y();
			X x2 = new X();
			x2=(X)(y2);
			System.out.println(y2.SetX(5));
		}
	}





