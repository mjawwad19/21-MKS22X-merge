import java.util.*;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data) {
    int[] temp = new int[data.length]; //preallocate to wrapper method
    //mergesort(data, 0, data.length -1);
    mergesort(data, temp, 0, data.length -1);
  }
  /*private static void mergesort(int[]data, int lo, int hi) {
    if (lo >= hi) return ;
    if (hi - lo <= 7) {
      insertionSort(data,lo, hi);
      return;
    }
    int[] left = split(data, 0, midP(lo, hi));
    int[] right = split(data, midP(lo, hi), data.length);
    //System.out.println("left : " + Arrays.toString(left));
    //System.out.println("right : " + Arrays.toString(right));
    mergesort(left);
    mergesort(right);
    mergeUP(data, left, right);
    //System.out.println(Arrays.toString(data));
  }
  //finds the middle to partition mergesort left and right
  private static int midP(int lo, int hi) {
    if ((hi -lo) % 2 == 1) {
      return (hi + lo)/2 + 1;
    }
    else return (hi + lo)/2;
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
  /*compares the values @ the inindicesdices of the left and right arrays,
  merges to the array the level above whichever is smaller
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
  }*/

  //currently stack overflow*
  private static void mergesort(int[]data, int[] temp, int lo, int hi) {
    if (hi - lo <= 7) {
      insertionSort(data, lo, hi);
      return;
    }
    for (int i = lo; i < hi+1; i++) {
      temp[i] = data[i]; //copy data to temp;
    }
    int mid = (lo / 2) + (hi/2);
    mergesort(temp, data, lo, mid); //left
    mergesort(temp, data, mid +1, hi); //right
    mergePLUS(data, temp, lo, mid, hi);
    }

  private static void mergePLUS(int[] data, int[] temp, int lo, int mid, int hi) {
    int i0 = lo;
    int i1 = mid +1;
    int dI = lo;
    while (i0 <= mid || i1 <= hi) {
      if (i0 > mid) {
        data[dI] = temp[i1];
        i1++;
      }else if (i1 > hi) {
        data[dI] = temp[i0];
        i0++;
      }else if (temp[i0] <= temp[i1]) {
        data[dI] = temp[i0];
        i0++;
      }else {
        data[dI] = temp[i1];
        i1++;
      }
      dI++;
    }
  }


  private static void insertionSort(int[] d, int l, int h) {
    for (int i = l + 1; i < h + 1; i++) {
      int temp = d[i];
      int j = i;
      while (j > l && temp < d[j-1]) {
        d[j] = d[j-1];
        j--;
      }
      d[j] = temp; //swap
    }
  }

  public static void main(String[] args) {
    int[] ary = new int[]{38, 27, 43, 3, 9, 83, 10};
    System.out.println("original : " + Arrays.toString(ary));
    mergesort(ary);
    System.out.println("sorted : " + Arrays.toString(ary));
    //[3,9,10,27,38,43,83];

    int[] dup = new int[]{38,38, 27, 27, 12, 24, 3, 100, 39, 6, 0, 1, 1};
    System.out.println("original : " + Arrays.toString(dup));
    mergesort(dup);
    System.out.println("sorted : " + Arrays.toString(dup));
    //[0,1,1,3,6,12,24,27,27,38,38,39,100];
  }

}
