
public class Run {
	public int[] node;
	public Run next;
	public Run prev;
	public Run(int red, int green,
            int blue, int runLengths){
		node = new int[4];
		node[0]=red;
		node[1]=green;
		node[2]=blue;
		node[3]=runLengths;
		next=null;
		prev=null;
	}
	public Run(){
		node = new int[4];
		next=null;
		prev=null;
	}
}
