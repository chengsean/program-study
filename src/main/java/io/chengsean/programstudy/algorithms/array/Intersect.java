package io.chengsean.programstudy.algorithms.array;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼           BUG辟易
//
//                             佛曰:
//
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

//
//                       .::::.
//                     .::::::::.
//                    :::::::::::  howdy!
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ```` ':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//

import io.chengsean.programstudy.util.CollectionUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集
 *
 * @author 程绍壮
 * @datetime 2020-08-20 11:34
 */
public class Intersect {
    public static void main(String[] args) {
        Intersect intersect = new Intersect();
//        int[] nums1 = new int[]{1,2,2};
//        int[] nums2 = new int[]{1,1,2,3,3};
//        int[] nums1 = new int[]{1,2};
//        int[] nums2 = new int[]{1,1};
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        System.out.println("In the arrays "+ CollectionUtils.arrayToList(nums1)
                +", "+ CollectionUtils.arrayToList(nums2)+ " intersectByMap elements is "+
                CollectionUtils.arrayToList(intersect.intersectBySort(nums1, nums2)));
    }

    private int[] intersectByMap(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return this.intersectByMap(nums2, nums1);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums1) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int n : nums2) {
            Integer count = countMap.getOrDefault(n, 0);
            if (count > 0) {
                countMap.put(n, count - 1);
                intersection[index ++] = n;
            }
            else {
                countMap.remove(n);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    private int[] intersectBySort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            }
            else if (nums1[index1] > nums2[index2]) {
                index2++;
            }
            else if (nums1[index1] == nums2[index2]) {
                intersection[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
