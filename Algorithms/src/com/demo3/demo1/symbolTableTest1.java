package com.demo3.demo1;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author Cheung
 * @date 2021/4/18 9:02
 */
public class symbolTableTest1 {
    public static void main(String[] args) {
        ST<String,Integer>st;
        st=new ST<String,Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key=StdIn.readString();
            st.put(key,i);
        }
        for (String s:st.keys())
            System.out.println(s+" "+st.get(s));

    }
}
