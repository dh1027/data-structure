package com.heyuanjun.dataStructure.set;

import com.heyuanjun.dataStructure.bst.BST;
import com.heyuanjun.dataStructure.utils.FileOperation;

import java.util.ArrayList;

/**
 * 基于二叉搜索树实现的Set
 * Created by deng on 2020/4/3.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST bst;

    public BSTSet() {
        this.bst = new BST();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean containes(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        String classpath = LinkedListSet.class.getResource("/").getPath().replaceFirst("/", "");
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\heyuanjun-idea\\Data-Structure\\out\\production\\Data-Structure\\com\\heyuanjun\\dataStructure\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }
    }
}
