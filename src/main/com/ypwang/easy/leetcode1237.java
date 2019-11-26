package com.ypwang.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    int f(int x, int y);
};

public class leetcode1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> rst = new LinkedList<>();
        int x = 1;
        int y = 1000;

        while (x <= 1000 & y > 0) {
            int r = customfunction.f(x, y);
            if (r == z) {
                rst.add(Arrays.asList(x, y));
                x++;
                y--;
            } else if (r < z) {
                x++;
            } else {
                y--;
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode1237().findSolution((x, y) -> x + y, 5));
        System.out.println(new leetcode1237().findSolution((x, y) -> x * y, 5));
    }
}