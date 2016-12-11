import java.io.*;

public class Nuke2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader keyboard;
		String inputLine;
		keyboard=new BufferedReader(new InputStreamReader(System.in));
		inputLine=keyboard.readLine();
		if(inputLine.length()>=2){
		String newString = inputLine.substring(0,1)+inputLine.substring(2,inputLine.length());
		System.out.println(newString);
		}else{
		System.out.println("Input String should include at least two characters!");
		}

	}

}
