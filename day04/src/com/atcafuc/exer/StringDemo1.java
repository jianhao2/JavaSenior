package com.atcafuc.exer;

import org.junit.Test;

/**
 * @author jh
 * @create 2021-08-13 16:45
 */
public class StringDemo1 {
/*
获取一个字符串在另一个字符串中出现的次数。
比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */

    @Test
    public void test(){
        String s1 = "abkkcadkabkebfkabkskabab";
        String s2 = "ab";
//        int count = 0;
//        try {
//            int count = finder(s1,s2);
//            System.out.println(count);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());;
//        }
//        System.out.println(count);
        System.out.println(finder1(s1, s2));

//        System.out.println(s1.indexOf("cd"));
//        System.out.println(s1.lastIndexOf("ab"));
    }

    public int finder(String str,String str1) throws Exception {
        if(str1.length() <= str.length()){
            int start  = str.indexOf(str1);
            int end   = str.lastIndexOf(str1);
            if( start == -1){
                return 0;
            }
            else if(start == end){
                return 1;
            }
            return 2  +  finder(str.substring(start+1,end),str1);
        }else{
           throw new Exception("匹配字符串长于主字符串");
        }
    }

    public int finder1(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >=subLength){
            //方式一：
//            while((index = mainStr.indexOf(subStr)) != -1){
//                count ++;
//                mainStr = mainStr.substring(index+subStr.length());
//            }

            //方式二：
            while((index = mainStr.indexOf(subStr,index)) != -1){
                index += subLength;
                count++;
            }

            }
        return count;
        }


}
