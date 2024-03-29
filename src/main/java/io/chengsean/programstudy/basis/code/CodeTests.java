package io.chengsean.programstudy.basis.code;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * code tests
 *
 * @author 程绍壮
 * @dateTime 2020-08-26 01:32
 */
public class CodeTests {

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
