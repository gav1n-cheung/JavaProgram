package com.demo.demo3;
import java.awt.event.ItemEvent;
import java.util.Iterator;
/**
 * @author Cheung
 * @date 2021/3/29 8:05
 */
public class LinkedList<Item> implements Iterable<Item>{

    Node first=new Node();
    Node second=new Node();
    Node last=new Node();

    Node oldfrist=first;

    Node oldlast=last;

    @Override
    public Iterator<Item> iterator() {
        first.item= (Item) "to";
        second.item= (Item) "be";
        last.item= (Item) "or";


        //在表头插入结点
        first=new Node();
        first.item=(Item)"not";
        first.next=oldfrist;

        //在表尾插入结点
        oldlast=new Node();
        last.item=(Item) "not";
        oldlast.next=last;

        first=first.next;//从表头删除结点，此时first和second相同，第一个结点被删除了，会被Java回收

        first.next=second;
        second.next=last;

        return null;
    }

    private class Node{
        Item item;
        Node next;
    }

    public static void main(String[] args) {

    }


}
