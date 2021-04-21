package com.demo2.demo4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

/**
 * @author Cheung
 * @date 2021/4/13 10:34
 */
public class TopM {
    public static void main(String[] args) {
        int M=Integer.parseInt(args[0]);
        MinPQ<Transaction> pq=new MinPQ<Transaction>(M+1);
        while (StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size()>M) pq.delMin();
        }
        Stack<Transaction> stack=new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t:stack) System.out.println(t);
    }

}
