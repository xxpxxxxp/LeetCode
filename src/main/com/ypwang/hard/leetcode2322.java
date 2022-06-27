package com.ypwang.hard;

import java.util.*;

class Solution2322 {
    int[] xors;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Set<Integer>> subTree = new HashMap<>();

    public int minimumScore(int[] nums, int[][] edges) {
        int total = 0;
        int n = nums.length;
        xors = new int[n];
        for (int num : nums) {
            total = total ^ num;
        }

        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            var list = map.getOrDefault(u, new ArrayList<>());
            list.add(v);
            map.put(u, list);

            list = map.getOrDefault(v, new ArrayList<>());
            list.add(u);

            map.put(v, list);
        }

        go (0, -1, nums);
        populateSubTree(0, -1);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int t1, t2, t3;

                if (subTree.get(i).contains(j)) {
                    // i is the parent of j
                    t1 = xors[0] ^ xors[i];
                    t2 = xors[j];
                    t3 = xors[0] ^ t1 ^ t2;
                } else if (subTree.get(j).contains(i)) {
                    // j is the parent of i
                    t1 = xors[i];
                    t2 = xors[0] ^ xors[j];
                    t3 = xors[0] ^ t1 ^ t2;
                } else {
                    t1 = xors[j];
                    t2 = xors[i];
                    t3 = xors[0] ^ t1 ^ t2;
                }

                int max_t = Math.max(Math.max(t1, t2), t3);
                int min_t = Math.min(Math.min(t1, t2), t3);
                min = Math.min(min, max_t - min_t);
            }
        }
        return min;
    }

    Set<Integer> populateSubTree(int index, int p_index) {
        Set<Integer> result = new HashSet<>();
        result.add(index);
        for (var node : map.getOrDefault(index, new ArrayList<>())) {
            if (p_index != node) {
                var childSet = populateSubTree(node, index);
                result.addAll(childSet);
            }
        }
        subTree.put(index, result);
        return result;
    }

    int go(int index, int p_index, int[] nums) {
        xors[index] = nums[index];
        for (var node : map.getOrDefault(index, new ArrayList<>())) {
            if (p_index != node) {
                xors[index] = xors[index] ^ go(node, index, nums);
            }
        }
        return xors[index];
    }
}