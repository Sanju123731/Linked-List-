/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result=new ListNode [k];
          int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int baseSize=size/k;
        int extra=size%k;
         curr = head;
        
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                result[i] = null;
                continue;
            }
             result[i] = curr; // head of current part
            
            int partSize = baseSize + (extra > 0 ? 1 : 0);
            if (extra > 0) extra--;
            
            // Move to the last node of this part
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            
            // Cut the list
            ListNode nextPart = curr.next; // store next part head
            curr.next = null;              // break link
            
            curr = nextPart;               // move to next part
        }
        
        return result;
    }
}