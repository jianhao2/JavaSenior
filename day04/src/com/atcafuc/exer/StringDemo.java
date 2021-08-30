package com.atcafuc.exer;

import org.junit.Test;



/**
 * @author jh
 * @create 2021-08-13 15:45
 */
public class StringDemo {

    /*
     将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
     转为”abfedcg”
     */




    @Test
     public void test1(){

//        reverse1();
        String s2 = reverse2("abcdefg",2,5);
        System.out.println(s2);
//        String s3 = reverse3("abcdefg",2,5);
//        System.out.println(s3);
    }

//方法一：转换为char[]
    public void reverse1(){
        String s1 = "abcdefg";
        char[] ch = s1.toCharArray();
        System.out.println(ch[0]);
        int indexc = s1.indexOf('c');
        int indexf = s1.indexOf('f');
        System.out.println(indexc+"  "+indexf);
//    int len = indexf+indexc;
        char c =' ';
        while(true){
            if(indexc < indexf){
                c = ch[indexc];
                ch[indexc++] = ch[indexf];
                ch[indexf--] =c;
            }else{
                break;
            }
        }
        String s2 = String.valueOf(ch);
        System.out.println(s2);
    }

//方式二 使用StringBuilder.reverse()
    public String reverse2(String str,int startIndex, int endIndex){
//        String s1 = str.substring(0,startIndex);
//        String s2 = str.substring(endIndex+1,str.length());
//        StringBuilder sb1 = new StringBuilder(str.substring(startIndex,endIndex+1));
//        System.out.println(s1 + ' '+s2+' '+sb1);
//        sb1.reverse();
//        System.out.println(sb1);
//        String s3 = s1 + sb1 + s2;

        StringBuilder  sb1= new StringBuilder(str.length());
        //第一部分
        sb1.append(str.substring(0,startIndex));
        for(int i = endIndex; i>=startIndex; i--){

            sb1.append(str.charAt(i));
        }
        sb1.append(str.substring(endIndex+1,str.length()));

        return sb1.toString();
    }
//方式三 使用String拼接
    public String reverse3(String str,int startIndex,int endIndex){
        String s1 = str.substring(0,startIndex);
        for(int i = endIndex; i>=startIndex; i--){
            s1 += str.charAt(i);
//            System.out.println(str.charAt(i));
        }
        System.out.println(s1);
        String s3 = str.substring(endIndex+1);
        s1 +=s3;
        return s1;
    }

}


