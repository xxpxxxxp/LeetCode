package com.ypwang.hard

import java.lang.StringBuilder

class Solution273 {
    private val nums = arrayOf(90,80,70,60,50,40,30,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1)
    private val english = arrayOf("Ninety","Eighty","Seventy","Sixty","Fifty","Forty","Thirty","Twenty",
            "Nineteen","Eighteen","Seventeen","Sixteen","Fifteen","Fourteen","Thirteen","Twelve","Eleven",
            "Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two","One")
    private val levels = arrayOf(1000000000 to "Billion ", 1000000 to "Million ", 1000 to "Thousand ")

    private fun helper(num: Int): String {
        val sb = StringBuilder()
        if (num >= 100) {
            val hundred = num / 100
            sb.append(english[nums.binarySearch(hundred, Comparator{ a: Int, b: Int -> b - a })])
            sb.append(' ')
            sb.append("Hundred ")
        }

        var left = num % 100
        while (left != 0) {
            val t = nums.binarySearch(left, Comparator{ a: Int, b: Int -> b - a }).let {
                if (it >= 0) it
                else -it-1
            }
            sb.append(english[t])
            sb.append(' ')
            left -= nums[t]
        }

        return sb.toString()
    }

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"

        val sb = StringBuilder()
        var n = num
        for (level in levels) {
            if (n >= level.first) {
                sb.append(helper(n / level.first))
                sb.append(level.second)
            }
            n %= level.first
        }

        if (n != 0) sb.append(helper(n))
        return sb.toString().dropLast(1)
    }
}

fun main() {
    println(Solution273().numberToWords(123))
    println(Solution273().numberToWords(12345))
    println(Solution273().numberToWords(1234567))
    println(Solution273().numberToWords(1234567891))
}