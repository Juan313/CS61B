/* Set.java */

import list.*;

/**
 *  A Set is a collection of Comparable elements stored in sorted order.
 *  Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
	protected DList currentList;

  /**
   * Set ADT invariants:
   *  1)  The Set's elements must be precisely the elements of the List.
   *  2)  The List must always contain Comparable elements, and those elements
   *      must always be sorted in ascending order.
   *  3)  No two elements in the List may be equal according to compareTo().
   **/

  /**
   *  Constructs an empty Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public Set() {
    // Your solution here.
	  currentList = new DList();
  }

  /**
   *  cardinality() returns the number of elements in this Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public int cardinality() {
    // Replace the following line with your solution.
    return currentList.length();
  }

  /**
   *  insert() inserts a Comparable element into this Set.
   *
   *  Sets are maintained in sorted order.  The ordering is specified by the
   *  compareTo() method of the java.lang.Comparable interface.
   *
   *  Performance:  runs in O(this.cardinality()) time.
 * @throws InvalidNodeException
   **/
  public void insert(Comparable c) throws InvalidNodeException {
    // Your solution here.
	  if (cardinality()==0) {currentList.insertFront (c);}
	  else {
		  ListNode iterator = currentList.front();
		  Comparable currentItem=(Comparable)(iterator.item());
		  ListNode lastNode = currentList.back();
		  Comparable lastItem=(Comparable)(lastNode.item());

		  if(currentItem.compareTo(c)>0){
			  currentList.insertFront (c);
		  }else if (c.compareTo(lastItem)>0){
			  currentList.insertBack (c);
		  }else
			  if (currentItem.compareTo(c)<0) {
			  do{iterator=iterator.next();
			  currentItem=(Comparable)(iterator.item());

			  } while (currentItem.compareTo(c)<0);
		      if (currentItem.compareTo(c)!=0)
		      {iterator.insertBefore(c);}
		  }
	  }



  }

  /**
   *  union() modifies this Set so that it contains all the elements it
   *  started with, plus all the elements of s.  The Set s is NOT modified.
   *  Make sure that duplicate elements are not created.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Your implementation should NOT copy elements of s or "this", though it
   *  will copy _references_ to the elements of s.  Your implementation will
   *  create new _nodes_ for the elements of s that are added to "this", but
   *  you should reuse the nodes that are already part of "this".
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
 * @throws InvalidNodeException
   **/
  public void union(Set s) throws InvalidNodeException {
    // Your solution here.

	  ListNode left = currentList.front();
	  Comparable leftItem=(Comparable)(left.item());
	  ListNode iterator = s.currentList.front();
	  Comparable iteratorItem=(Comparable)(iterator.item());
	  do {
		  if(iteratorItem.compareTo(leftItem)<0){
			  left.insertBefore(iteratorItem);
			  iterator=iterator.next();
			  iteratorItem=(Comparable)(iterator.item());
		  } else if (iteratorItem.compareTo(leftItem)==0){
			  iterator=iterator.next();
			  iteratorItem=(Comparable)(iterator.item());
		  } else if (left!=currentList.back()&&(iteratorItem.compareTo(leftItem)>0)){
			  left=left.next();
			  leftItem=(Comparable)(left.item());
		  }
		  else if (left==currentList.back()&&(iteratorItem.compareTo(leftItem)>0)&&iterator!=s.currentList.back()){
			  left.insertAfter(iteratorItem);
			  iterator=iterator.next();
			  iteratorItem=(Comparable)(iterator.item());
		  }  else if (left==currentList.back()&&(iteratorItem.compareTo(leftItem)>0)&&iterator==s.currentList.back()){
			  left.insertAfter(iteratorItem);
			  iterator=iterator.next();

		  }
	  } while (iterator.isValidNode());

  }

  /**
   *  intersect() modifies this Set so that it contains the intersection of
   *  its own elements and the elements of s.  The Set s is NOT modified.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Do not construct any new ListNodes during the execution of intersect.
   *  Reuse the nodes of "this" that will be in the intersection.
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT CONSTRUCT ANY NEW NODES.
   *  DO NOT ATTEMPT TO COPY ELEMENTS.
 * @throws InvalidNodeException
   **/
  public void intersect(Set s) throws InvalidNodeException {
    // Your solution here.
	  ListNode left = currentList.front();

	  ListNode iterator = s.currentList.front();

	  do {
		  if (iterator.isValidNode()){
			  Comparable leftItem=(Comparable)(left.item());
			  Comparable iteratorItem=(Comparable)(iterator.item());
			  if(leftItem.compareTo(iteratorItem)<0){
				ListNode old = left;
				left=left.next();
				old.remove();
			  } else if (leftItem.compareTo(iteratorItem)==0){
				  left = left.next();

				  iterator = iterator.next();

			  } else if (leftItem.compareTo(iteratorItem)>0){
				  iterator = iterator.next();

			  }
		  }else {
				ListNode old = left;
				left=left.next();
				old.remove();
		  }

	  } while (left.isValidNode());
  }

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   *
   *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
   *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
   *            DEVIATIONS WILL LOSE POINTS.
   **/
  public String toString() {
    // Replace the following line with your solution.
    return currentList.toString();
  }

  public static void main(String[] argv) {
    Set s = new Set();
    Set s2;
	Set s3;

	try {
		s.insert(new Integer(3));
		s.insert(new Integer(4));
		s.insert(new Integer(3));
		System.out.println("Set s = " + s);

		s2 = new Set();
		s2.insert(new Integer(4));
		s2.insert(new Integer(5));
		s2.insert(new Integer(5));
		System.out.println("Set s2 = " + s2);
		System.out.println("cardinality of Set s2 = " + s2.cardinality());

		s3 = new Set();
		s3.insert(new Integer(5));
		s3.insert(new Integer(3));
		s3.insert(new Integer(8));
		System.out.println("Set s3 = " + s3);


		s.union(s2);
		System.out.println("After s.union(s2), s = " + s);

    s.intersect(s3);
    System.out.println("After s.intersect(s3), s = " + s);

    	Set jd1= new Set();
		jd1.insert(new Integer(1));
		jd1.insert(new Integer(8));
		jd1.insert(new Integer(16));
		jd1.insert(new Integer(12));
		jd1.insert(new Integer(17));
		jd1.insert(new Integer(18));
    	Set jd2= new Set();

		jd2.insert(new Integer(8));
		jd2.insert(new Integer(16));
		jd2.insert(new Integer(13));
		jd2.insert(new Integer(14));
		jd2.insert(new Integer(1));
		jd1.intersect(jd2);
	    System.out.println("After jd1.intersect(jd2), jd1 = " + jd1);

	} catch (InvalidNodeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    System.out.println("s.cardinality() = " + s.cardinality());
    // You may want to add more (ungraded) test code here.
  }
}
