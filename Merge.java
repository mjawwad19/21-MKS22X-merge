import java.util.*;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data) {
    mergesort(data, 0, data.length -1);
  }
  private static void mergesort(int[]data, int lo, int hi) {
    if (lo >= hi) return ;
    System.out.println(Arrays.toString(data));
    mergesort(data, lo, midP(data));
    mergesort(data, midP(data) + 1, hi);
    //mergeUP somehow
  }
  //finds the middle to partition mergesort left and right
  private static int midP(int[]data) {
    if (data.length % 2 == 1) {
      return data.length/2 + 1;
    }
    else return data.length/2;
  }

  public static void main(String[] args) {
    int[] ary = new int[]{38, 27, 43, 3, 9, 83, 10};
    System.out.println("original : " + Arrays.toString(ary));
    mergesort(ary);
    System.out.println("sorted : " + Arrays.toString(ary));
    //[3,9,10,27,38,43,83];
  }

}
