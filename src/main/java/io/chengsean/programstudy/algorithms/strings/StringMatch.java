package io.chengsean.programstudy.algorithms.strings;

import java.util.Scanner;

/**
 * Two pointer string match
 * abababcbababcabcabababcbababcabc
 * bcabcabab
 * @author 程绍壮
 * @dateTime 2020-08-29 15:07
 */
public class StringMatch {

    public static void main(String[] args) {
        String string = getInputString("请输入需要匹配的主字符串");
        if (string == null || string.length() == 0) {
            System.out.println("输入的字符串为null或长度为0，程序结束");
            System.exit(-1);
        }
        String subString = getInputString("请输入需要匹配的子字符串");
        if (subString == null || subString.length() == 0) {
            System.out.println("输入的子字符串为null或长度为0，程序结束");
            System.exit(-1);
        }
        String msg = "'"+string+"' contains '"+subString+"'";
        System.out.println(msg+" is "+matches(string, subString.toCharArray()));
    }

    static boolean matches(String string, char[] subChars) {
        if (string == null || subChars == null) {
            throw new NullPointerException();
        }
        if (string.isEmpty() || subChars.length == 0) {
            return false;
        }
        char[] chars = string.toCharArray();
        int subCharNext = 0;
        for (int charNext = 0; charNext < chars.length; charNext++) {
            if (subCharNext == subChars.length) {
                return true;
            }
            if (chars[charNext] == subChars[subCharNext]) {
                subCharNext ++;
            }
            else {
                charNext = subCharNext > 0 ? charNext - 1 : charNext;
                subCharNext = 0;
            }
        }
        return false;
    }

    static String getInputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.nextLine();
    }
}
