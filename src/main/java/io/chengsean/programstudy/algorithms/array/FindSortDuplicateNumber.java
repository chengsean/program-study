package io.chengsean.programstudy.algorithms.array;

import java.io.IOException;
import java.util.Arrays;

/**
 * 在一个长度为n的,数组里的所有数字为随机数的
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * @author 程绍壮
 * @dateTime 2021-10-21 18:08
 */
public class FindSortDuplicateNumber {
    public static void main(String[] args) throws IOException {
        System.out.println("replicate int: " + findReplicate());
    }

    private static int findReplicate() {
        int[] ints = new int[]{15,2,6,21,14,5,2};
        Arrays.sort(ints);
        int replicateInt = -1;
        for (int i = 0; i < ints.length; i++) {
            if (i > 0 && ints[i - 1] == ints[i]) {
                replicateInt = ints[i];
                break;
            }
        }
        return replicateInt;
    }
}
