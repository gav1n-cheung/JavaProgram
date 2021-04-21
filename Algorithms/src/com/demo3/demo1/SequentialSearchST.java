package com.demo3.demo1;

import com.sun.jdi.Value;
import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

/**
 * @author Cheung
 * @date 2021/4/20 8:27
 */
public class SequentialSearchST<Key,Node> {
        private int n;
        private SequentialSearchST.Node first;
        private class Node{
            Key key;
            Value val;
            Node next;
            public Node(Key key,Value val,Node next){
                this.key=key;
                this.val=val;
                this.next=next;
            }
        }
        public Value get(Key key){
            for (SequentialSearchST.Node x = first; x!=null; x=x.next)
                if (key.equals(x.key)) return x.val;
            return null;
        }
        public void put(Key key,Value val){
            for (SequentialSearchST.Node x=first;x!=null;x=x.next)
                if (key.equals(x.val)) {x.val=val;return;}
            first=new SequentialSearchST.Node(key,val,first);
            n++;
        }
        public int size(){return n;}
    public SequentialSearchST.Node delete(SequentialSearchST.Node x, Key key){
            if (x==null) return null;
            if (key.equals(x.key)) {n--;return x.next;}
            x.next=delete(x.next,key);
            n--;
            return x;
    }
    public Iterable<Key> keys(){
        Queue<Key> queue=new edu.princeton.cs.algs4.Queue<Key>();
        for (SequentialSearchST.Node x=first;x!=null;x=x.next)
            queue.enqueue((Key) x.key);
        return queue;
    }



}
