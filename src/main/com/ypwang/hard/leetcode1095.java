package com.ypwang.hard;

public class leetcode1095 {
    interface MountainArray {
        int get(int index);
        int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // find breakpoint
        int l = 0;
        int r = mountainArr.length() - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (mountainArr.get(m) < mountainArr.get(m+1)) l = m + 1;
            else r = m;
        }

        int peak = l;
        l = 0;
        r = peak;

        while (l <= r) {
            int m = (l + r) / 2;
            int value = mountainArr.get(m);
            if (value < target) l = m + 1;
            else if (value > target) r = m - 1;
            else return m;
        }

        l = peak;
        r = mountainArr.length() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int value = mountainArr.get(m);
            if (value < target) r = m - 1;
            else if (value > target) l = m + 1;
            else return m;
        }

        return -1;
    }

    static class Test implements MountainArray {
        private int[] inner;

        Test(int[] p) {
            inner = p;
        }

        @Override
        public int get(int index) {
            return inner[index];
        }

        @Override
        public int length() {
            return inner.length;
        }
    }

    public static void main(String[] args) {
        System.out.println(new leetcode1095().findInMountainArray(3, new Test(new int[]{1,2,3,4,5,3,1})));
        System.out.println(new leetcode1095().findInMountainArray(3, new Test(new int[]{0,1,2,4,2,1})));
    }
}