package com.eva.base.util;

/**
 * Created by Jamin on 2017/5/25.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    /**
     * 字符串中存在星号（表示多个字符）匹配
     * @param pattern  包含星号的字符串
     * @param str  要匹配的字符串
     * @return
     */
    public static boolean wildcardStarMatch(String pattern, String str) {
        int strLength = str.length();
        int strIndex = 0;
        char ch;
        for (int patternIndex = 0,patternLength = pattern.length(); patternIndex < patternLength; patternIndex++) {
            ch = pattern.charAt(patternIndex);
            if (ch == '*') {
                // 通配符星号*表示可以匹配任意多个字符
                while (strIndex < strLength) {
                    if (wildcardStarMatch(pattern.substring(patternIndex + 1), str.substring(strIndex))) {
                        return true;
                    }
                    strIndex++;
                }
            } else {
                if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
                    return false;
                }
                strIndex++;
            }
        }
        return (strIndex == strLength);
    }

    /**
     * 首字母转小写
     *
     * @param str
     * @return
     */
    public static String lowercaseFirstLetter(String str) {
        char c = str.charAt(0);
        String temp = new String(c + "");
        return str.replaceFirst(temp, org.apache.commons.lang.StringUtils.lowerCase(temp));
    }
}
