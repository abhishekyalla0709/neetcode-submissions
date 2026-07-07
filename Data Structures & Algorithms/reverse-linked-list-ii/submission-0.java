class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode ans = new ListNode(-1);
        ans.next = head;

        // Find the node before 'left'
        ListNode left_side = ans;
        for (int i = 1; i < left; i++) {
            left_side = left_side.next;
        }

        // First node to be reversed
        ListNode curr = left_side.next;
        ListNode leftNode = curr;

        ListNode prev = null;
        ListNode next = null;

        // Reverse right-left+1 nodes
        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Reconnect
        left_side.next = prev;
        leftNode.next = curr;

        return ans.next;
    }
}