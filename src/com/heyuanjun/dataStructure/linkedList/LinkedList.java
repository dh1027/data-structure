package com.heyuanjun.dataStructure.linkedList;

/**
 * 链表
 * Created by deng on 2020/3/23.
 */
public class LinkedList<E> {

    private class Node<E> {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node<E>(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表索引index处添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node<E> node = new Node<>(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node<>(e, prev.next);
        size++;
    }

    /**
     * 在链表头添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾部添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的index位置的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }


    /**
     * 获取链表的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表index位置的元素
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 检查链表中是否有元素E
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    /**
     * 从链表中删除index位置的元素
     *
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        Node<E> prve = dummyHead;
        for (int i = 0; i < index; i++) {
            prve = prve.next;
        }
        Node<E> ret = prve.next;
        prve.next = ret.next;
        ret.next = null;
        size--;
        return ret.e;
    }

    /**
     * 从链表中删除第一个元素，返回删除的元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从链表中删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元素e
     *
     * @return
     */
    public void removeElemnet(E e) {
        Node<E> prve = dummyHead;
        while (prve.next != null) {
            if (prve.next.e.equals(e)) {
                break;
            }
            prve = prve.next;
        }
        if (prve.next != null) {
            Node<E> delNode = prve.next;
            prve.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }

}
