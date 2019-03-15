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
    System.out.println("left : " + Arrays.toString(left));
    System.out.println("right : " + Arrays.toString(right));
    mergesort(left);
    mergesort(right);
    mergeUP(data, left, right);
    System.out.println(Arrays.toString(data));
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

  private static void mergeUP(int[] d, int[] l, int[] r){
    int lpos = 0;
    int rpos = 0;
    for (int i = 0; i < d.length; i++) {
      if (rpos >= r.length) {
        d[i] = l[lpos];
        lpos++;
      } //these two are to prevent indexoutofbounds
      else if (lpos >= l.length) {
        d[i] = r[rpos];
        rpos++;
      }
      else if (r[rpos] < l[lpos]) {
        d[i] = r[rpos];
        rpos++;
      } //these two are comparing which is greater in the arrays and shoving them up to the array on the level above
      else {
        d[i] = l[lpos];
        lpos++;
      }
    }
  }
  public static void main(String[] args) {
    int[] ary = new int[]{38, 27, 43, 3, 9, 83, 10};
    System.out.println("original : " + Arrays.toString(ary));
    mergesort(ary);
    System.out.println("sorted : " + Arrays.toString(ary));
    //[3,9,10,27,38,43,83];
  }

}
