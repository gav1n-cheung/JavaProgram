package com.demo2.demo1;

import com.demo.demo4.StopWatch;
import edu.princeton.cs.algs4.*;

/**
 * @author Cheung
 * @date 2021/4/6 9:41
 */
public class SortCompare {
    public static double time(String alg,Double[]a){
        StopWatch timer=new StopWatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsestart();
    }

    public static double timeRandomInput(String alg,int N,int T) {
        double total=0.0;
        Double[] a=new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++)
                a[j]= StdRandom.uniform();
            total+=time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1=args[0];
        String alg2=args[1];
        int N=Integer.parseInt(args[2]);
        int T=Integer.parseInt(args[3]);
        double t1=timeRandomInput(alg1,N,T);
        double t2=timeRandomInput(alg2,N,T);
        System.out.printf("For %d random Doubles\n %s is ",N,alg1);
        System.out.printf("%.1f times faster than %s\n",t2/t1,alg2);
    }






}
