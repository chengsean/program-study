package io.chengsean.programstudy.algorithms.strings;

/**
 * String match interview questions
 * For string matching, a string with a length of 11 is required, and 888 is required at the beginning and the end, and any non-888 string in the middle
 * Positive example: 888,1.2.3.4.5.888
 * negative example:
 * 888888
 * 88855888
 * 888,34888,17,888
 *
 * add String match and it interview questions
 * @author 程绍壮
 * @dateTime 2020-08-27 20:31
 */
public class StringMatchingInterviewQuestions {


    public static void main(String[] args) {
        String string = StringMatch.getInputString("请输入需要匹配的主字符串");
        if (string == null || string.isEmpty()) {
            System.out.println("字符串不能为空或null，程序结束");
            System.exit(-1);
        }
        string = string.replaceAll("\\D", "");
        if (string.length() != 11) {
            System.out.println("字符串长度不等于11，程序结束");
            System.exit(-1);
        }
        String MatchStringPattern = "888xxx(!888)888";
        String msg = "'"+string+"' 匹配字符串头尾部为888，而中间为任意非888字符串即（字符串模式 '"+MatchStringPattern+"'）";
        System.out.println(msg+" "+matches(string));
    }

    private static boolean matches(String string) {
        String subString = "888";
        if (!string.startsWith(subString) || !string.endsWith(subString)) {
            return false;
        }
        return !StringMatch.matches(string.substring(1, string.length() - 1), subString.toCharArray());
    }

}
