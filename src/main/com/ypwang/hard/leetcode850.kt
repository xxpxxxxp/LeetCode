//package com.ypwang.hard
//
//class Solution850 {
//    fun rectangleArea(rectangles: Array<IntArray>): Int {
//        val mod = 1000000007
//        val x = mutableSetOf(0)
//        for ((x1, y1, x2, y2) in rectangles) {
//            x.add(x1);
//            x.add(x2);
//        }
//
//        val ux = x.sorted().toTypedArray()
//        val x_i = mutableMapOf<Int, Int>()
//        for (i in ux.indices) {
//            x_i[ux[i]] = i
//        }
//        val count = IntArray(ux.size)
//        val L =
//        vector<int> count(x.size(), 0);
//        vector<vector<int>> L;
//        for (auto r : rectangles) {
//            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
//            L.push_back({y1, x1, x2, 1});
//            L.push_back({y2, x1, x2, -1});
//        }
//        sort(L.begin(), L.end());a/
//        long long cur_y = 0, cur_x_sum = 0, area = 0;
//        for (auto l : L) {
//            long long  y = l[0], x1 = l[1], x2 = l[2], sig = l[3];
//            area = (area + (y - cur_y) * cur_x_sum) % mod;
//            cur_y = y;
//            for (int i = x_i[x1]; i < x_i[x2]; i++)
//            count[i] += sig;
//            cur_x_sum = 0;
//            for (int i = 0; i < x.size(); ++i) {
//            if (count[i] > 0)
//                cur_x_sum += x[i + 1] - x[i];
//        }
//        }
//        return area;
//}
//
//fun main() {
//    println(Solution850().rectangleArea(arrayOf(
//            intArrayOf(0,0,1,1),
//            intArrayOf(2,2,3,3)
//    )))
//
//    println(Solution850().rectangleArea(arrayOf(
//            intArrayOf(0,0,2,2),
//            intArrayOf(1,0,2,3),
//            intArrayOf(1,0,3,1)
//    )))
//
//    println(Solution850().rectangleArea(arrayOf(
//            intArrayOf(0,0,1000000000,1000000000)
//    )))
//}