package com.heyuanjun.dataStructure.leetCode;

/**
 * 数组求和
 * Created by deng on 2020/3/25.
 */
public class Sum {
    public int sum(int[] arr) {
        if (arr == null) {
            return 0;
        }
        return sum(arr, 0);
    }

    private int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println((new Sum()).sum(arr));
    }
}

