/* HashTableChained.java */

package dict;
import list.InvalidNodeException;
import list.ListNode;
import list.SList;
import list.SListNode;
/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	private int numberofEntries;
	private int numberofBuckets;
	private SList[] hashTable;

  /**
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	  numberofBuckets=2*sizeEstimate-1;
	  while (!isPrime(numberofBuckets)&&numberofBuckets>=sizeEstimate) {
		  numberofBuckets=numberofBuckets-1;
	  }
	  hashTable=new SList[numberofBuckets];

  }
  public static boolean isPrime(int n){
	  int divisor=2;
	  while (divisor<n){
		  if (n%divisor==0){
			  return false;
		  }
		  divisor++;
	  }
	  return true;
  }

  /**
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
	  numberofBuckets=97;
	  hashTable=new SList[numberofBuckets];
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
	int sum=(int)(((long)(17*code+19))%2147483647);

	int compressed = Math.abs(sum)%numberofBuckets;

    return compressed;
  }

  /**
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return numberofEntries;
  }

  /**
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
	  if (numberofEntries==0)
	  {return true;}else
	  {
		  return false;
	  }

  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
	  Entry newEntry = new Entry();
	  newEntry.key=key;
	  newEntry.value=value;
	  hashTable[compFunction(key.hashCode())].insertBack(newEntry);
	  numberofEntries++;
      return newEntry;
  }

  /**
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	  SList chainofEntries = hashTable[compFunction(key.hashCode())];
	  ListNode iterator = chainofEntries.front();
	  try {
		while (iterator!=null){
			  if(((Entry) iterator.item()).key().equals(key)){
				  return (Entry) iterator.item();
			  }
			  iterator=iterator.next();
		  }
	} catch (InvalidNodeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return null;
  }

  /**
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.

		  SList chainofEntries = hashTable[compFunction(key.hashCode())];
		  ListNode iterator = chainofEntries.front();
		  try {
				while (iterator!=null){
					  if(((Entry) iterator.item()).key().equals(key)){
						  Entry removedEntry=new Entry();
						  removedEntry=(Entry) iterator.item();
						  iterator.remove();
						  numberofEntries--;
						  return removedEntry;
					  }
					  iterator=iterator.next();
				  }
			} catch (InvalidNodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  return null;

  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
	  for (int i=0;i<numberofBuckets;i++){
		  hashTable[i]=new SList();
	  }
	  numberofEntries=0;
  }
  public void printCollision(){
	  int sum=0;
	  int collision=0;
	  System.out.printf("%15s", "collision");
	  for (int i=0;i<numberofBuckets;i++){
		  SList s=hashTable[i];

		  System.out.printf("%5d", s.length());

	  }
	  System.out.println("");
	  System.out.printf("%15s", "bucket");
	  for (int i=0;i<numberofBuckets;i++){
		  SList s=hashTable[i];
		  System.out.printf("%5d", i);

		  sum=sum+s.length();
		  if (s.length()>1)
			  collision=collision+s.length()-1;
	  }
	  System.out.println("");
	  System.out.printf("total entries = %d; ",sum);
	  System.out.printf("total collisions= %d",collision);


  }

}
