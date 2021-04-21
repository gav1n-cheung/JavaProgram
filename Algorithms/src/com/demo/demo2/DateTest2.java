package com.demo.demo2;

/**
 * @author Cheung
 * @date 2021/3/11 10:03
 */
public class DateTest2 {
    //这个value就是输入日期的总天数
    private final int value;


    public  DateTest2(int d,int m,int y){
        value=512*y+32*m+d;//假设一年为512天，一个月为0-31天，共0-15个月
    }

    //先/32得到一共多少个月，再%15取余得到月份
    private int mouth(){
        return (value/32)%16;
    }
    //%32取余得到天数
    private int day(){
        return value%32;
    }
    // /512得到年数
    private int year(){
        return value/512;
    }

    public String toString(){
        return mouth()+"/"+day()+"/"+year();
    }

    public boolean equals(Object x){
        if (this==x) return true;//如果该对象和参数对象引用相同，返回true。这项工作可以免去其他所有测试工作
        if (x==null) return false;//如果参数对象为null，则必然返回false
        if (this.getClass()!=x.getClass()) return false;//如果两者的类型不同，则返回false，我们利用getClass()来得到对象的值
        DateTest2 that=(DateTest2) x;//将参数对象转换为DataTest类型，因为前面的自反性测试通过，则这种转换必然成功
        if (this.day()!=that.day()) return false;//比较对象的相应参数
        if (this.mouth()!=that.mouth()) return false;
        if (this.year()!=that.year()) return false;

        return true;
    }


}
