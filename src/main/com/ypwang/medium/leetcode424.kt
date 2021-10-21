package com.ypwang.medium

import java.util.*

class Solution424 {
    private class window (val k: Int) {
        private var size: Int = 0
        private var max: Int = 0
        private val eles = mutableMapOf<Char, Int>()
        private val elel: Queue<Char> = LinkedList<Char>()

        fun feed(c: Char) {
            size++
            elel.offer(c)
            eles[c] = eles.getOrDefault(c, 0) + 1
            val m = eles.maxByOrNull { it.value }!!

            if (m.value + k < size) {
                val pc = elel.poll()
                val pcc = eles[pc]!! - 1

                if (pcc == 0) {
                    eles.remove(pc)
                } else {
                    eles[pc] = pcc
                }

                size--
                if (pc != m.key) {
                    assert(m.value + k == size)
                } else {
                    while (eles.maxByOrNull { it.value }!!.value + k < size) {
                        val pc = elel.poll()
                        val pcc = eles[pc]!! - 1

                        if (pcc == 0) {
                            eles.remove(pc)
                        } else {
                            eles[pc] = pcc
                        }

                        size--
                    }
                }
            }

            if (size > max)
                max = size
        }

        fun max(): Int = max
    }

    fun characterReplacement(s: String, k: Int): Int {
        val w = window(k)

        for (c in s) {
            w.feed(c)
        }

        return w.max()
    }
}

fun main() {
    println(Solution424().characterReplacement("ABAB", 2))
}