package com.demo.demo3;

import java.util.Iterator;

/**
 * @author Cheung
 * @date 2021/3/30 10:10
 * 验证通过
 */
public class ex1319<Item> implements Iterable<Item> {

    Node<Item> first;
    Node<Item> last;
    int N;

    public ex1319(){
        first=null;
        last=null;
        N=0;
    }
    public boolean isEmpty(){ return N==0;}

    public int size(){ return N;}

    public void push(Item item){
        Node<Item> oldFrist=first;
        first=new Node<Item>();
        first.item=item;
        first.next=oldFrist;
        N++;
    }


    public void deleteLast(){
        Node x;
        for ( x=first;x.next.next!=null;x=x.next);
        x.next=null;
    }
    public void delete(int k){
        Node x;
        int n=0;
        outer:
        for (x=first;x!=null;x=x.next){
            if (n==k-1) break outer;
            n++;
        }
        if (x.next.next!=null)
        x.next=x.next.next;
        else x.next=null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public class Node<Item>{
        Item item;
        Node<Item> next;
    }

    public static void main(String[] args) {
        ex1319 test=new ex1319();
        test.push(12);
        test.push(13);
        test.push(11);
        test.delete(1);

//        test.deleteLast();
    }

}
