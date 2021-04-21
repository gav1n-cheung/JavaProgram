package com.demo2.demo4;

/**
 * @author Cheung
 * @date 2021/4/14 11:09
 */
public class MaxPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N=0;

    public MaxPQ(int maxN){ pq=(Key[]) new Comparable[maxN+1]; }
    public boolean isEmpty(){return N<=0;}
    public int size(){return N;}
    public void insert(Key v){pq[++N]=v;swim(N);}//不使用[0]
    public Key delMax(){
        Key max=pq[1];//最大的值就是根结点
        exch(1,N--);//将其和最后的结点交换
        pq[N+1]=null;//将最后的结点删除，防止对象游离
        sink(1);//由于堆为无序，进行下沉有序化
        return max;//返回最大值
    }
    private boolean less(int i,int j){ return pq[i].compareTo(pq[j])<0; }
    private void exch(int i,int j){Key t=pq[i]; pq[i]=pq[j]; pq[j]=t;}
    private void swim(int k){
        while (k>0&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=N){
            int j=2*k;
            if (j<N&&less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(j,k);
            k=j;
        }
    }


}
