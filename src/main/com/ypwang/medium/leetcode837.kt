//package com.ypwang.medium
//
//import java.util.*
//
//class Solution837 {
//    fun new21Game(N: Int, K: Int, W: Int): Double {
//        val queue = mutableMapOf<Int, Double>()
//        queue.put(0, 1.0)
//
//        var sum = 0.0
//        while (queue.isNotEmpty()) {
//            val t = queue
//
//            if (t.first >= K) {
//                if (t.first > N)
//                    sum += t.second
//            } else {
//                val d = t.second / W
//                queue.addAll((1..W).map { (t.first + it) to d })
//            }
//        }
//
//        return sum
//    }
//}
//
//fun main() {
//    println(Solution837().new21Game(421, 400, 47))
//}