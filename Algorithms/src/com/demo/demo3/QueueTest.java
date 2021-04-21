package com.demo.demo3;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Transaction;

/**
 * @author Cheung
 * @date 2021/3/25 10:28
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Date> queue=new Queue<Date>();
        queue.enqueue(new Date(12,21,100));
        Date next=queue.dequeue();
        System.out.println(next);
    }
    private void transactionCollection(){
        Queue<Transaction> collection=new Queue<Transaction>();
        //我们使用迭代的方法历数collection，这种方法使得我们不需要关注变量的实际类型，不需要知道集合的表示和具体的细节
        //他只想逐个的处理集合中的元素。相同的bag对象也可以使用这种方法来处理
        for (Transaction t:collection)
            System.out.println(t);
    }
}
