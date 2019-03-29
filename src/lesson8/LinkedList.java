package lesson8;


public class LinkedList<T> {

    private Node head;

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);

            return;
        }

        find(-1).next = new Node<>(value);
    }

    public T get(int idx) {
        Node<T>res = find(idx);

        return res == null ? null : res.value;
    }

//    public int remove(int idx) {
//        if (head == null)
//            return -1;
//
//        if (idx == 0) {
//            int val = head.value;
//
//            head = head.next;
//
//            return val;
//        }
//
//        Node prev = find(idx - 1);
//
//        if (prev != null) {
//            Node cur = prev.next;
//
//            if (cur != null) {
//                prev.next = prev.next.next;
//
//                return cur.value;
//            }
//        }
//
//        return -1;
//    }

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


class Node<T>{
   T value; //меняем для разных переменных

    Node next;

    public Node(T value) {
        this.value = value;
    }
}

