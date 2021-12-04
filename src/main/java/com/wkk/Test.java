package com.wkk;

import com.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/4/19
 */
public class Test {
    public static String countAndSay(int n) {
        if (n <= 2) {
            if (n == 2) {
                return "11";
            }
            return "1";
        }
        String pre = countAndSay(n - 1);
        char[] chars = pre.toCharArray();
        int i = 1;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        int len = chars.length;
        int num = 0;
        while (i < len) {
            if (chars[i] == chars[j]) {
                i++;
            } else {
                num = i - j;
                sb.append(num);
                sb.append(chars[j]);
                j = i;
                i++;
            }
        }
        num = i - j;
        sb.append(num);
        sb.append(chars[i - 1]);
        return sb.toString();
    }

    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        // 思路
        // 使用map存储pieces key : first value, value : list
        // 遍历整个arr做匹配
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] tmp : pieces) {
            int first = tmp[0];
            List<Integer> list = Arrays.stream(tmp).boxed().collect(Collectors.toList());
            map.put(first, list);
        }

        int i = 0;
        int n = arr.length;
        while (i < n) {
            if (map.containsKey(arr[i])) {
                List<Integer> inner = map.get(arr[i]);
                int size = inner.size();
                for (int j = 0; j < size; j++) {
                    if (arr[i] == map.get(arr[i]).get(j)) {
                        i++;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static TreeNode deserialize(Deque<String> queue) {
        if (queue.isEmpty() || queue.peek().equals("#")) {
            return null;
        }
        int val = Integer.parseInt(queue.poll());
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    public double myPow(double x, int n) {
        // 快速幂
        double ans = 1.0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return ans;
    }

    public static enum T {
        FIR(1, 2),
        SEC(2, 3),
        THI(3, 5),
        FOU(4, 9);

        Map<T, Integer> map = new HashMap<>();


        private int idx;
        private int max;

        T (int idx, int max) {
            this.idx = idx;
            this.max = max;
        }

        public static int ofCode(T t) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>(map.values());
        System.out.println("######################3");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
            sb.append(" ");
        }
        char[] chs = {'1', '2', '3'};
        String s = new String(chs);
        System.out.println(s);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        System.out.println(Math.floor(3 / 2));
        String a = "asfa";
        int[] arr = new int[10];
        int[] arr1 = new int[10];
        Arrays.fill(arr, 1);
        Arrays.fill(arr1, 10);
        int[] res = new int[20];
        System.arraycopy(arr,0, res, 0,10);
        System.arraycopy(arr1,0, res, 10,10);
        for (int re : res) {
            System.out.println(re);
        }
//        String arr = "1,2,#,#,3,4,#,#,5,#,#,";
//        Deque<String> queue = new ArrayDeque<>();
//        String[] tmp = arr.split(",");
//        queue.addAll(Arrays.asList(tmp));
//        while (!queue.isEmpty()) {
//            System.out.print(queue.peek() + " " + queue.pop());
//            System.out.println();
//        }
//        int[] a = new int[10];
//        System.out.println(a[10]);
//        deserialize(queue);

//        LinkedList<Integer> list = new LinkedList<>();
//        list.addLast(1);
//        list.addFirst(1);
//        numSquares(1);
//        System.out.println(Integer.bitCount(4));
//        Test ex = new Test();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//        String[] arr = {"a!=b", "a==b"};
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("ab");
//        list.add("abc");
//        list.add("c");
//        Collections.sort(list);
//        System.out.println(list);
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.addAll(nums);
//        nums.add(3, 4);
//        System.out.println(nums);
//        System.out.println(255 & 255);
//        System.out.println(Integer.toBinaryString(192));
//        System.out.println(Integer.toBinaryString(52));
//        System.out.println(192 & 52);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Math.pow(2,31));
//        int a = 4;
//        int sqrt = (int)Math.sqrt(a);
//        if (sqrt * sqrt == a) {
//            System.out.println("yes");
//        } else {
//            System.out.println("no");
//        }
//        int[] array = {2, 1, 3};
//        int[] ints = Arrays.copyOf(array, array.length);
//        int a = (int) Math.sqrt(20);
//        int asInt = Arrays.stream(array).max().getAsInt();
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(29846387);
//        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
//        Collections.sort(list);
//        System.out.println(list);
//        System.out.println(countAndSay(4));
//        long e = 1000;
//        String.valueOf(e);
//        Map<Integer, Integer> mapHash = new HashMap<>();
//        Map<Integer, Integer> mapTree = new TreeMap<>();
//        for (int i = 0; i < 100; i++) {
//            // [0, 1)
//            int key = (int)(Math.random() * 1000) + 1;
//            mapHash.put(key, 1);
//            mapTree.put(key, 2);
//        }
//        Deque<Integer> deque = new LinkedList<>();
//        System.out.println(mapHash.keySet());
//        System.out.println(mapTree.keySet());
    }
}
