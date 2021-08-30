package com.atcafuc.exer;

import org.junit.Test;

/**
 * @author jh
 * @create 2021-08-13 22:41
 */
public class StringDemo2 {
    /*
    .获取两个字符串中最大相同子串。比如：
    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。

    前提： str1 和 str2 只有一个最大相同字符串
     */
    @Test
    public void test() {

//       String str1 = "abcwertahelloyuiodef";
//       String str2 = "cvahellobnm";
//        System.out.println(getMaxSameString(str1,str2));
//        String[] temp;
//        temp[0] = new String("12345");
//        temp[1] = "78fgfg";
//        System.out.println(temp);
//        int[]  i = new int[10];
//        i[0] = 10;
//        i[1] = 12;


    }

    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
//                        temp[loc++] = subStr;
                        return null;
                    }
                }
            }
//            } return temp.toString();
        } return null;
    }

}