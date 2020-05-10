package com.heyuanjun.dataStructure.segmentTree;

/**
 * 融合器
 * Created by deng on 2020/4/11.
 */
public interface Merger<E> {
    E merger(E left, E right);
}
