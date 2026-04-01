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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = getMid(head);
        ListNode headS = reverseList(mid);
        ListNode headf = head;

        while(headf != null && headS != null){
            ListNode temp = headf.next;
            headf.next = headS;
            headf = temp;
            temp = headS.next;
            headS.next = headf;
            headS = temp;
        }

        if(headf != null){
            headf.next = null;
        }
        
    }

    public ListNode getMid(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){
            f= f.next.next;
            s = s.next;
        }
        return s;
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode nxt = current.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current =  nxt;
            if(nxt != null){
                nxt = nxt.next;
            }
        }
        return prev;
    }

}