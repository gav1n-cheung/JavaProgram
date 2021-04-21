package com.demo.demo3;

import java.util.Iterator;

/**
 * @author Cheung
 * @date 2021/3/27 9:19
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap){
        a=(Item[]) new Object[cap];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        if (N==a.length) resize(a.length*2);//如果栈的容量N和数组长度相同（即数组被填满了），我们就无法再进行push操作了，因此我们将数组的长度翻倍，
        // 这样处理后栈只占了一般的数组长度，我们可以继续进行push操作了
        a[N++]=item;//先操作后自增
    }

    public Item pop(){
        Item item=a[--N];
        a[N]=null;
        if (N>0&&N==a.length/4) resize(a.length/2);
        return item;
    }
    ///将原来要处理的数组a放在一个新的长度为max的数组内
    public void resize(int max){
        Item[] temp=(Item[]) new Object[max];
        for (int i = 0; i < N; i++)
            temp[i]=a[i];
        a=temp;
    }
    //添加一个嵌套类，嵌套类可以访问它的类的实例变量，这里就是a[]和N（这也是使用嵌套类实现迭代器的主要原因），
    // 在这里，我们在类里添加一个方法iterator（）并且返回一个迭代器Iterator<Item>，迭代器都是泛型的，
    //我们需要逆序迭代整个数组，所谓迭代器就是实现了hasNext（）和next（）方法的类的对象，在本书中remove方法总为空，因为我们希望避免在迭代中穿插能够修改数据结构的操作
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        int i=0;

        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public Item next() {
            return a[i--];
        }
    }

}
