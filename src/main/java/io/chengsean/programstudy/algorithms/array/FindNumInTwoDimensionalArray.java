package io.chengsean.programstudy.algorithms.array;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，
 * 从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * @author 程绍壮
 * @dateTime 2021-10-23 17:47
 */
public class FindNumInTwoDimensionalArray {
    public static void main(String[] args) {
        int num = 25;
        System.out.printf("find number, expected: %s, got: %s %n", num, findNum(num));
    }

    private static int findNum(int num) {
        int[][] _2DArray = new int[][]{
                {1,  4,  7, 11, 15},
                {2,  5,  8, 12, 19},
                {3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        for (int[] arr : _2DArray) {
            if (num < arr[arr.length - 1]) {
                int gotNum = findNum(arr, num);
                if (gotNum != -1) {
                    return gotNum;
                }
            }
        }
        return -1;
    }

    private static int findNum(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return num;
            }
        }
        return -1;
    }

}
