package io.chengsean.programstudy.algorithms.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 * @author 程绍壮
 * @dateTime 2021-11-02 03:12
 */
public class QuickSort<T extends Comparable<T>> extends AbsArray<T> implements SortSupport<T> {

    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] integers = new Integer[]{1, 1, 24, 2, 2, 5, 15, 43, 7, 3, 8, 8, 6, 9, 11, 14, 4};
        System.out.printf("before sort：%s%n", Arrays.asList(integers));
        quickSort.sort(integers);
        System.out.printf("after sort：%s%n", Arrays.asList(integers));
    }

    @Override
    public void sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // 打乱顺序
        List<T> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
        this.sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = this.partition(arr, left, right);
        this.sort(arr, left, mid - 1);
        this.sort(arr, mid + 1, right);
    }

    private int partition(T[] arr, int left, int right) {
        int l = left, r = right + 1;
        boolean less;
        T value = arr[l];
        while (true) {
            do {
                less = this.less(value, arr[++l]);
            } while (less && l != right);
            do {
                less = this.less(arr[--r], value);
            } while (less && r != left);
            if (l >= r) {
                break;
            }
            this.swap(arr, l, r);
        }
        this.swap(arr, left, r);
        return r;
    }
}
