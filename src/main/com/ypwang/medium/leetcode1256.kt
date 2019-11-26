package com.ypwang.medium

class Solution1256 {
    fun encode(num: Int): String = (num + 1).toString(2).substring(1)
}

fun main() {
    for (i in 0..107) {
        println("$i -> ${Solution1256().encode(i)}")
    }
}