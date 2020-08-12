package io.chengsean.programstudy.reference;
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

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 引用测试
 * @author 程绍壮
 * @datetime 2020-07-20 11:04
 */
public class ReferenceTests {

    public static void main(String[] args) throws Throwable {
        ReferenceTests referenceTests = new ReferenceTests();
        referenceTests.strongReferenceTest();
        referenceTests.softReferenceTest();
        referenceTests.weakReferenceTest();
        referenceTests.phantomReferenceTest();
    }

    private void phantomReferenceTest() throws Throwable {
        Object object = this.createObject();
        PhantomReference<Object> sr = new PhantomReference<>(object, null);
        object = null;
        this.doGCAndFinalize();
        System.out.println("PhantomReference: "+sr.get());
    }

    private void weakReferenceTest() throws Throwable {
        Object object = this.createObject();
        WeakReference<Object> reference = new WeakReference<>(object);
        object = null;
        this.doGCAndFinalize();
        System.out.println("WeakReference: "+reference.get());
    }

    private void softReferenceTest() throws Throwable {
        Object object = this.createObject();
        SoftReference<Object> reference = new SoftReference<>(object);
        object = null;
        this.doGCAndFinalize();
        System.out.println("SoftReference: "+reference.get());
    }

    private void strongReferenceTest() throws Throwable {
        Object object = this.createObject();
        StrongReference<Object> sr = new StrongReference<>(object);
        object = null;
        this.doGCAndFinalize();
        System.out.println("StrongReference: "+sr.get());
    }


    private void doGCAndFinalize() throws Throwable {
        System.gc();
        Thread.sleep(3000);
        this.finalize();
    }

    private Object createObject() {
        return new Object();
    }

    static class StrongReference<T> {
        T t;

        StrongReference(T t) {
            this.t = t;
        }

        T get() {
            return this.t;
        }
    }
}
