package com.demo.demo2;

/**
 * @author Cheung
 * @date 2021/3/24 8:54
 */
public class VectorTest {
    public static void main(String[] args) {
        int[] a={1,1,4,6};
        Vector testObject=new Vector(a);
        a[1]=5;//这里我们改变了数组a的元素值，但是由于Vector内final修饰的数组和a引用好的对象是相同的，因为我们绕过了API改变了不可变的数据类型，这是需要避免的
    }
}
