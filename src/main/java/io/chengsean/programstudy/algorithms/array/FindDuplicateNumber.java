package io.chengsean.programstudy.algorithms.array;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * @author 程绍壮
 * @dateTime 2021-10-21 18:08
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int [] nums = new int[]{5,1,3,2,4,1,0};
        System.out.printf("数组重复数字：%s%n", findDuplicateNum(nums));
    }

    private static int findDuplicateNum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
