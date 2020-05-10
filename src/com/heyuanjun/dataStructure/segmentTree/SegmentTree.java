package com.heyuanjun.dataStructure.segmentTree;

/**
 * 线段树
 * Created by deng on 2020/4/11.
 */
public class SegmentTree<E> {
    /**
     * 树状的数组
     */
    private E[] tree;
    /**
     * 原始数据的副本
     */
    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //构成的树节点为原始数据节点的斯4倍则肯定能构建成线段树
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    //在treeIndex的位置创建表示区间[1...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftChildIndex = getLeftChild(treeIndex);
        int rightChildIndex = getRightChild(treeIndex);

        //int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);

        tree[treeIndex] = merger.merger(tree[leftChildIndex], tree[rightChildIndex]);

    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    public int getLeftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    public int getRightChild(int index) {
        return 2 * index + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length - 1 || queryR < 0 || queryR > data.length - 1 || queryL > queryR) {
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    public E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        //treeIndex的节点分为[1...mid]和[mid+1...r]两部分

        int leftChildIndex = getLeftChild(treeIndex);
        int rightChildIndex = getRightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightChildIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftChildIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftChildIndex, 1, mid, queryL, mid);
        E rightResult = query(rightChildIndex, mid + 1, r, mid + 1, queryR);
        return merger.merger(leftResult, rightResult);

    }

    // 将index位置的值，更新为e
    public void set(int index, E e) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 在以treeIndex为根的线段树中更新index的值为e
    public void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = getLeftChild(treeIndex);
        int rightTreeIndex = getRightChild(treeIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else // index <= mid
            set(leftTreeIndex, l, mid, index, e);

        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
