package com.ypwang.easy

class Solution2525 {
    private val len = 10000
    private val vol = 1000000000
    private val mas = 100
    fun categorizeBox(length: Int, width: Int, height: Int, mass: Int): String {
        val bulky = length >= len || width >= len || height >= len || vol / length / width <= height
        val heavy = mass >= mas

        return if (bulky) {
            if (heavy)
                "Both"
            else
                "Bulky"
        } else {
            if (heavy)
                "Heavy"
            else
                "Neither"
        }
    }
}

fun main() {
    println(Solution2525().categorizeBox(1000,35,700,300))
}