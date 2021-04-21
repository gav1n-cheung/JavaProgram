package com.demo.demo3;

/**
 * @author Cheung
 * @date 2021/3/27 8:15
 */
public class FixedCapacityStackString {
    String[] array;
    int arrayIndex=0;
    public FixedCapacityStackString(int cap){
        array=new String[cap];
    }
    public void push(String item){
        array[arrayIndex++]=item;//可以将arrayIndex写在[]内，效果相当于在该语句后写索引自增。
        // 举一个例子：我们在第一次push元素时，则arrayIndex变为了1，用于第二次push元素，此时输出的数组长度为1，这是没有问题的--
        //虽然有元素的是索引0，但长度为1，这是合理的。
        //然后我们push第2个元素，这是有元素的索引分别为0\1，但此时的arrayIndex的值为2，数组元素恰好为2.
        //但如果我们根据arrayIndex来pop出最新的元素，则会报错，因为此时数组内并没有索引2，超出了数组的长度
        //而我们希望pop出的元素索引实际为1，则将arrayIndex--,弹出这个索引的元素。此时arrayIndex为1，恰好是数组的长度，整个逻辑是没有问题的。
    }
    public boolean isEmpty(){
        return arrayIndex==0;//在判断语句成立时，返回true，否则返回falsepu
    }
    public int size(){
        return arrayIndex;//返回的数组长度应该是包括字符串在内的元素和
    }
    public String pop(){
        return array[--arrayIndex];//因为
    }
    public boolean isFull(){ return arrayIndex==array.length-1;}//如果数组长度Index=数组的实际长度，则返回true
}
