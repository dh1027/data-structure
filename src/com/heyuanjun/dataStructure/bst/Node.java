package com.heyuanjun.dataStructure.bst;

/**
 * 树节点
 * Created by deng on 2020/4/1.
 */
public class Node<E extends Comparable<E>> {
    public E e;
    public Node left;
    public Node right;

    public Node getLeftChild() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRightChild() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(E e) {
        this.e = e;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "[" + e + "]";
    }
}
