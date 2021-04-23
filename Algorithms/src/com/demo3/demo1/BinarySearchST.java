package com.demo3.demo1;

import com.sun.jdi.Value;
import edu.princeton.cs.algs4.Queue;

/**
 * @author Cheung
 * @date 2021/4/22 7:47
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity){
        keys=(Key[])new Comparable[capacity];
        vals=(Value[]) new Object[capacity];
    }
    public int size(){return N;}
    public boolean isEmpty(){return !(N>0);}
    public Value get(Key key){
        if (isEmpty()) return null;
        int i=rank(key);
        if (i<N&&keys[i].compareTo(key)==0) return vals[i];
        else return null;
    }
    public int rank(Key key){
        int lo=0,hi=N-1;
        while (lo<=hi){
            int mid=lo+ (hi-lo)/2;
            int cmp=key.compareTo(keys[mid]);
            if (cmp<0) hi=mid-1;
            if (cmp>0) lo=mid+1;
            else return mid;
        }
        return lo;
    }
    public void put(Key key, Value val){
        int i=rank(key);
        if (i<N&&keys[i].compareTo(key)==0) { vals[i]=val;return; }
        for (int j = N; j > i; j--) { keys[j]=keys[j-1];vals[j]=vals[j-1]; }
        keys[i]=key;vals[i]=val;
        N++;
    }
    public void delete(Key key){}
    public Key max(){ return keys[N-1];}
    public Key min(){return keys[0];}
    public Key select(int k){ return keys[k];}
    public Key ceiling(Key key){ int i=rank(key);return keys[i];}
    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> q=new edu.princeton.cs.algs4.Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        return q;
    }
    public Key floor(Key key){
        int i=rank(key);
        if (i<N&&key.compareTo(keys[i])==0) return keys[i];
        return keys[i-1];
    }


}
