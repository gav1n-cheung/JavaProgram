package com.demo.demo5;

import com.demo.demo4.StopWatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author Cheung
 * @date 2021/4/4 8:39
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQuickUnionUF(int N){
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++)             id[i]=i;
        sz=new int[N];
        for (int i = 0; i < N; i++)             sz[i]=i;
    }
    public int count(){return count;}
    public boolean connected(int p,int q){return find(p)==find(q);}
    public int find(int q){
        while (q!=id[q]) q=id[q];
        return q;
    }
    public void union(int p,int q){
        int i=find(q);
        int j=find(p);
        if(i==j) return;
        if (sz[i]>sz[j]) {id[j]=i;sz[i]+=sz[j];}
        else {id[i]=j;sz[j]+=sz[i];}
        count--;
    }
    public static void main(String[] args) {
        int N= StdIn.readInt();
        UF uf=new UF(N);
        StopWatch test=new StopWatch();
        while (!StdIn.isEmpty()){
            int p=StdIn.readInt();
            int q=StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p+" "+q);
        }
        double time=test.elapsestart();
        System.out.println(uf.count()+"components");
        System.out.println(time+"seconds");
    }





}
