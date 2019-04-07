package com.ypwang.medium

import java.util.*

class Solution735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()

        for (a in asteroids) {
            if (stack.isEmpty() || a > 0 || stack.peek() < 0) {
                stack.add(a)
            } else {
                // a < 0 definitely
                while (true) {
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.add(a)
                        break
                    }

                    val last = stack.peek()
                    if (last > -a) {
                        // a explode
                        break
                    } else if (last == -a) {
                        // a and last explode
                        stack.pop()
                        break
                    } else {
                        // last explode
                        stack.pop()
                    }
                }
            }
        }

        return stack.toTypedArray().toIntArray()
    }
}

fun main() {
    println(Solution735().asteroidCollision(intArrayOf(5, 10, -5)).toList())
    println(Solution735().asteroidCollision(intArrayOf(8, -8)).toList())
    println(Solution735().asteroidCollision(intArrayOf(10, 2, -5)).toList())
    println(Solution735().asteroidCollision(intArrayOf(-2, -1, 1, 2)).toList())
}