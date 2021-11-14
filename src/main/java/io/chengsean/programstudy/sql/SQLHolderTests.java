package io.chengsean.programstudy.sql;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author 程绍壮
 * @dateTime 2021-05-18 01:12
 */
public class SQLHolderTests {
    public static void main(String[] args) {
        String str = "[org.westos.dao.UserMapper.getUserById]-==>  Preparing: select * from user where id = ? and name = ? \n" +
                "[org.westos.dao.UserMapper.getUserById]-==> Parameters: 1(Integer), 张三(String)";
        SQLHolderTests tests = new SQLHolderTests();
        tests.setSQLParams(str);
    }

    private void setSQLParams(String sqlStr) {
        this.checkSQLStr(sqlStr);
        String sql = sqlStr.split("\n")[0].split("Preparing:")[1];
        String sqlParam = sqlStr.split("\n")[1].split("Parameters:")[1];
        // 参数占位符数量 等于 参数数量
        int paramHolderCount = countParamHolders(sql);
        // 参数数量 等于 参数占位符数量
        int paramsForHolders = countParamsForHolders(sqlParam);
        if (paramHolderCount != paramsForHolders) {
            throw new IllegalArgumentException(String.format("SQL参数占位符：%s, 参数: %s", paramHolderCount, paramsForHolders));
        }
        List<String> paramList = new ArrayList<>(Arrays.asList(sqlParam.split(",")));
        for (String param : paramList) {
            
        }
        System.out.println(sql);
        System.out.println(sqlParam);

    }

    private void checkSQLStr(String sqlStr) {
        if (StringUtils.isBlank(sqlStr)) {
            throw new NullPointerException();
        }
        if (!StringUtils.contains(sqlStr, "\n")) {
            throw new IllegalArgumentException("请将SQL和参数分成两行，否则无法进行拆分和设置参数");
        }
        if (!StringUtils.contains(sqlStr, "Preparing:")) {
            throw new IllegalArgumentException("无法解析SQL，因为没有找到对应的前缀: 'Preparing:'");
        }
        if (Objects.equals(sqlStr, "Preparing:")) {
            throw new IllegalArgumentException("无法解析SQL 'Preparing:'");
        }
        if (!StringUtils.contains(sqlStr, "Parameters:")) {
            throw new IllegalArgumentException("无法解析SQL参数值，因为没有找到对应的前缀: 'Parameters:'");
        }
        if (!StringUtils.contains(sqlStr, "?")) {
            throw new IllegalArgumentException("没有找到SQL参数占位符: '?'");
        }
    }

    private static int countParamsForHolders(String str) {
        return StringUtils.split(str, ",").length;
    }

    private static int countParamHolders(String str) {
        return RegExUtils.replaceAll(str, "[^?]", "").length();
    }
}
