package com.wkk.simulation.xp;

/**
 * @author weikunkun
 * @since 2021/9/6
 */
public class B {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * <p>
     * <p>
     * 计算express结果值满足desired的组合种类数
     *
     * @param express string字符串 express字符串
     * @param desired bool布尔型 预期结果
     * @return long长整型
     */
    public long mod = (long) 1e9 + 7;

    public long GetNumOfExpress(String express, boolean desired) {
        // write code here
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        long[][] t = new long[exp.length][exp.length];
        long[][] f = new long[exp.length][exp.length];
        for (int i = 0; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '1' ? 1 : 0;
            f[i][i] = exp[i] == '0' ? 1 : 0;
        }
        for (int i = 2; i < exp.length; i += 2) {
            for (int j = 0; j < exp.length - i; j += 2) {
                // j ... i+j
                t[j][i + j] = 0;
                f[j][i + j] = 0;
                for (int k = 0; k < i; k += 2) {
                    if (exp[j + k + 1] == '^') {
                        t[j][i + j] += ((t[j][j + k] * f[j + k + 2][i + j]) % mod + (f[j][j + k] * t[j + k + 2][i + j]) % mod) % mod;
                        t[j][i + j] %= mod;
                        f[j][i + j] += ((t[j][j + k] * t[j + k + 2][i + j]) % mod + (f[j][j + k] * f[j + k + 2][i + j]) % mod) % mod;
                        f[j][i + j] %= mod;
                    } else if (exp[j + k + 1] == '&') {
                        t[j][i + j] += ((t[j][j + k] * t[j + k + 2][i + j]) % mod) % mod;
                        t[j][i + j] %= mod;
                        f[j][i + j] += ((t[j][j + k] * f[j + k + 2][i + j]) % mod + (f[j][j + k] * t[j + k + 2][i + j]) % mod + (f[j][j + k] * f[j + k + 2][i + j]) % mod) % mod;
                        f[j][i + j] %= mod;
                    } else if (exp[j + k + 1] == '|') {
                        t[j][i + j] += ((t[j][j + k] * f[j + k + 2][i + j]) % mod + (f[j][j + k] * t[j + k + 2][i + j]) % mod + (t[j][j + k] * t[j + k + 2][i + j]) % mod) % mod;
                        t[j][i + j] %= mod;
                        f[j][i + j] += ((f[j][j + k] * f[j + k + 2][i + j]) % mod) % mod;
                        f[j][i + j] %= mod;
                    }
                }
            }
        }
        return desired ? t[0][exp.length - 1] : f[0][exp.length - 1];
    }


    public boolean isValid(char[] exp) {
        if (exp.length % 2 == 0) {
            return false;
        }
        for (int i = 0; i < exp.length; i += 2) {
            if (exp[i] != '0' && exp[i] != '1') {
                return false;
            }
        }
        for (int i = 1; i < exp.length; i += 2) {
            if (exp[i] != '^' && exp[i] != '&' && exp[i] != '|') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.GetNumOfExpress("1^0|0|1", false));
    }

}
