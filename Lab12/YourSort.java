/* YourSort.java */

public class YourSort {

  public static void sort(int[] A) {
    // Place your Part III code here.
      sort(A,0,A.length-1);
      
  }
  private static void sort(int[] a, int low, int high){
      if (low<high){
          int pivotIndex=(int)(a.length*Math.random());
          int pivot=a[high];
          a[high]=pivot;
          
          int i =low-1;
          int j=high;
          do{
              do {i++;} while (a[i]<pivot);
              do {j--;} while ((a[j]>pivot)&&j>low);
              if (i<j){
            	  Sort.swapReferences(a, i, j);
              }
          }
          while (i<j);
          a[high]=a[i];
          a[i]=pivot;
          sort(a,low,i-1);
          sort(a,i+1,high);
      }
  }
}
