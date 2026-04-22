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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1=l1;
        ListNode prev1=null;
        while(curr1!=null){
            ListNode nextNode1=curr1.next;
            curr1.next=prev1; prev1=curr1; curr1=nextNode1; }
        ListNode curr2=l2;  ListNode prev2=null;
        while(curr2!=null) {
            ListNode nextNode2=curr2.next;
            curr2.next=prev2; prev2=curr2; curr2=nextNode2; }
            l1=prev1;
            l2=prev2;
       ListNode dummy=new ListNode (0);
        ListNode curr=dummy;  int carry=0;
        while(l1!=null || l2!=null||carry!=0){
            int x,y;
            if(l1!=null) x=l1.val; else x=0;
           if(l2!=null) y=l2.val;else  y= 0;
            int sum=carry+x+y; carry=sum/10;
            curr.next= new ListNode(sum%10); curr=curr.next;
            if(l1!=null) l1=l1.next;if(l2!=null) l2=l2.next; }
            ListNode c=dummy.next; ListNode prev=null;
            while(c!=null) {
                ListNode nextNode=c.next;
                c.next=prev;prev=c;c=nextNode;}
            return prev;
    }
}