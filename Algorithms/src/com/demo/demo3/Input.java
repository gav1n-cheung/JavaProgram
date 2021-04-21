package com.demo.demo3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * @author Cheung
 * @date 2021/3/26 8:46
 */
public class Input {

    public static int[] readInts(String s){
        In in=new In(s);

        Queue<Integer> test=new Queue<Integer>();
        while (!in.isEmpty())
            test.enqueue(in.readInt());

        int[] queue=new int[test.size()];
        for (int i=0;i<queue.length;i++)
            queue[i]=test.dequeue();
        return queue;
    }

    public static void main(String[] args) {
        readInts(args[0]);
    }


}
