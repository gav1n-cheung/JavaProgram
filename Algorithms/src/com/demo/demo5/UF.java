package com.demo.demo5;

import com.demo.demo4.StopWatch;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author Cheung
 * @date 2021/4/1 10:32
 */
public class UF {
    private int[] id;
    private int count;
    public UF(int N){
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++)
            id[i]=i;
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
//    public int find(int p){
//        return id[p];
//    }
//    public void union(int p,int q){
//        int pID=find(p);
//        int qID=find(q);
//        if (pID==qID) return;
//            for (int i = 0; i < id.length; i++)
//                if (id[i]==qID) id[i]=pID;
//        count--;
//    }
    ///quick-union
    public int find(int p){
        while (p!=id[p]) p=id[p];//这样就可以找到输入触点的根节点（即索引值和元素值相同的触点）
        return p;
    }
    public void union(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if (pRoot==qRoot) return;
        id[pRoot]=qRoot;
        count--;
    }


    public static void main(String[] args) {
        int N= StdIn.readInt();
        UF uf=new UF(N);
        int i=0;
        Point2D[] points=new Point2D[625];
        StopWatch test=new StopWatch();
        while (!StdIn.isEmpty()){
            int p=StdIn.readInt();
            int q=StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p+" "+q);
        }
        double time= test.elapsestart();
        System.out.println(uf.count()+"components");
        System.out.println(time+"seconds");
    }

}
