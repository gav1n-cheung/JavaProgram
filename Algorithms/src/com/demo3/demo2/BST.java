package com.demo3.demo2;

import com.demo.demo3.ex1319;
import org.w3c.dom.Node;

/**
 * @author Cheung
 * @date 2021/4/23 9:27
 */
public class BST<Key extends Comparable<Key>,Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int N;
        public Node(Key key,Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }
    private int size(){
        return size(root);
    }
    private int size(Node root){
        if (root==null) return 0;
        else return root.N;
    }
    public Value get(Key key){ return get(key,root);}
    private Value get(Key key,Node x){
        if (x==null) return null;
        int cmp=key.compareTo(x.key);
        if (cmp<0) get(key,x.left);
        else if (cmp>0) get(key,x.right);
        return x.val;
    }
    public void put(Key key,Value val){root=put(root,key,val);}
    private Node put(Node x,Key key,Value val){
        if (x==null) return new Node(key,val, 1);
        int cmp=key.compareTo(x.key);
        if (cmp<0) x.left=put(x.left,key,val);
        if (cmp>0) x.right=put(x.right, key, val);
        else x.val=val;
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }


}
