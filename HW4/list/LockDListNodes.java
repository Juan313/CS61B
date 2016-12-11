package list;

public class LockDListNodes extends DListNode {
	protected boolean locked;
	public LockDListNodes(Object i, DListNode p, DListNode n) {
		super(i, p, n);
		locked=false;
		// TODO Auto-generated constructor stub
	}
	public void lockNode(){
		locked=true;
	}
	public boolean isLocked(){
		if (locked=true) {return true;}
		else return false;
	}

}
