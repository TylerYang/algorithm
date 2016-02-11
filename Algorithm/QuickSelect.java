/*
 * Quick Select
 * find kth large element with linear time complexity
 */
import java.util.Random;
public class QuickSelect {
  public static int select(int[] nums, int k) {
    int left = 0, right = nums.length - 1;
    Random rand = new Random();
    while(left <= right) {
      int pivotPos = partition(nums, left, right, rand.nextInt(right - left + 1) + left);
      if(pivotPos == k) {
        return nums[pivotPos];
      } else if(pivotPos < k) {
        left = pivotPos + 1;
      } else{
        right = pivotPos - 1;
      }
    }
    return nums[k];
  }
  public static int partition(int[] nums, int left, int right, int pivotPos) {
    int mid = nums[pivotPos];
    swap(nums, right, pivotPos);

    int i = left, j = right - 1;
    while(i <= j) {
      while(i <= j && nums[i] <= mid) i++;
      while(i <= j && nums[j] > mid) j--;
      if(i <= j) {
        swap(nums, i++, j--);
      }
    }
    swap(nums, i, right);
    return i;
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
  public static void printArray(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println("");
  }
  public static void main(String[] args) {
    int[] nums = {2, 1, 3, 8, 9, 6, 4, 5, 7, 0};
    for(int i = 0; i < nums.length; i++) {
      System.out.println("i: " + i + ", result: " + select(nums, i));
    }
  }
}
