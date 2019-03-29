package nested;


import java.util.Iterator;
import java.util.ListIterator;

public class LinkedList {

    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);

            return;
        }

        find(-1).next = new Node(value);
    }

    public int get(int idx) {
        Node res = find(idx);

        return res == null ? -1 : res.value;
    }

    public int remove(int idx) {
        if (head == null)
            return -1;

        if (idx == 0) {
            int val = head.value;

            head = head.next;

            return val;
        }

        Node prev = find(idx - 1);

        if (prev != null) {
            Node cur = prev.next;

            if (cur != null) {
                prev.next = prev.next.next;

                return cur.value;
            }
        }

        return -1;
    }

    private Node find(int idx) {
        if (idx == 0)
            return head;

        int cnt = 0;

        Node node = head;

        while (node != null) {
            if (cnt++ == idx)
                return node;

            if (idx < 0 && node.next == null)
                return node;

            node = node.next;
        }

        return null;
    }




}


class Node {
    int value;

    Node next;

    public Node(int value) {
        this.value = value;
    }
}

