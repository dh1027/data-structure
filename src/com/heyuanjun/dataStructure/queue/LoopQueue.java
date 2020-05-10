package com.heyuanjun.dataStructure.queue;


import java.util.Random;

/**
 * 循环队列
 * Created by deng on 2020/3/23.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] array;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize(getCapacity() * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = array[(i + front) % array.length];
        }
        array = newData;
        front = 0;
        tail = size;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == front;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return array[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length - 1;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % array.length){
            res.append(array[i]);
            if((i + 1) % array.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

//        LoopQueue<Integer> queue = new LoopQueue<>();
//        for(int i = 0 ; i < 10 ; i ++){
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if(i % 3 == 2){
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
