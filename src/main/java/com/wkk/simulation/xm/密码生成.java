package com.wkk.simulation.xm;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author weikunkun
 * @since 2021/7/1
 */
public class 密码生成 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int mod =100000009;

        int N = scanner.nextInt();//槽位个数
        int M = scanner.nextInt();

        int[][] A = new int[M][2];

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<M;i++){
            A[i][0] = scanner.nextInt();
            A[i][1] = scanner.nextInt();
        }

        long a = 0;

        int index1 = -1;
        int index2 = -1;

        for(int i=M-1;i>=0;i--){
            index1 = A[i][0];
            index2 = A[i][1];
            if(map.lowerKey(index1+1)!=null&&map.get(map.lowerKey(index1+1))>=index1){
                index1 = map.lowerKey(index1+1);
            }
            if(map.lowerKey(index2+1)!=null&&map.get(map.lowerKey(index2+1))>index2){
                index2 = map.get(map.lowerKey(index2+1));
            }

            int temp1 = index1;
            int temp2 = index2;

            if(map.containsKey(temp1)){
                temp1 = map.remove(temp1)+1;
            }

            while(map.higherKey(temp1)!=null&&map.get(map.higherKey(temp1))<=temp2){
                int now = map.higherKey(temp1);
                for(int j=temp1;j<now;j++){
                    a = (a + ((i+1)*(long)j)%mod)%mod;
                }
                temp1 =map.remove(now)+1;
            }

            for(int j=temp1;j<=temp2;j++){
                a = (a + ((i+1)*(long)j)%mod)%mod;
            }

            map.put(index1,index2);
        }
        System.out.println(Integer.valueOf(String.valueOf(a)));
    }
}
