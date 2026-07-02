/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Map<Node,Node> map = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            int val = curr.val;
            Node n1 = new Node(val);
            map.put(curr,n1);
            temp.next = n1;
            temp = temp.next;
            curr = curr.next;
        }
        curr = head;
        temp = dummy.next;
        while(curr!=null){
            Node r = curr.random;
            temp.random = map.get(r);
            curr = curr.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
