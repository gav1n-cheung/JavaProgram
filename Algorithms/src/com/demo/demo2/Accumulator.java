package com.demo.demo2;

/**
 * @author Cheung
 * @date 2021/3/11 11:00
 */
public class Accumulator {
    private  int sum;
    private  double avr;

    public void addDataValue(double val){
        sum++;
        avr+=val;
    }
    public double mean(){
        return avr/sum;
    }
    public String toString(){
        return "The num of data is "+sum+".The mean of the data is "+mean();
    }


}
