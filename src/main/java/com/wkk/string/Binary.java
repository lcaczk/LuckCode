package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/9/24
 */
public class Binary {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        String eight = cal(num, 2);
//        String sixteen = cal(num, 16);
//        System.out.println(eight + " " + sixteen);
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toHexString(20));
    }

    public static String cal(int num, int ope) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            for (int i = 0; i < 8; i++) {
                sb.append(0);
            }
            return sb.toString();
        }
        boolean isNeg = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % ope);
            num /= ope;
        }
        if (isNeg) {
            while (sb.length() < 7) {
                sb.append(0);
            }
            sb.append("-");
        } else {
            while (sb.length() < 8) {
                sb.append(0);
            }
        }
        return sb.reverse().toString();
    }
}
