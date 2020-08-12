package io.chengsean.programstudy.basis;
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

/**
 * 接口测试
 *
 * @author 程绍壮
 * @datetime 2020-08-07 14:22
 */
public class InterFaceTest {

    interface Person {
        default void eat() {
            System.out.println(this.name() + " eat");
        }

        default void sleep() {
            System.out.println(this.name() + " sleep");
        }

        void work();
        String name();
    }

    static class Jim implements  Person {
        private final String name;

        Jim(String name) {
            this.name = name;
        }

        @Override
        public void work() {
            System.out.println(this.name + " work");
        }

        @Override
        public String name() {
            return this.name;
        }
    }

    static class Lucy implements Person {

        private final String name;

        Lucy(String name) {
            this.name = name;
        }

        @Override
        public void work() {
            System.out.println(this.name + " work");
        }

        @Override
        public String name() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Person jim = new Jim("Jim Peter");
        jim.eat();
        jim.sleep();
        jim.work();
        Person lucy = new Lucy("Lucy Harry");
        lucy.eat();
        lucy.sleep();
        lucy.work();
    }
}
