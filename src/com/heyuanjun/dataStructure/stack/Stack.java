package com.heyuanjun.dataStructure.stack;

/**
 * Created by deng on 2020/3/22.
 */
public interface Stack<E> {
    /**
     * 入栈，将元素压人栈顶
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈，将元素从栈顶弹出
     *
     * @return
     */
    E pop();

    /**
     * 检查栈顶元素
     */
    E peek();

    /**
     * 检查栈的大小
     */
    int getSize();

    /**
     * 检查栈是否为空
     */
    boolean isEmpty();
}
