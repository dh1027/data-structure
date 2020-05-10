package com.heyuanjun.dataStructure.set;

/**
 * 集合
 * Created by deng on 2020/4/3.
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean containes(E e);

    int getSize();

    boolean isEmpty();
}
