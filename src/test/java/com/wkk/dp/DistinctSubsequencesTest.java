package com.wkk.dp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author kongwiki@163.com
 * @since 2020/9/7 9:13 下午
 */
public class DistinctSubsequencesTest {
    DistinctSubsequences subsequences = new DistinctSubsequences();
    @Test
    public void numDistinct() {
        String s = "rabbbit";
        String t = "rabbit";
        subsequences.numDistinct(s, t);
    }
}