package com.demo.demo3;

import org.w3c.dom.Node;

import java.util.Iterator;

/**
 * @author Cheung
 * @date 2021/3/30 7:39
 */
public class LinkedListStack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int N;

    public LinkedListStack(){
        first=null;
        N=0;
    }

    public boolean isEmpty(){ return N==0;}
    public int size(){ return N;}

    public void push(Item item){
        Node<Item> oldfirst =first;
        first=new Node<Item>();
        first.item=item;
        first.next=oldfirst;
        N++;
    }
    public Item pop(){
        Item item= first.item;
        first=first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private static class Node<Item> {
        private Item item;
        private LinkedListStack.Node<Item> next;
    }
}
