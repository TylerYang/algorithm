/*
 * Dutch National Flag Problem by Edsger Dijkstra
 */
public class ThreeWayPartition {
  public static void threeWayPartition(int[] nums, int mid) {
    int firstP = 0, midP = 0, lastP = nums.length - 1;
    while(midP <= lastP) {
      if(nums[midP] < mid) {
        swap(nums, firstP++, midP++);
      } else if(nums[midP] > mid) {
        swap(nums, lastP--, midP);
      } else {
        midP++;
      }
    }
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
    int[] nums = {0, 1, 2, 2, 1, 1, 0, 2};
    printArray(nums);
    threeWayPartition(nums, 1);
    printArray(nums);
  }
}
