/* Names.java */

import java.io.*;

/** The Names class provides a single function, main, that will
 *   perform various manipulations of the name John Fitzgerald Kennedy.
 *   This is a modification of the program on page 43 of Arnow and Weiss.
 */

class Silly {

/** Performs various string operations on the name John Fitzgerald Kennedy.
 *  @param arg is not used.
 */
  public static void main(String arg[]) {
    String first = "John";
    String middle = "Fitzgerald";
    String last = "Kennedy";
    String initials;
    String firstInit, middleInit, lastInit;

    firstInit = first.substring(0,1);
    middleInit = middle.substring(0,1);
    lastInit = last.substring(0,1);
    initials = firstInit.concat(middleInit);
    initials = initials.concat(lastInit);
    String s="01/01/407";

    int index=0;
	  index=s.indexOf("/");
	  int month=Integer.parseInt(s.substring(0,index));
	  String dayAndYear;
	  dayAndYear=s.substring(index+1,s.length());
	  index=dayAndYear.indexOf("/");
	  int day=Integer.parseInt(dayAndYear.substring(0,index));
	  String justYear;
	  justYear=dayAndYear.substring(index+1,dayAndYear.length());
	 int year=Integer.parseInt(justYear);

    System.out.println();
    System.out.println(first + " " + middle + " " + last + " ");
    System.out.println(initials);
    System.out.println(last + ", " + first + " " + middle);
    System.out.println(last + ", " + first + " " + middleInit +".");
    System.out.println(first.toUpperCase() + " " + last.toUpperCase());

    System.out.println(first + " equals john is " + first.equals("john"));
    System.out.println(first + " equals john (ignoring case) is "
		       + first.equalsIgnoreCase("john"));
    System.out.println("The character at index 3 in " + middle + " is " +
		       middle.substring(3,4));
    System.out.println("The index of \"gerald\" within " + middle + " is " +
		       middle.indexOf("gerald"));
    System.out.println("The index of \"gerald\" within " + last + " is " +
		       last.indexOf("gerald"));

    System.out.println(month+"/"+day+"/"+year);

    System.out.println();
  }
}
