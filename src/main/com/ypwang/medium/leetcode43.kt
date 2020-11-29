package com.ypwang.medium

class Solution43 {
    // num1 must be reverted
    fun multiSingle(num1: List<Int>, num2: Int, indent: Int): List<Int> {
        val rst = MutableList(indent){0}
        var carry = 0
        for (n in num1) {
            val mul = n * num2 + carry
            rst.add(mul % 10)
            carry = mul / 10
        }
        if (carry != 0) {
            rst.add(carry)
        }
        return rst
    }

    fun sumup(nums: List<List<Int>>): List<Int> {
        val rst = mutableListOf<Int>()
        var carry = 0

        val iterators = nums.map { it.iterator() }

        while (iterators.any { it.hasNext() }) {
            val sum = iterators.map { if (it.hasNext()) it.next() else 0 }.sum() + carry
            rst.add(sum % 10)
            carry = sum / 10
        }

        while (carry != 0) {
            rst.add(carry % 10)
            carry /= 10
        }

        return rst
    }

    fun multiply(num1: String, num2: String): String {
        val n1 = num1.map { it.toInt() - '0'.toInt() }.reversed()
        val rst = sumup(num2.withIndex().map {
            multiSingle(n1, it.value.toInt() - '0'.toInt(), num2.length - it.index - 1)
        }).reversed().dropWhile { it == 0 }.joinToString("")
        return if (rst.isEmpty()) "0" else rst
    }
}

fun main() {
    println(Solution43().multiply("123", "456"))
}