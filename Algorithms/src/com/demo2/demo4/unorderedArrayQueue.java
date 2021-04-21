package com.demo2.demo4;

import java.security.Key;

/**
 * @author Cheung
 * @date 2021/4/13 11:04
 */
public class unorderedArrayQueue {
    Key[] array;
    int arrayIndex=0;
    public unorderedArrayQueue(){
        array=new Key[0];
    }
    public unorderedArrayQueue(int max){
        array=new Key[max];
    }
    public unorderedArrayQueue(Key[] a){
        array=new Key[a.length];
        for (int i = 0; i < a.length; i++)
            array[i]=a[i];
    }
    public void Insert(Key v){
        array[arrayIndex++]=v;
        if (arrayIndex>=array.length) array[getTheMaximumElementIndex(array)]=v;
    }
    public Key max(){ return array[getTheMaximumElementIndex(array)]; }
    public Key delMax(){
        Key max=array[getTheMaximumElementIndex(array)];
        array[getTheMaximumElementIndex(array)]=array[arrayIndex--];
        return max;
    }
    public boolean isEmpty(){
        return !(arrayIndex>0);
    }
    public int size(){
        return arrayIndex;
    }
    private int getTheMaximumElementIndex(Key[] a){
        int index=-1;
        for (int i=0;i<array.length-1;i++){
            if (Integer.parseInt(array[i].toString())>Integer.parseInt(array[i+1].toString())) index=i;
            else index=i+1;
        }
        return index;
    }
}
