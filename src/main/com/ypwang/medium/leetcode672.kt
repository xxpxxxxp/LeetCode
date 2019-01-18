package com.ypwang.medium

class Solution672 {
    fun flipLights(n: Int, m: Int): Int {
        var lights = 0
        for (i in 1..Math.min(n, 6)) {
            lights = lights or (1 shl i-1)
        }

        val operations = listOf(0b111111, 0b101010, 0b010101, 0b001001)

        var rst = setOf(lights)
        for (i in 1..m) {
            rst = operations.flatMap { op ->
                rst.map { it xor (op and lights) }
            }.toSet()
        }

        return rst.size
    }
}

fun main(args: Array<String>) {
    //println(Solution672().flipLights(1,1))
    println(Solution672().flipLights(2,1))
    println(Solution672().flipLights(3,1))
}