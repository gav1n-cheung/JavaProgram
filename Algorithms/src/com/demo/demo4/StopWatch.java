package com.demo.demo4;

/**
 * @author Cheung
 * @date 2021/4/1 8:04
 */
public class StopWatch {
    private final long start;
    public StopWatch(){
        start=System.currentTimeMillis();
    }
    public double elapsestart(){
        long now=System.currentTimeMillis();
        return (now-start)/1000.0;
    }


}
