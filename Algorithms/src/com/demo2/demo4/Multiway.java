package com.demo2.demo4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.stream.Stream;

/**
 * @author Cheung
 * @date 2021/4/15 10:24
 */
public class Multiway {
    public static void merge(In[] streams){
        int N= streams.length;
        IndexMinPQ<String> pq=new IndexMinPQ<String>(N);
        for (int i = 0; i < N; i++)
            if (!streams[i].isEmpty()) pq.insert(i,streams[i].readString());
        while (!pq.isEmpty()){
            System.out.println(pq.minKey());
            int i= pq.delMin();
            if (!streams[i].isEmpty()) pq.insert(i,streams[i].readString());
        }
    }

    public static void main(String[] args) {
        int N=args.length;
        In[] streams=new In[N];
        for (int i = 0; i < N; i++)
            streams[i]=new In(args[i]);
        merge(streams);
    }

}
