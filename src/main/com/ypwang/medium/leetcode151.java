package com.ypwang.medium;

import java.util.Arrays;
import java.util.Collections;

class Solution151 {
    public String reverseWords(String s) {
        String[] ss = Arrays.stream(s.split(" ")) .filter(it -> !it.isEmpty()).toArray(String[]::new);
        Collections.reverse(Arrays.asList(ss));
        return String.join(" ", ss);
    }
}

public class leetcode151 {
    public static void main(String[] args) {
        System.out.println(new Solution151().reverseWords(" 1"));
    }
}