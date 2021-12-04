package com.wkk.interview.bytedance2021.simulation;

/**
 * @author weikunkun
 * @since 2021/4/14
 */
public class Test {
    public static Test t1=new Test();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args){
        Test t2=new Test();
    }
}