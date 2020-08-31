package io.chengsean.programstudy.basis.code;

import org.springframework.util.NumberUtils;

/**
 * code tests
 *
 * @author 程绍壮
 * @dateTime 2020-08-26 01:32
 */
public class CodeTests {
    public static void main(String[] args) {
        CodeTests ct = new CodeTests();
        int num = 10;
        for (int n = 1; n <= num; n++) {
            System.out.println(n+(ct.isOdd(n) ? " is" : " is not")+" odd ");
        }
    }

    private boolean isOdd(int n) {
        return  (n & 1) != 0;
    }

}
