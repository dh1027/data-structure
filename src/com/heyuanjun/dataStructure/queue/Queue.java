package com.heyuanjun.dataStructure.queue;

/**
 * Created by deng on 2020/3/23.
 */
public interface Queue<E> {
    /**
     * 入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     *
     * @return
     */
    E dequeue();

    /**
     * 检查队首元素
     *
     * @return
     */
    E getFront();

    /**
     * 检查队列大小
     *
     * @return
     */
    int getSize();

    /**
     * 检查队列是否为空
     *
     * @return
     */
    boolean isEmpty();
}
