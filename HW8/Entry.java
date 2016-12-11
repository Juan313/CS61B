import list.QueueEmptyException;


public class Entry implements Comparable {
	int key;
	String s;
	Entry(int k, String s1){
		key=k;
		s=s1;
	}
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		if (this.key<((Entry)arg0).key){
		return -1;}
		else if (this.key==((Entry)arg0).key){
		return 0;}
		else return 1;

	}
	  public String toString() {
		    String out = key + ":" + s;
		    return out;
		  }

}
