public class X {

protected int x;
protected static final String con="superclass";
public X(){
	x=0;
}
public X(int a){
	x=a;
}
protected int getX(){
	return x;
}
protected static int SetX(int a){
	return a;
}
//protected void conflictingMethod1(){
//	//return "conflictingMethod from superclass";
//	System.out.println("conflictingMethod from superclass");
//}
protected String conflictingMethod(String s2){
return "conflictingMethod from superclass";

}
}
