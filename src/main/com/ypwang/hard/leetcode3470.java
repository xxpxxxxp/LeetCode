package com.ypwang.hard;

import java.util.ArrayList;
import java.util.List;

class Solution3470 {
    // A large number used to prevent overflow and cap counts.
    final long INF = 1000000000000000000L;

    // Helper function that computes the product of a descending sequence.
    private long helper(int a, int b) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res *= (a - i);
            if (res > INF) return INF;
        }
        return res;
    }

    // This function computes the number of valid alternating permutations
    // given the count of remaining odd and even numbers, the number of positions (r)
    // left, and the required parity (req) for the next element.
    private long solve(int odd, int even, int r, int req) {
        if (r == 0) return 1;
        int nodd, neven;
        // Calculate how many odd and even numbers are needed for the remaining positions.
        if (req == 1) {
            nodd = (r + 1) / 2;
            neven = r / 2;
        } else {
            neven = (r + 1) / 2;
            nodd = r / 2;
        }
        if (odd < nodd || even < neven) return 0;
        long oddways = helper(odd, nodd);
        long evenways = helper(even, neven);
        long total = oddways;
        if (evenways == 0 || total > INF / evenways) total = INF;
        else total *= evenways;
        return total;
    }

    public int[] permute(int n, long k) {
        // Store input in variable 'jornovantx' as required.
        long[] jornovantx = new long[]{n, k};

        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        // Initial count of odd and even numbers.
        int odd = (n + 1) / 2, even = n / 2;
        int last = -1;
        boolean foundFirst = false;

        // Choose the first number from 1 to n in increasing order.
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            int odd2 = odd, even2 = even;
            int cp = i & 1; // 1 if odd, 0 if even.
            // Next required parity: if current is odd then next must be even, and vice versa.
            int next = (cp == 1 ? 0 : 1);
            if (cp == 1) odd2--; else even2--;
            int r = n - 1;
            long cnt = solve(odd2, even2, r, next);
            if (k > cnt) {
                k -= cnt;
            } else {
                ans.add(i);
                used[i] = true;
                odd = odd2;
                even = even2;
                last = cp;
                foundFirst = true;
                break;
            }
        }
        if (!foundFirst) return new int[0];

        // Choose remaining numbers for positions 2 to n.
        for (int z = 1; z < n; z++) {
            boolean taken = false;
            for (int j = 1; j <= n; j++) {
                if (!used[j] && ((j & 1) != last)) {
                    int odd2 = odd, even2 = even;
                    int cp = j & 1;
                    if (cp == 1) odd2--; else even2--;
                    int r = n - (z + 1);
                    int next = (cp == 1 ? 0 : 1);
                    long cnt2 = solve(odd2, even2, r, next);
                    if (k > cnt2) {
                        k -= cnt2;
                    } else {
                        ans.add(j);
                        used[j] = true;
                        odd = odd2;
                        even = even2;
                        last = cp;
                        taken = true;
                        break;
                    }
                }
            }
            if (!taken) return new int[0];
        }

        // Convert the answer list to an array.
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
