package com.heyuanjun.dataStructure.bst;

import com.heyuanjun.dataStructure.queue.LinkedListQueue;
import com.heyuanjun.dataStructure.queue.Queue;
import com.heyuanjun.dataStructure.utils.TreePrintUtil;

/**
 * 二分搜索树
 * Created by deng on 2020/3/28.
 */
public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中添加新元素
     * 返回插入新节点后的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo((E) node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo((E) node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    /**
     * 检查二分搜索树种是否包含某个元素
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 检查以node为根节点的树中是否包含元素e
     *
     * @param node
     * @param e
     * @return
     */
    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 递归前序遍历
     */
    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void miOrder() {
        miOrder(root);
    }

    /**
     * 递归前序遍历
     */
    public void miOrder(Node node) {
        if (node == null) {
            return;
        }
        miOrder(node.left);
        System.out.println(node.e.toString());
        miOrder(node.right);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 递归后序遍历
     */
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 二分搜索树层序遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedListQueue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node cur = q.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.enqueue(cur.left);
            }
            if (cur.right != null) {
                q.enqueue(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小值
     *
     * @return
     */
    public E minmun() {
        return (E) minmun(root).e;
    }

    //返回以node为根的二分搜索树的最小所在的节点
    private Node minmun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmun(node.left);
    }

    /**
     * 寻找二分搜索树的最d大值
     *
     * @return
     */
    public E maxmun() {
        return (E) maxmun(root).e;
    }

    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maxmun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmun(node.right);
    }

    //从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin() {
        E ret = minmun();
        root = removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax() {
        E ret = maxmun();
        root = removeMax(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {

        if (node == null)
            return null;

        if (e.compareTo((E) node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo((E) node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minmun(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        bst.preOrder();
//        System.out.println();
//
//        System.out.println(bst);
        TreePrintUtil.pirnt(bst.getRoot());
        bst.removeMax();
        TreePrintUtil.pirnt(bst.getRoot());
        bst.removeMin();
        TreePrintUtil.pirnt(bst.getRoot());

    }


}
