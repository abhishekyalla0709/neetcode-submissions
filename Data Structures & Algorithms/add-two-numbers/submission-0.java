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
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        while(l1!=null && l2!=null){
            int num = l1.val + l2.val + carry;
            carry = num/10;
            num = num%10;
            ListNode temp = new ListNode(num);
            curr.next = temp;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int num = l1.val + carry;
            carry = num/10;
            num = num%10;
            ListNode temp = new ListNode(num);
            curr.next = temp;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int num = l2.val + carry;
            carry = num/10;
            num = num%10;
            ListNode temp = new ListNode(num);
            curr.next = temp;
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return ans.next;
    }

    // private ListNode reverse(ListNode head){
    //     if(head==null || head.next==null){
    //         return head;
    //     }
    //     ListNode curr = head;
    //     ListNode next = null;
    //     ListNode prev = null;
    //     while(curr!=null){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }
}
