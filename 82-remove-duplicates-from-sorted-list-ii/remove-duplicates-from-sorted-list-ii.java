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
        List<Integer> list = new ArrayList<>(); // store all node 
        Map<Integer, Integer> map = new HashMap<>();  // isliye taaki freq count ralh sake
        ListNode temp = head;  // head ko temp mae store  kiya
        while(temp != null){
            list.add(temp.val); // jab tak temp null na ho jaaye list mae node ko add karte rhege
            map.put(temp.val, map.getOrDefault(temp.val, 0) +1 ); // agar value nhi hai 0 other +1 add kr denga
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0); // to handle edge case that if head is removed 
        ListNode curr = dummy;
        for (int i = 0; i < list.size(); i++) {
        int val = list.get(i);
        if (map.get(val) == 1){ // agar node exactly 1 baar mile 
            curr.next = new ListNode(val);
            curr = curr.next;
        }
}

 return dummy.next;
        
    }
}