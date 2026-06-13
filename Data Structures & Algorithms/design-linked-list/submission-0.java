/**
 * Implementation of a doubly linked list for LeetCode 707: Design Linked List.
 *
 * Supports:
 * - get(index)
 * - addAtHead(val)
 * - addAtTail(val)
 * - addAtIndex(index, val)
 * - deleteAtIndex(index)
 *
 * The list tracks both head and tail references so tail operations are O(1).
 */
class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    public int get(int index) {
        ListNode node = getNodeAtIndex(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        length++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        if (index == length) {
            addAtTail(val);
            return;
        }

        ListNode current = getNodeAtIndex(index);
        ListNode newNode = new ListNode(val);

        // Insert newNode before current.
        newNode.prev = current.prev;
        newNode.next = current;

        current.prev.next = newNode;
        current.prev = newNode;

        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }

        if (length == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == length - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            ListNode node = getNodeAtIndex(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        length--;
    }

    private ListNode getNodeAtIndex(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index < length / 2) {
            ListNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            ListNode current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    private class ListNode {
        private int val;
        private ListNode next;
        private ListNode prev;

        private ListNode(int val) {
            this.val = val;
        }
    }
}