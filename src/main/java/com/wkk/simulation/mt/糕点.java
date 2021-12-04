package com.wkk.simulation.mt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 糕点 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String line1 = input.nextLine();
            String line2 = input.nextLine();
            int n = Integer.parseInt(line1.trim().split(" ")[0]);
            int m = Integer.parseInt(line1.trim().split(" ")[1]);
            int c = Integer.parseInt(line1.trim().split(" ")[2]);
            int d = Integer.parseInt(line1.trim().split(" ")[3]);
            int a = Math.min(c, d);
            int b = Math.max(c, d);
            int already[] = new int[m];
            int need[] = new int[2];
            need[0] = a;
            need[1] = b;
            for (int i = 0; i < already.length; i++) {
                already[i] = Integer.parseInt(line2.trim().split(" ")[i]);
            }
            int can = n - m;//还能做几个蛋糕
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : already) {
                list.add(i);
            }
            //如果还能做两个以上
            if (can >= 2) {
                list.add(a);
                list.add(b);
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return (o1).compareTo(o2);
                    }
                });
                if (a == list.get(0) && b == list.get(list.size() - 1)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }
            //只能做一个
            else if (can == 1) {
                //先把最小的加进去(a)
                list.add(a);
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return (o1).compareTo(o2);
                    }
                });
                if (a == list.get(0) && b == list.get(list.size() - 1)) {
                    System.out.println("YES");
                    //如果加入最小的之后还不行
                } else {
                    //删除这一个（a）再加入b
                    list.remove(list.indexOf(a));
                    list.add(b);
                    Collections.sort(list, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return (o1).compareTo(o2);
                        }
                    });
                    if (a == list.get(0) && b == list.get(list.size() - 1)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
                // 不能做蛋糕了就只能从已经做的里面挑了。
            } else {
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return (o1).compareTo(o2);
                    }
                });
                if (a == list.get(0) && b == list.get(list.size() - 1)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
