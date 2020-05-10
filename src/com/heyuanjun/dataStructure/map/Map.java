package com.heyuanjun.dataStructure.map;

/**
 * Map 映射
 * Created by deng on 2020/4/3.
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
