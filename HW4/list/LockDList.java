package list;

public class LockDList extends DList {

	public void lockNode(DListNode node){
		LockDListNodes lockNode = (LockDListNodes)node;
		lockNode.lockNode();
	}
	public void remove(LockDListNodes node) {
	    // Your solution here.
		if (node.isLocked()){}
		else super.remove(node);
	  }
	  public LockDListNodes front() {
		  super.front();
		  }
}
