package com.demo.demo3;

import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

import java.util.Iterator;

/**
 * @author Cheung
 * @date 2021/3/30 8:10
 */
public class LinkedListQueue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public class Node<Item>{
        Item item;
        Node<Item> next;
    }
    public LinkedListQueue(){
        first=null;
        last=null;
        N=0;
    }
    public boolean isEmpty(){ return N==0;}
    public int size(){return N;}

    public void enqueue(Item item){
        Node oldLast=last;
        last=new Node<Item>();
        last.item=item;
        last.next=null;
        if (isEmpty()) first.next=null;
        else oldLast.next=last;
        N++;
    }
    public Item dequeue(){
        Item item= first.item;;
        first.next=first;
        if (isEmpty()) last=null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    private class ReverseArrayIterator implements Iterator<Item>{

        private int i=0;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }


}
