package io.chengsean.programstudy.basis.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * description
 *
 * @author 程绍壮
 * @dateTime 2021-10-18 16:23
 */
public class MaxAndMinNumberTest {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int maxCount = 10;
        System.out.printf("请输入int类型的整数，还需要%s个%n", maxCount);
        int temp, max = 0, min = 0;
        int[] arr = new int[maxCount];
        for (;;) {
            String str = getInputStr();
            if (isIntNumber(str)) {
                if (count < maxCount) {
                    temp = Integer.parseInt(str);
                    if (max < temp) {
                        max = temp;
                    }
                    if (min > temp) {
                        min = temp;
                    }
                    arr[count++] = temp;
                } else {
                    break;
                }
            }
            System.out.printf("请输入int类型的整数，还需要%s个%n", maxCount - count + 1);
        }
        System.out.printf("输入整数列表：%s%n", Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.printf("输入最小值：%s%n", min);
        System.out.printf("输入最大值：%s%n", max);
    }

    private static boolean isIntNumber(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        return Pattern.compile("-?\\d+").matcher(str).matches();
    }

    private static String getInputStr() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
