package com.ypwang.medium;

import java.util.HashSet;

class Solution565 {
    public int arrayNesting(int[] nums) {
        HashSet<Integer> used = new HashSet<>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                HashSet<Integer> current = new HashSet<>();
                int j = i;
                while (!current.contains(j)) {
                    current.add(j);
                    used.add(j);
                    j = nums[j];
                }
                if (current.size() > max) {
                    max = current.size();
                }
            }
        }

        return max;
    }
}