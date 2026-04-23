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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
       ListNode dummy=new ListNode(0);
       ListNode curr=dummy;
       ListNode temp1=head;
      ListNode temp2=head.next;
      
       while(temp1!=null)
       {
        if(temp2==null||temp1.val!=temp2.val)
        {
            curr.next=temp1;
            temp1=temp1.next;
            if(temp2!=null) temp2=temp2.next;
            curr=curr.next;
        }
        else{
            while (temp2!=null && temp1.val==temp2.val){
                temp2=temp2.next;
            }
            temp1=temp2;
             if(temp2!=null)
            temp2=temp2.next;
            curr.next=temp1;}
       }
       curr.next=null;
       return dummy.next;
    }
}