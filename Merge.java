public class Merge{
  public static void mergesort(int[]data) {
    mergesort(data, 0, data.length -1);
  }
  private static void mergesort(int[]data, int lo, int hi) {
    if (lo >= hi) return ;
    mergesort(data, lo, midP(data));
    mergesort(data, midP(data) + 1, hi);
    //mergeUP somehow
  }

  private static int midP(int[]data) {
    if (data.length % 2 == 1) {
      return data.length/2 + 1;
    }
    else return data.length/2;
  }

  private static void mergeUP (int[] l, int[] r, int[] above) {
    for (int i = 0; i < l.length; i++) {
      if (l[i] <= r[i]) above[i] = l[i];
      else above[i] = r[i];
    }
  }

}
