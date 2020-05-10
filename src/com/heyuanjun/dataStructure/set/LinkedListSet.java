package com.heyuanjun.dataStructure.set;

import com.heyuanjun.dataStructure.linkedList.LinkedList;
import com.heyuanjun.dataStructure.utils.FileOperation;

import java.util.ArrayList;

/**
 * 基于链表实现的集合
 * Created by deng on 2020/4/3.
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> list;

    public LinkedListSet() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElemnet(e);
    }

    @Override
    public boolean containes(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        String classpath = LinkedListSet.class.getResource("/").getPath().replaceFirst("/", "");
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("E:\\heyuanjun-idea\\Data-Structure\\out\\production\\Data-Structure\\com\\heyuanjun\\dataStructure\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            LinkedListSet<String> set1 = new LinkedListSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }
    }
}
