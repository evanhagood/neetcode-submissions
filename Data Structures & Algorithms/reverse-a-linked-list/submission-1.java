class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = head;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next; // save the next pointer
            curr.next = prev; // swap the pointers
            prev = curr;      // progress the previous pointer
            curr = next;      // progree the current pointer
        }

        return prev;        // curr pointer is null, list starts at previous node.
    }
}