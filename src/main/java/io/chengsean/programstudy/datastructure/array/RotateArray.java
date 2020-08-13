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

import org.springframework.util.CollectionUtils;

/**
 * 旋转数组
 *
 * @author 程绍壮
 * @datetime 2020-08-12 17:00
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("before："+ CollectionUtils.arrayToList(nums));
        rotate(nums, k);
        System.out.println("after："+ CollectionUtils.arrayToList(nums));
    }

    private static void rotate(int[] nums, int k) {
        if (k < 0) {
            throw new IllegalArgumentException(String.valueOf(k));
        }
        while (--k > 0) {
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if (n > 0) {
                    nums[i] = n;
                }
                int j = i + 1;
                if (j < nums.length) {
                    if (j == nums.length - 1) {
                        nums[0] = nums[j];
                    }
                    else {
                        n = n > 0 ? nums[j] : nums[i];
                        nums[j] = nums[i];
                    }
                }

            }
        }
    }
}
