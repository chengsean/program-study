package io.chengsean.programstudy.algorithms.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 插入排序
 * @author 程绍壮
 * @dateTime 2021-11-02 03:12
 */
public class InsertionSort<T extends Comparable<T>> extends AbsArray<T> implements SortSupport<T> {

    public static void main(String[] args) {
        InsertionSort<Integer> quickSort = new InsertionSort<>();
        Integer[] integers = new Integer[]{11, 1, 24, 2, 2, 5, 15, 43, 7, 3, 8, 8, 6, 9, 1, 14, 4};
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
        for (int i = left, j = i; i < right; j = ++i) {
            T next = arr[i + 1];
            while (this.less(next, arr[j])) {
                arr[j + 1] = arr[j];
                if (j-- == left) {
                    break;
                }
            }
            arr[j + 1] = next;
        }
    }
}
