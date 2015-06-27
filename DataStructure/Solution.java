import java.util.Comparator;
public class Solution{
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[4];
        lists[0] = new ListNode(4);
        lists[1] = new ListNode(3);
        lists[2] = new ListNode(2);
        lists[3] = new ListNode(6);

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        
        for(int i = 0; i < lists.length; i++ ){
            pq.add(lists[i]);
        }
        while(pq.size() > 0) {
            ListNode n = pq.poll();
            System.out.println(n.val);
        }
        System.out.println("end");
//

        int[] arr = {1, 4, 5, 3, 2, 6, 8 ,9, 5, 4};
        PriorityQueue<Integer> iPG = new PriorityQueue<Integer>();
        for(int i = 0; i < arr.length; i++) {
            iPG.add(arr[i]);
        }
        while(iPG.size() > 0 ){
            System.out.print(iPG.poll() + " ");
        }
        System.out.println("");
        
    }
    
}
