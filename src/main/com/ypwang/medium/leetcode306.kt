package com.ypwang.medium

import java.util.*

class Solution306 {
    fun isAdditiveNumber(num: String): Boolean {
        val digits = num.map { it - '0' }.toTypedArray()

        fun check(first: Long, second: Long, left: Int): Boolean {
            if (left == digits.size) return true
            if (digits[left] == 0) return (left == digits.lastIndex && first == 0L && second == 0L)

            val next = first + second
            var n = next
            val stack = Stack<Int>()
            while (n != 0L) {
                stack.push((n % 10L).toInt())
                n /= 10
            }

            var idx = left
            while (stack.isNotEmpty()) {
                if (idx >= digits.size || digits[idx] != stack.pop()) {
                    return false
                }
                idx++
            }

            return check(second, next, idx)
        }

        var first = 0L
        for (i in 0 until digits.size/2) {
            if (first == 0L && i > 0) break
            first = first *10 + digits[i]

            for (j in i+1..(digits.size + i) / 2) {
                var second = 0L
                if (j > i+1 && digits[i+1] == 0) break
                for (k in i+1..j) {
                    second = second * 10 + digits[k]
                }

                if (j+1 >= digits.size) break

                //println("$first, $second, ${num.substring(j+1)}")
                if (check(first, second, j+1))
                    return true
            }
        }

        return false
    }
}

fun main() {
    println(Solution306().isAdditiveNumber("121474836472147483648"))
}