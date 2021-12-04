package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class 消费券最大金额 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int value = 0, cost = 0;
        int x, y;
        for(int i = 0; i < n; i++){
            String[] pair = sc.nextLine().trim().split(" ");
            x = Integer.parseInt(pair[0]);
            y = Integer.parseInt(pair[1]);
            if(x >= y){
                value += x;
                cost += x - y;
            }else
                value += y;
        }
        System.out.println(String.format("%d %d", value, cost));
    }
}
