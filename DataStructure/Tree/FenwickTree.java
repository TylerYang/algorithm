public class FenwickTree {
  int len;
  int[] arr;
  public FenwickTree(int len) {
    this.len = len;
    this.arr = new int[len + 1];
  }
  public int sum(int x) {
    int total = 0;
    while(x > 0) {
      total += arr[x];
      x -= lowbit(x);
    }
  }
  public void insert(int x, int diff) {
    while(x <= len) {
      arr[x] += diff;
      x += lowbit(x);
    }
  }
  private int lowbit(int x) {
    return x & -x;
  }
}
