package com.ypwang.hard;

import java.util.ArrayList;
import java.util.List;

class Solution4107 {
    static class SegmentTree {
        long noPeak;
        int first, last, low, high;

        SegmentTree(long noPeak, int first, int last, int low, int high) {
            this.noPeak = noPeak;
            this.first = first;
            this.last = last;
            this.low = low;
            this.high = high;
        }
    }

    private long[] noPeakPairs;
    private int[] firstPeak;
    private int[] lastPeak;

    public long[] countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isPeak = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == n-1) {
                isPeak[i] = false;
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                isPeak[i] = true;
            }
        }

        noPeakPairs = new long[4 * n];
        firstPeak = new int[4 * n];
        lastPeak = new int[4 * n];
        build(1, 0, n - 1, isPeak);

        List<Long> answer = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int left = query[1], right = query[2];
                long size = right - left + 1;
                long totalPairs = size * (size - 1) / 2;
                answer.add(totalPairs - search(1, 0, n - 1, left, right).noPeak);
            } else {
                int idx = query[1];
                nums[idx] = query[2];
                for (int i = idx - 1; i <= idx + 1; i++) {
                    if (i >= 0 && i < n && isPeak[i] != peakAt(i, n, nums)) {
                        isPeak[i] = !isPeak[i];
                        update(1, 0, n - 1, i, isPeak);
                    }
                }
            }
        }

        long[] ans = new long[answer.size()];

        return answer.stream().mapToLong(Long::longValue).toArray();
    }

    private boolean peakAt(int k, int n, int[] nums) {
        return k > 0 && k < n - 1 && nums[k] > nums[k - 1] && nums[k] > nums[k + 1];
    }

    private void build(int node, int low, int high, boolean[] isPeak) {
        if (low == high) {
            setLeaf(node, low, isPeak);
            return;
        }
        int mid = low + (high - low) / 2;
        build(2 * node, low, mid, isPeak);
        build(2 * node + 1, mid + 1, high, isPeak);
        pull(node, low, mid, high);
    }

    private void update(int node, int low, int hi, int position, boolean[] isPeak) {
        if (low == hi) {
            setLeaf(node, low, isPeak);
            return;
        }
        int mid = low + (hi - low) / 2;
        if (position <= mid) {
            update(2 * node, low, mid, position, isPeak);
        } else {
            update(2 * node + 1, mid + 1, hi, position, isPeak);
        }
        pull(node, low, mid, hi);
    }

    private void setLeaf(int node, int index, boolean[] isPeak) {
        noPeakPairs[node] = 0;
        if (isPeak[index]) {
            firstPeak[node] = index;
            lastPeak[node] = index;
        } else {
            firstPeak[node] = -1;
            lastPeak[node] = -1;
        }
    }

    private void pull(int node, int low, int mid, int high) {
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        long validStarts;
        if (lastPeak[leftChild] == -1) {
            validStarts = mid - low + 1;
        } else {
            validStarts = mid - lastPeak[leftChild] + 1;
        }

        long validEnds;
        if (firstPeak[rightChild] == -1) {
            validEnds = high - mid;
        } else {
            validEnds = firstPeak[rightChild] - mid;
        }

        noPeakPairs[node] = noPeakPairs[leftChild] + noPeakPairs[rightChild]
        + validStarts * validEnds;

        firstPeak[node] = firstPeak[leftChild] != -1 ? firstPeak[leftChild] : firstPeak[rightChild];
        lastPeak[node] = lastPeak[rightChild] != -1 ? lastPeak[rightChild] : lastPeak[leftChild];
    }

    private SegmentTree search(int node, int low, int high, int leftQuer, int rightQuery) {
        if (leftQuer <= low && high <= rightQuery) {
            return new SegmentTree(noPeakPairs[node], firstPeak[node], lastPeak[node], low, high);
        }

        int mid = low + (high - low ) / 2;
        if (rightQuery <= mid) {
            return search(2 * node, low, mid, leftQuer, rightQuery);
        }
        if (leftQuer > mid) {
            return search(2 * node + 1, mid + 1, high, leftQuer, rightQuery);
        }

        return combine(search(2 * node, low, mid, leftQuer, rightQuery),
            search(2 * node + 1, mid + 1, high, leftQuer, rightQuery));
    }

    private SegmentTree combine(SegmentTree a, SegmentTree b) {
        long validLeft;
        if ( a.last == -1 ) {
            validLeft = a.high - a.low + 1;
        } else {
            validLeft = a.high - a.last + 1;
        }
        long validRight ;
        if  (b.first == -1 ) {
            validRight = b.high - b.low + 1;
        } else {
            validRight = b.first - b.low + 1;
        }

        return new SegmentTree(a.noPeak + b.noPeak + validLeft * validRight, a.first != -1 ? a.first : b.first, b.last != -1 ? b.last : a.last, a.low, b.high);
    }
}
