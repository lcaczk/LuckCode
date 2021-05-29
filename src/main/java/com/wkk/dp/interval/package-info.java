package com.wkk.dp.interval;

/**
 * @author weikunkun
 * @since 2021/5/12
 */
// 第一类区间模型整理
// 给出一个序列，明确要求需要分割为K个连续区间，计划这些区间的某个最优性质
// dp[i][k] : s[1:i]分成k个区间，能够得到的最优解
