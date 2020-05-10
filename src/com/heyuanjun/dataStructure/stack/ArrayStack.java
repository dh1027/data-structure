package com.heyuanjun.dataStructure.stack;

import com.heyuanjun.dataStructure.array.Array;

/**
 * 基于数组的栈实现
 * Created by deng on 2020/3/22.
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    public ArrayStack(int capacity) {
        data = new Array<E>(capacity);
    }

    public ArrayStack() {
        this(10);
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
