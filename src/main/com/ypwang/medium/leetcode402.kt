//package com.ypwang.medium
//
//class Solution402 {
//    fun removeKdigits(num: String, k: Int): String {
//        var remove = k
//        var i = 0
//        var j = k
//        val window = num.take(k).toMutableList()
//
//        val rst = mutableListOf<Char>()
//        while (j < num.length) {
//            if (num[i] != window.min()) {
//                // remove this
//                remove--
//            } else {
//                rst.add(num[i])
//            }
//            window.removeAt(0)
//            i++
//        }
//    }
//}