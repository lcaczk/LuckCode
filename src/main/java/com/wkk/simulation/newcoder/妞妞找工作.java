package com.wkk.simulation.newcoder;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 妞妞找工作 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //D为工作难度，P为报酬，A为小伙伴的能力值
        int[] D = new int[N], P = new int[N], A = new int[M];
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++){
            D[i] = sc.nextInt();
            P[i] = sc.nextInt();
            if(!map.containsKey(D[i])){
                map.put(D[i], P[i]);
            }else{
                if(P[i] > map.get(D[i])){
                    map.put(D[i], P[i]);//工作难度相同
                }
            }
        }
        //小伙伴的能力,并且插入到map中
        for(int i = 0; i < M; i++){
            A[i] = sc.nextInt();
            if(!map.containsKey(A[i])){
                map.put(A[i], 0);
            }
        }
        //更新map的value值
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
            map.put(entry.getKey(), max);
        }
        for(int i = 0; i < A.length; i++){
            System.out.println(map.get(A[i]));
        }
    }
}
