package com.demo.demo3;

import java.util.Iterator;

/**
 * @author Cheung
 * @date 2021/3/30 8:44
 */
public class LinkedListBag<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int N;


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    public class ReverseArrayIterator implements Iterator<Item>{
        private Node currnt=first;
        @Override
        public boolean hasNext() {
            return currnt==null;
        }

        @Override
        public Item next() {
            Item item =(Item) currnt.item;
            currnt=currnt.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
    //上面的代码实现了迭代操作


    public class Node<Item>{
        Item item;
        Node<Item> next;
    }

    public boolean isEmpty(){ return N==0;}
    public int size(){ return N;}

    public void add(Item item){
        Node<Item> oldfirst=first;
        first=new Node<Item>();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
}
