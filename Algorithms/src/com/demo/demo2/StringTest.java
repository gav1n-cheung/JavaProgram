package com.demo.demo2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Cheung
 * @date 2021/3/5 10:52
 */
public class StringTest {

    public static void main(String[] args) {
//        String a="now is ";
//        String b="the time";
//        String c="to";
//        StdOut.println(a.length());
//        StdOut.println(a.charAt(4));
//        StdOut.println(a.concat(c));
//        StdOut.println(a.indexOf("is"));
//        StdOut.println(a.substring(2,5));
//        StdOut.println(a.split(" ")[0]);
//        StdOut.println(a.split(" ")[1]);
//        StdOut.println(b.equals(a));
       StdOut.println(isPalindrome("121"));
       StdOut.println(getName("test.txt")[0]);
       StdOut.println(getName("test.txt")[1]);
       printClone("a");

    }
    //判断是否为回文（正序倒序内容一致）
    private static boolean isPalindrome(String s){
        int N=s.length();
        for (int i = 0; i < N; i++) {
            if(s.charAt(i)==s.charAt(N-i-1)) continue;
            else return false;
        }
        return true;
    }
    //从一个命令行参数中提取文件名和拓展名
    private static String[] getName(String s){
        int dot=s.indexOf(".");
        String fristName=s.substring(0,dot);
        String lastName=s.substring(dot+1,s.length());
        String[] nameAarry={fristName,lastName};
        return nameAarry;
    }
    //打印标准输入中所有含有通过命令行指定的字符串的行
    private static void printClone(String s){
        while (!StdIn.isEmpty()){
            String s1=StdIn.readLine();
            if(s1.contains(s)) StdOut.println(s1);
            else StdOut.println("NO target");
        }
    }
    //由空白字符为分隔符从StdIn中创建一个字符串数组
    private static String[] getArrayFromString(String s){
        String[] words=s.split(" ");
        return words;
    }
    //检查一个字符串数组中的元素是否已按照字母表的顺序排列
    private static boolean checkWordsAsLetter(String[] s){
        for (int i = 1; i < s.length; i++) {
             if (s[i-1].compareTo(s[i])>0)
                 return false;
        }
        return true;
    }
}
