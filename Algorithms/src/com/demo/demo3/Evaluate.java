package com.demo.demo3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author Cheung
 * @date 2021/3/26 10:04
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> calculation=new Stack<String>();
        Stack<Double> num=new Stack<Double>();

        while (!StdIn.isEmpty()){
            String s=StdIn.readString();
            if(s.equals("("));
            else if(s.equals("+")) calculation.push(s);
            else if(s.equals("-")) calculation.push(s);
            else if(s.equals("*")) calculation.push(s);
            else if(s.equals("/")) calculation.push(s);
            else if(s.equals("sqrt")) calculation.push(s);
            else if (s.equals(")")){
                String op=calculation.pop();
                double value=num.pop();
                if (op.equals("+")) value=num.pop()+value;
                else if (op.equals("-")) value=num.pop()-value;
                else if (op.equals("*")) value=num.pop()*value;
                else if (op.equals("/")) value=num.pop()/value;
                else if (op.equals("sqrt")) value=Math.sqrt(value);
                num.push(value);
            }
            else num.push(Double.parseDouble(s));
        }
        StdOut.println(num.pop());
    }
}
