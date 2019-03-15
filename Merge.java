import java.util.*;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data) {
    mergesort(data, 0, data.length -1);
  }
  private static void mergesort(int[]data, int lo, int hi) {
    if (lo >= hi) return ;
    int[] left = split(data, 0, midP(data));
    int[] right = split(data, midP(data), data.length);
    System.out.println(Arrays.toString(data));
    System.out.println("left : " + Arrays.toString(left));
    System.out.println("right : " + Arrays.toString(right));
    //mergesort(left);
    //mergesort(right);
    //mergeUP somehow
  }
  //finds the middle to partition mergesort left and right
  private static int midP(int[]data) {
    if (data.length % 2 == 1) {
      return data.length/2 + 1;
    }
    else return data.length/2;
  }
  //creates a subarray and copies over values from index to index specified;
  private static int[] split(int[] data, int s, int e) {
    int[] ans = new int[e-s];
    int pos = 0;
    for (int i = s; i < e; i++) {
      ans[pos] = data[i];
      pos++;
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] ary = new int[]{38, 27, 43, 3, 9, 83, 10};
    System.out.println("original : " + Arrays.toString(ary));
    mergesort(ary);
    System.out.println("sorted : " + Arrays.toString(ary));
    //[3,9,10,27,38,43,83];
  }

}
