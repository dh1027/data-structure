package com.heyuanjun.dataStructure.array;

/**
 * Created by deng on 2020/3/22.
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 有参构造hanshu
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(10);
    }


    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        size = arr.length;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * [1,2,3,4]
     * 在index索引的位置插入一个元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Fail, Index Is Invalid.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        //从右向左移动元素，使index位置的元素无效
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向所有元素后面添加一个元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在所有元素前添加一个元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取索引index的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Fail, Index Is Invalid.");
        }
        return data[index];
    }

    /**
     * 修改index索引位置元素为e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Fail, Index Is Invalid.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove Fail, Index Is Invalid.");
        }
        E e = data[index];
        //从左向右将元素往前移动一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //缩容
        if (size == data.length / 4)
            resize(data.length / 2);
        return e;
    }

    /**
     * 从数组删除第一个元素，返回删除的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组删除最后一个元素，返回删除的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素
     */
    public void removeElement(E e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    /**
     * 获取数组最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    /**
     * 将数组空间的容量变成newCapacity大小
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 交换两个索引处的元素
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
