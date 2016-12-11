public class Y extends X implements Conflict{

//	protected int y;

	public Y(){
		x=0;
//		y=0;
	}
	public Y(int a){
		super(a);
		x=0;
//		y=a;
	}
//	protected int getY(){
//		return y;
//	}
	protected static int SetX(int a){
		return 100;
	}
//	protected void conflictingMethod1(){
//		System.out.println("overide the superclass");
//	}
//	public String conflictingMethod(){
//		return "conflictingMethod from interface";
//		//System.out.println("conflictingMethod from interface:"+s);
//	}
	public String conflictingMethod(String s1){
	return "conflictingMethod from interface";
	//System.out.println("conflictingMethod from interface:"+s);
}


}



