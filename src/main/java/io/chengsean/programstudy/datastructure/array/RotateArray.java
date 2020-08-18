package io.chengsean.programstudy.datastructure.array;
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

/**
 * 旋转数组
 *
 * @author 程绍壮
 * @datetime 2020-08-12 17:00
 */
public class RotateArray {


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
        int k = 2;
        System.out.println("1：Before array rotation："+ CollectionUtils.arrayToList(nums));
        rotate(nums, k);
        System.out.println("1: After array rotation："+ CollectionUtils.arrayToList(nums));
//        nums = new int[]{0,1,2,3,4,5,6,7,8,9};
////        System.out.println("2：Before array rotation："+ CollectionUtils.arrayToList(nums));
////        rotateTwo(nums, k);
////        System.out.println("2: After array rotation："+ CollectionUtils.arrayToList(nums));
    }

/*    private static void rotateTwo(int[] nums, int k) {
        if (k < 0 || nums == null) {
            return;
        }
        while (--k >= 0) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    j = nums[i + 1];
                    nums[i + 1] = nums[i];
                }
                if (i == nums.length - 1) {
                    nums[0] = nums[nums.length - 1];
                }
                if (i > 0 && nums[i] != nums[i - 1] ) {
                    nums[i] = nums[i] ^ j;
                    j = nums[i] ^ j;
                    nums[i] = nums[i] ^ j;
                }
            }
        }
    }*/

   /* private static void rotate(int[] nums, int k) {
        if (k < 0 || nums == null) {
            return;
        }
        int j;
        while (--k >= 0) {
            j = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] ^ j;
                j = nums[i] ^ j;
                nums[i] = nums[i] ^ j;
            }
        }
    }*/

    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count ++;
            } while (start != current);
        }
    }
}
