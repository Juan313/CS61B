import list.DList;
import list.LockDList;

public class Test {

	public static void main(String[] args){
		DList aDList = new DList();
//		for (int i=0;i<=10;i++){
//			aDList.insertBack(new Integer(i));
//		}
		aDList.insertBack(new Integer(0));
//		aDList.insertBefore(new Integer(-1), aDList.front());
		System.out.println(aDList.toString());
		System.out.println(aDList.length());

//		aDList.remove(aDList.prev(aDList.back()));
		aDList.remove(aDList.back());
		System.out.println(aDList.toString());
		System.out.println(aDList.length());
		
		LockDList LDList = new LockDList();
		for (int i=0;i<=10;i++){
		LDList.insertBack(new Integer(i));
		}		
		LDList.front().lockNode();
		LDList.front().isLocked();
		System.out.println(LDList.toString());
	}
}
