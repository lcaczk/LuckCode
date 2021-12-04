package com.wkk.interview.bytedance2021.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354 俄罗斯套娃信封
 * 思路： 详见程序员代码面试指南216
 * @author weikunkun
 * @since 2021/4/2
 */
public class LC_354 {
    public int maxEnvelopes(int[][] envelopes) {
        // 思路
        // 封装一个信封对象，然后按照信封的宽度进行排序 小-大
        // 如果宽度相同，按照高度排序 大到小
        // 之后 对 高度序列 求最长递增子序列即可
        Envelope[] array = genEnvelope(envelopes);
        int[] heights = genHeightArray(array);
        int[] dp = new int[heights.length];
        Arrays.fill(dp, 1);
        int maxNumber = 0;
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            int j = 0;
            int max = 0;
            while (j < i) {
                if (heights[j] < cur) {
                    max = Math.max(max, dp[j]);
                }
                j++;
            }
            dp[i] = max + 1;
            maxNumber = Math.max(dp[i], maxNumber);
        }
        return maxNumber;

    }

    private Envelope[] genEnvelope(int[][] envelopes) {
        Envelope[] array = new Envelope[envelopes.length];
        int i = 0;
        for (int[] envelope : envelopes) {
            Envelope env = new Envelope(envelope[0], envelope[1]);
            array[i++] = env;
        }
        Arrays.sort(array, new EnvelopComparetor());
        return array;
    }

    private int[] genHeightArray(Envelope[] array) {
        int[] heights = new int[array.length];
        int i = 0;
        for (Envelope envelope : array) {
            heights[i++] = envelope.height;
        }
        return heights;
    }


}

// 构建一个信封对象
class Envelope {
    public int wight;
    public int height;

    public Envelope(int wight, int height) {
        this.wight = wight;
        this.height = height;
    }
}

class EnvelopComparetor implements Comparator<Envelope> {
    @Override
    public int compare(Envelope o1, Envelope o2) {
        return o1.wight != o2.wight ? o1.wight - o2.wight : o2.height - o1.height;
    }
}

